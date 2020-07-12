package com.moth.webservice.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.moth.webservice.config.security.SecurityConfig;

@Configuration
@ComponentScan("com.moth.webservice")
@Import(SecurityConfig.class)
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
