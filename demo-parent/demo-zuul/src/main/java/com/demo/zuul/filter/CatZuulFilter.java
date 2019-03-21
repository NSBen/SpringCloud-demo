package com.demo.zuul.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.common.cat.CatConstantsExt;
import com.demo.common.cat.CatMsgContext;
import com.dianping.cat.Cat;
import com.dianping.cat.CatConstants;
import com.dianping.cat.message.Message;
import com.dianping.cat.message.Transaction;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

public class CatZuulFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// 是否拦截
		System.out.println("进来了Filter");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO 埋点
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpServletResponse response = ctx.getResponse();
		String uri = request.getRequestURI();

		// 若header中有context相关属性，则生成调用链，若无，仅统计请求的Transaction
		if (null != request.getHeader(CatConstantsExt.CAT_HTTP_HEADER_ROOT_MESSAGE_ID)) {
			CatMsgContext catContext = new CatMsgContext();
			catContext.addProperty(Cat.Context.ROOT,
					request.getHeader(CatConstantsExt.CAT_HTTP_HEADER_ROOT_MESSAGE_ID));
			catContext.addProperty(Cat.Context.PARENT,
					request.getHeader(CatConstantsExt.CAT_HTTP_HEADER_PARENT_MESSAGE_ID));
			catContext.addProperty(Cat.Context.CHILD,
					request.getHeader(CatConstantsExt.CAT_HTTP_HEADER_CHILD_MESSAGE_ID));
			Cat.logRemoteCallServer(catContext);
		} else {
			CatMsgContext catContext = new CatMsgContext();
			Cat.logRemoteCallClient(catContext, Cat.getManager().getDomain());
			ctx.addZuulRequestHeader(CatConstantsExt.CAT_HTTP_HEADER_ROOT_MESSAGE_ID,
					catContext.getProperty(Cat.Context.ROOT));
			ctx.addZuulRequestHeader(CatConstantsExt.CAT_HTTP_HEADER_PARENT_MESSAGE_ID,
					catContext.getProperty(Cat.Context.PARENT));
			ctx.addZuulRequestHeader(CatConstantsExt.CAT_HTTP_HEADER_CHILD_MESSAGE_ID,
					catContext.getProperty(Cat.Context.CHILD));
		}

		Transaction transaction = Cat.newTransaction(CatConstants.TYPE_URL, uri);

		Cat.logEvent(CatConstantsExt.Type_URL_METHOD, request.getMethod(), Message.SUCCESS,
				request.getRequestURL().toString());
		Cat.logEvent(CatConstantsExt.Type_URL_CLIENT, request.getRemoteHost());

		transaction.setSuccessStatus();
		transaction.complete();

		return null;
	}

	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// 优先级
		return 0;
	}

	boolean isaaa;

}
