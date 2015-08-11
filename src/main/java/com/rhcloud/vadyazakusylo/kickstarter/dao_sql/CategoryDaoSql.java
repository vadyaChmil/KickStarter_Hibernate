package com.rhcloud.vadyazakusylo.kickstarter.dao_sql;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.rhcloud.vadyazakusylo.kickstarter.dao.CategoryDao;
import com.rhcloud.vadyazakusylo.kickstarter.entity.Category;

@Component
public class CategoryDaoSql extends AbstractDao implements CategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Category> result = session.createCriteria(Category.class).list();
		session.getTransaction().commit();
		return result;
	}

}