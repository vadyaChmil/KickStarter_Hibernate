package com.rhcloud.vadyazakusylo.kickstarter.dao;

import java.util.List;

import com.rhcloud.vadyazakusylo.kickstarter.entity.Category;

public interface CategoryDao {

	List<Category> getCategories();

}
