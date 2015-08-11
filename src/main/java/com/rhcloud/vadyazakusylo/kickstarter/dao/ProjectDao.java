package com.rhcloud.vadyazakusylo.kickstarter.dao;

import java.util.List;

import com.rhcloud.vadyazakusylo.kickstarter.entity.Project;

public interface ProjectDao {

	Project getProject(int projectId);

	void setCurrentMoney(int money, int projectId);

	void setQuestion(String question, int projectId);

	List<Project> getProjects(int categoryId);

}