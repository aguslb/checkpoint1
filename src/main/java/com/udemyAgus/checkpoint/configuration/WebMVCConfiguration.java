package com.udemyAgus.checkpoint.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.udemyAgus.checkpoint.componet.RequestTimeInterceptor;

@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer {

	@Autowired
	@Qualifier("requestTimeIntercerptor")
	private RequestTimeInterceptor requestTimeInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimeInterceptor);
	}
}
