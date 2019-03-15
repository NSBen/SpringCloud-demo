package com.demo.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.demo.common.cat.CatMsgConstants;
import com.demo.common.cat.CatMsgContext;
import com.dianping.cat.Cat;

//@Aspect
//@EnableAspectJAutoProxy
//@Configuration
public class CatMsgIdAspectBean {

	private Logger logger = LoggerFactory.getLogger(CatMsgIdAspectBean.class);

	//切点要根据实际情况配置
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		createMessageTree();
		Object proceed = pjp.proceed();
		return proceed;
	}

	/**
	 * 统一设置消息编号的messageId
	 */
	private void createMessageTree() {
		CatMsgContext context = new CatMsgContext();
		Cat.logRemoteCallClient(context);
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		requestAttributes.setAttribute(Cat.Context.PARENT, context.getProperty(Cat.Context.PARENT), 0);
		requestAttributes.setAttribute(Cat.Context.ROOT, context.getProperty(Cat.Context.ROOT), 0);
		requestAttributes.setAttribute(Cat.Context.CHILD, context.getProperty(Cat.Context.CHILD), 0);
		requestAttributes.setAttribute(CatMsgConstants.APPLICATION_KEY, Cat.getManager().getDomain(), 0);
	}
}
