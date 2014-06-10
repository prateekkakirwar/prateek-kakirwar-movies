package com.prateek.mymoviesapp.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.impl.MovieImpl;
import com.prateek.mymoviesapp.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public long addMovie(Movie movie) {
		return (Long) this.sessionFactory.getCurrentSession().save(movie);
	}

	@Override
	public Movie getMovie(long movieId) {
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, movieId);
	}

}
