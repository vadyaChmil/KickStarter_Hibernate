package com.rhcloud.vadyazakusylo.kickstarter.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.rhcloud.vadyazakusylo.kickstarter.dao.CategoryDao;
import com.rhcloud.vadyazakusylo.kickstarter.dao.ProjectDao;
import com.rhcloud.vadyazakusylo.kickstarter.dao.QuoteDao;

@Controller
public abstract class HttpKickStarter extends HttpServlet {

	/**
	 * Vadya Zakusylo
	 */
	private static final long serialVersionUID = 1L;

	static final String QUOTE = "quote";
	static final String ID = "id";
	static final String CATEGORIES = "categories";
	static final String PROJECTS = "projects";
	static final String PROJECT_ID = "projectId";
	static final String PROJECT = "project";
	static final String DONATIONS = "donations";
	static final String MONEY = "money";
	static final String ERROR_MESSAGE = "errorMessage";

	static final String CATEGORIES_PAGE = "categories.jsp";
	static final String CATEGORY_PAGE = "category.jsp";
	static final String PROJECT_PAGE = "project.jsp";
	static final String DONATION_PAGE = "donation.jsp";
	static final String ERROR_PAGE = "error.jsp";

	@Autowired
	QuoteDao quoteDao;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	ProjectDao projectDao;

	@Override
	public void init(ServletConfig config) throws javax.servlet.ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

}
