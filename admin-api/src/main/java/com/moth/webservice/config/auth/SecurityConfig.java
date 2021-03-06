package com.moth.webservice.config.auth;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.moth.webservice.web.member.service.MemberService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private MemberService memberService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/favicon.ico","/css/**","/js/**","/img/**","/lib/**", "/webjars/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/myinfo").hasRole("MEMBER")
			.antMatchers("/**").permitAll()
		.and()
			.csrf().ignoringAntMatchers("/h2-console/**")
		.and()
			.formLogin()
			.loginPage("/user/login")
			.usernameParameter("email")
			.successHandler(new LoginSuccessHandler())
			.permitAll()
		.and()
	        .headers()
	            .addHeaderWriter(
	                new XFrameOptionsHeaderWriter(
	                    new WhiteListedAllowFromStrategy(Arrays.asList("localhost"))    // 여기!
	                )
	            )
	            .frameOptions().sameOrigin()
		.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
			.logoutSuccessUrl("/user/logout/result")
			.invalidateHttpSession(true)
		.and()
			.exceptionHandling().accessDeniedPage("/");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
	}
}
