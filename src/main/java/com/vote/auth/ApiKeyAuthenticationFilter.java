package com.vote.auth;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApiKeyAuthenticationFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 try {
	            Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest) request);
	            SecurityContextHolder.getContext().setAuthentication(authentication);
	            chain.doFilter(request, response);
	        } catch (Exception exp) {
	            HttpServletResponse httpResponse = (HttpServletResponse) response;
	            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	            httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

	            PrintWriter writer = httpResponse.getWriter();
	            writer.print(exp.getMessage());
	            writer.flush();
	            writer.close();
	        }

		
	}

	
}
