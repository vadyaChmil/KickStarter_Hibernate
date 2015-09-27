package com.rhcloud.vadyazakusylo.kickstarter.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class HomeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		doFilter((HttpServletRequest) request, (HttpServletResponse) response, filterChain);
	}

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
		String path = StringUtils.substringAfterLast(uri, "/");

		if (!path.equals("")) {
			filterChain.doFilter(request, response);
			return;
		}

		request.getRequestDispatcher("categories").forward(request, response);
	}

	@Override
	public void destroy() {
	}
}
