package com.demo.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.demo.common.cat.CatMsgConstants;
import com.demo.common.cat.CatMsgContext;
import com.dianping.cat.Cat;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * AOP埋点  把消息树传到远端
 * @author wushiyu
 *
 */
//@Component
public class FeignCatAnnotationInterceptor implements RequestInterceptor {

	private Logger logger = LoggerFactory.getLogger(FeignCatAnnotationInterceptor.class);

	@Override
	public void apply(RequestTemplate requestTemplate) {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		String rootId = requestAttributes.getAttribute(Cat.Context.ROOT, 0)+"";
		String childId = requestAttributes.getAttribute(Cat.Context.CHILD, 0)+"";
		String parentId = requestAttributes.getAttribute(Cat.Context.PARENT, 0)+"";
		
		Cat.Context context = new CatMsgContext();
		context.addProperty(Cat.Context.ROOT, rootId);
		context.addProperty(Cat.Context.PARENT, parentId);
		context.addProperty(Cat.Context.CHILD, childId);
		//远程调用之前生成child节点id
		Cat.logRemoteCallClient(context);
		
		requestTemplate.header(Cat.Context.ROOT, context.getProperty(Cat.Context.ROOT));
		requestTemplate.header(Cat.Context.CHILD, context.getProperty(Cat.Context.CHILD));
		requestTemplate.header(Cat.Context.PARENT, context.getProperty(Cat.Context.PARENT));
		requestTemplate.header(CatMsgConstants.APPLICATION_KEY, Cat.getManager().getDomain());
	}

}
