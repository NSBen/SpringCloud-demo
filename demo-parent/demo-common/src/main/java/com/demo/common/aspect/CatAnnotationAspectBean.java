package com.demo.common.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.demo.common.cat.CatMsgConstants;
import com.demo.common.cat.CatMsgContext;
import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import com.dianping.cat.message.internal.AbstractMessage;
import com.dianping.cat.message.internal.NullMessage;

/**
 * cat AOP埋点   要结合FeignCatAnnotationInterceptor使用
 * @author wushiyu
 *
 */
@Aspect
@EnableAspectJAutoProxy
@Configuration
public class CatAnnotationAspectBean {

	private static final Logger logger = LoggerFactory.getLogger(CatAnnotationAspectBean.class);

	@Pointcut("@annotation(com.demo.common.annotation.CatAnnotation)")
	public void cutPoint() {
	};

	@Around("cutPoint()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("拦截到了" + pjp.getSignature().getName() + "方法...");
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attrs.getRequest();
		String requestURI = request.getRequestURI();
		Transaction t = Cat.newTransaction(CatMsgConstants.CROSS_SERVER, requestURI);
		try {
			// 判断一下有没有从上下文传消息树过来
			String header = request.getHeader(Cat.Context.ROOT);
			if (StringUtils.isEmpty(header)) {
				createClientMessageTree();
			} else {
				createServerMessageTree(request);
			}
			this.createProviderCross(request, t);
			Object proceed = pjp.proceed();
			t.setStatus(Transaction.SUCCESS);
			return proceed;
		} catch (Exception e) {
			logger.error("------ Get cat msgtree error : ", e);

			Event event = Cat.newEvent("HTTP_REST_CAT_ERROR", requestURI);
			event.setStatus(e);
			completeEvent(event);
			t.addChild(event);
			t.setStatus(e.getClass().getSimpleName());
			return null;
		} finally {
			t.complete();
		}

	}

	/**
	 * 设置客户端消息树
	 */
	private void createClientMessageTree() {
		CatMsgContext context = new CatMsgContext();
		Cat.logRemoteCallClient(context);
		rpcContext(context);
	}

	/**
	 * 设置服务端消息树
	 * 
	 * @param request
	 */
	private void createServerMessageTree(HttpServletRequest request) {
		Cat.Context context = new CatMsgContext();
		context.addProperty(Cat.Context.ROOT, request.getHeader(Cat.Context.ROOT));
		context.addProperty(Cat.Context.PARENT, request.getHeader(Cat.Context.PARENT));
		context.addProperty(Cat.Context.CHILD, request.getHeader(Cat.Context.CHILD));
		Cat.logRemoteCallServer(context);
		rpcContext(context);
	}

	/**
	 * 把消息树带到RequestContextHolder
	 * 
	 * @param context
	 */
	private void rpcContext(Cat.Context context) {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		requestAttributes.setAttribute(Cat.Context.PARENT, context.getProperty(Cat.Context.PARENT), 0);
		requestAttributes.setAttribute(Cat.Context.ROOT, context.getProperty(Cat.Context.ROOT), 0);
		requestAttributes.setAttribute(Cat.Context.CHILD, context.getProperty(Cat.Context.CHILD), 0);
		requestAttributes.setAttribute(CatMsgConstants.APPLICATION_KEY, Cat.getManager().getDomain(), 0);

		System.out.println("PARENT:" + context.getProperty(Cat.Context.PARENT));
		System.out.println("CHILD:" + context.getProperty(Cat.Context.CHILD));

	}

	/**
	 * 串联provider端消息树
	 *
	 * @param request
	 * @param t
	 */
	private void createProviderCross(HttpServletRequest request, Transaction t) {
		Event crossAppEvent = Cat.newEvent(CatMsgConstants.PROVIDER_CALL_APP,
				request.getHeader(CatMsgConstants.APPLICATION_KEY)); // clientName
		Event crossServerEvent = Cat.newEvent(CatMsgConstants.PROVIDER_CALL_SERVER, request.getRemoteAddr()); // clientIp
		crossAppEvent.setStatus(Event.SUCCESS);
		crossServerEvent.setStatus(Event.SUCCESS);
		completeEvent(crossAppEvent);
		completeEvent(crossServerEvent);
		t.addChild(crossAppEvent);
		t.addChild(crossServerEvent);
	}

	private void completeEvent(Event event) {
		if (event != NullMessage.EVENT) {
			AbstractMessage message = (AbstractMessage) event;
			message.setCompleted(true);
		}
	}

}