package com.rhcloud.vadyazakusylo.kickstarter.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rhcloud.vadyazakusylo.kickstarter.entity.Project;
import com.rhcloud.vadyazakusylo.kickstarter.entity.Quote;

public class CategoryServlet extends HttpKickStarter {

	/**
	 * Vadya Zakusylo
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Quote quote = quoteDao.getQuote();
			request.setAttribute(QUOTE, quote);
			
			int categoryId = Integer.valueOf(request.getParameter(ID));
			List<Project> projects = projectDao.getProjects(categoryId);
			request.setAttribute(PROJECTS, projects);
			request.getRequestDispatcher(CATEGORY_PAGE).forward(request, response);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			request.setAttribute(ERROR_MESSAGE, errorMessage);
			request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
		}
	}
}
