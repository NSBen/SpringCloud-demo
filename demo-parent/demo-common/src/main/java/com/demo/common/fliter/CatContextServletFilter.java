package com.demo.common.fliter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.demo.common.cat.CatConstantsExt;
import com.demo.common.cat.CatMsgContext;
import com.dianping.cat.Cat;
import com.dianping.cat.CatConstants;
import com.dianping.cat.message.Message;
import com.dianping.cat.message.Transaction;

/**
 * http协议传输，远程调用链目标端接收context的filter，
 * 通过header接收rootId、parentId、childId并放入CatContextImpl中，调用Cat.logRemoteCallServer()进行调用链关联
 * 注:若不涉及调用链，则直接使用cat-client.jar中提供的filter即可 使用方法（视项目框架而定）：
 * 1、web项目：在web.xml中引用此filter 2、Springboot项目，通过注入bean的方式注入此filter
 */
public class CatContextServletFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	/**
	 * 需要过滤的url
	 */
	private Set<String> allowedPaths = new HashSet<>();

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;

		String uri = request.getRequestURI();

		String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
		boolean allowedPath = allowedPaths.contains(path);

		if (allowedPath) {// 排除
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}
		
		// 若header中有context相关属性，则生成调用链，若无，仅统计请求的Transaction
		if (null != request.getHeader(CatConstantsExt.CAT_HTTP_HEADER_ROOT_MESSAGE_ID)) {
			CatMsgContext catContext = new CatMsgContext();
			catContext.addProperty(Cat.Context.ROOT,
					request.getHeader(CatConstantsExt.CAT_HTTP_HEADER_ROOT_MESSAGE_ID));
			catContext.addProperty(Cat.Context.PARENT,
					request.getHeader(CatConstantsExt.CAT_HTTP_HEADER_PARENT_MESSAGE_ID));
			catContext.addProperty(Cat.Context.CHILD,
					request.getHeader(CatConstantsExt.CAT_HTTP_HEADER_CHILD_MESSAGE_ID));
			System.out.println("Cat.Context.ROOT:"+catContext.getProperty(Cat.Context.ROOT));
			System.out.println("Cat.Context.PARENT:"+catContext.getProperty(Cat.Context.PARENT));
			System.out.println("Cat.Context.CHILD:"+catContext.getProperty(Cat.Context.CHILD));
			Cat.logRemoteCallServer(catContext);
			System.out.println("Cat.Context.ROOT:"+catContext.getProperty(Cat.Context.ROOT));
			System.out.println("Cat.Context.PARENT:"+catContext.getProperty(Cat.Context.PARENT));
			System.out.println("Cat.Context.CHILD:"+catContext.getProperty(Cat.Context.CHILD));
		}

		Transaction filterTransaction = Cat.newTransaction(CatConstants.TYPE_URL, uri);

		try {
			Cat.logEvent(CatConstantsExt.Type_URL_METHOD, request.getMethod(), Message.SUCCESS,
					request.getRequestURL().toString());
			Cat.logEvent(CatConstantsExt.Type_URL_CLIENT, request.getRemoteHost());

			filterChain.doFilter(servletRequest, servletResponse);

			filterTransaction.setSuccessStatus();
		} catch (Exception e) {
			filterTransaction.setStatus(e);
			Cat.logError(e);
		} finally {
			filterTransaction.complete();
		}
	}

	@Override
	public void destroy() {

	}

	public Set<String> getAllowedPaths() {
		return allowedPaths;
	}

	public void setAllowedPaths(Set<String> allowedPaths) {
		this.allowedPaths = allowedPaths;
	}

}
