package com.rhcloud.vadyazakusylo.kickstarter.dao_sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.rhcloud.vadyazakusylo.kickstarter.dao.ProjectDao;
import com.rhcloud.vadyazakusylo.kickstarter.entity.Project;
import com.rhcloud.vadyazakusylo.kickstarter.entity.Question;
import com.rhcloud.vadyazakusylo.kickstarter.persistence.HibernateUtil;

public class ProjectDaoSql implements ProjectDao {

	@Override
	public Project getProject(int projectId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Project project = (Project) session.get(Project.class, projectId);
		session.getTransaction().commit();
		return project;
	}

	@Override
	public void setCurrentMoney(int money, int projectId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Project project = (Project) session.load(Project.class, projectId);
		int newCurrentMoney = project.getCurrentMoney() + money;
		project.setCurrentMoney(newCurrentMoney);
		
		session.getTransaction().commit();
	}

	@Override
	public void setQuestion(String question, int projectId) {
		Question newQuestion = new Question();
		newQuestion.setQuestion(question);

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Project project = (Project) session.load(Project.class, projectId);
		newQuestion.setProject(project);
		project.getQuestions().add(newQuestion);
		session.save(newQuestion);

		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjects(int categoryId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		Criteria criteria = session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("category.id", categoryId));
		List<Project> projects = criteria.addOrder(Order.asc("id")).list();

		session.getTransaction().commit();

		return projects;
	}

}
