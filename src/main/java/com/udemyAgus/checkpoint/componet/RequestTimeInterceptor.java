package com.udemyAgus.checkpoint.componet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeIntercerptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	private static final String START_TIME = "startTime";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute(START_TIME, System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute(START_TIME);
		LOG.info("Request URL:" + request.getRequestURL().toString() + " Total time "
				+ (System.currentTimeMillis() - startTime) + "ms");
	}

}
