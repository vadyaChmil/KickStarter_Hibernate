package com.rhcloud.vadyazakusylo.kickstarter.dao_sql;

import java.util.List;

import org.hibernate.Session;

import com.rhcloud.vadyazakusylo.kickstarter.dao.CategoryDao;
import com.rhcloud.vadyazakusylo.kickstarter.entity.Category;
import com.rhcloud.vadyazakusylo.kickstarter.persistence.HibernateUtil;

public class CategoryDaoSql implements CategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Category> result = session.createCriteria(Category.class).list();
		session.getTransaction().commit();
		return result;
	}

}
