package com.rhcloud.vadyazakusylo.kickstarter.dao_sql;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao {

	@Autowired
	protected SessionFactory sessionFactory;

}
