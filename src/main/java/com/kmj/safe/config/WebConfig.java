package com.kmj.safe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kmj.safe.common.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry
			.addInterceptor(new LoginInterceptor())
			.addPathPatterns("/**") 
			.excludePathPatterns("/login/**", "/join/**", "/css/**", "/img/**", "/js/**", "/plugin/**", "/font/**", "/assets/**");
	}
}
