package com.rhcloud.vadyazakusylo.kickstarter.dao_sql;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rhcloud.vadyazakusylo.kickstarter.dao.CategoryDao;
import com.rhcloud.vadyazakusylo.kickstarter.entity.Category;

@Component
public class CategoryDaoSql extends AbstractDao implements CategoryDao {

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<Category> getCategories() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Category.class).list();
	}

}