package com.moth.webservice.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.moth.webservice")
public class AppConfig {

	@Bean
	public FilterRegistrationBean<AuditingFilter> auditingFilterRegistrationBean(){
		FilterRegistrationBean<AuditingFilter> registration = new FilterRegistrationBean<>();
		AuditingFilter filter = new AuditingFilter();
		registration.setFilter(filter);
		registration.setOrder(Integer.MAX_VALUE);
		registration.setUrlPatterns(Arrays.asList("/*"));
		
		return registration;
	}
}
