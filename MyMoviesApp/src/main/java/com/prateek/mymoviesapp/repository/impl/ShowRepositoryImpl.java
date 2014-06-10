package com.prateek.mymoviesapp.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
