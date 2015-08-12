package com.rhcloud.vadyazakusylo.kickstarter.dao_sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rhcloud.vadyazakusylo.kickstarter.dao.ProjectDao;
import com.rhcloud.vadyazakusylo.kickstarter.entity.Project;
import com.rhcloud.vadyazakusylo.kickstarter.entity.Question;

@Component
public class ProjectDaoSql extends AbstractDao implements ProjectDao {

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Project getProject(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		return (Project) session.get(Project.class, projectId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void setCurrentMoney(int money, int projectId) {
		Project project = getProject(projectId);
		project.setCurrentMoney(project.getCurrentMoney() + money);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void setQuestion(String question, int projectId) {
		Question newQuestion = new Question();
		newQuestion.setQuestion(question);

		Session session = sessionFactory.getCurrentSession();
		Project project = getProject(projectId);
		newQuestion.setProject(project);
		project.getQuestions().add(newQuestion);
		session.save(newQuestion);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Project> getProjects(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("category.id", categoryId));
		return criteria.addOrder(Order.asc("id")).list();
	}

}