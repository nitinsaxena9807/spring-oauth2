package com.way2learnonline;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("oauth2authFailureHandler")
public class ExceptionHandlingSecurityConfiguration implements AuthenticationFailureHandler {

	private  RedirectStrategy redirectStrategy=  new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		this.redirectStrategy.sendRedirect(request, response, "/error");
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests(authorizeRequests ->
//				authorizeRequests
//					.antMatchers("/**").hasRole("USER")
//			)
//			// sample exception handling customization
//			.exceptionHandling(exceptionHandling ->
//				exceptionHandling
//					.accessDeniedPage("/errors/access-denied")
//			);
//	}
	
	
}
