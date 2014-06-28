package com.prateek.mymoviesapp.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.prateek.mymoviesapp.entity.Show;
import com.prateek.mymoviesapp.entity.impl.ShowImpl;
import com.prateek.mymoviesapp.repository.ShowRepository;


@Repository
public class ShowRepositoryImpl implements ShowRepository {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public long addShow(Show show) {
		return (Long) this.sessionFactory.getCurrentSession().save(show);		
	}

	@Override
	public Show getShow(long showId) {
		return (Show) this.sessionFactory.getCurrentSession().get(ShowImpl.class, showId);
	}

	@Override
	public List<Show> search(Date showTime, String movieName, String theatreName) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowImpl.class);
		if(!StringUtils.isEmpty(movieName)){
			crit.add(Restrictions.like("movie.movieName", "%"+movieName+"%"));
		}
		if(!StringUtils.isEmpty(theatreName)){
			crit.add(Restrictions.like("theatreName", "%"+theatreName+"%"));
		}
		if(showTime!=null){
			crit.add(Restrictions.eq("showTime", showTime));
		}
		
		List<Show> searchResult = crit.list();		
		return searchResult;
	}
	
	

}
