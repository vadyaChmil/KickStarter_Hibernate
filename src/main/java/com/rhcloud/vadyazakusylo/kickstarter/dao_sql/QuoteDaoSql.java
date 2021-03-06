package com.rhcloud.vadyazakusylo.kickstarter.dao_sql;

import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rhcloud.vadyazakusylo.kickstarter.dao.QuoteDao;
import com.rhcloud.vadyazakusylo.kickstarter.entity.Quote;

@Component
public class QuoteDaoSql extends AbstractDao implements QuoteDao {

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Quote getQuote() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Quote.class);
		criteria.setProjection(Projections.rowCount());
		int countQuote = ((Number) criteria.uniqueResult()).intValue();
		int RandomQuote = (int) Math.round((new Random().nextInt(countQuote)) + 0.5);
		return (Quote) session.get(Quote.class, RandomQuote);
	}

}