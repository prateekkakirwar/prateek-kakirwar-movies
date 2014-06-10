package com.prateek.mymoviesapp.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prateek.mymoviesapp.entity.Theatre;
import com.prateek.mymoviesapp.entity.impl.TheatreImpl;
import com.prateek.mymoviesapp.repository.TheatreRepository;

@Repository
public class TheatreRepositoryImpl implements TheatreRepository {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public long addTheatre(Theatre theatre) {
		return (Long) this.sessionFactory.getCurrentSession().save(theatre);		
	}

	@Override
	public Theatre getTheatre(long theatreId) {
		return (Theatre) this.sessionFactory.getCurrentSession().get(TheatreImpl.class, theatreId);
	}


}
