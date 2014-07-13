package com.prateek.mymoviesapp.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.User;
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

	@Override
	public List<Movie> search(String movieName, Date releaseDate, int rating, String genre) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(Movie.class);
		if(!StringUtils.isEmpty(movieName)){
			crit.add(Restrictions.like("movieName", "%"+movieName+"%"));
		}
		if(releaseDate!=null){
			crit.add(Restrictions.gt("releaseDate", releaseDate));
		}
		if(rating > 0){
			crit.add(Restrictions.eq("rating", rating));
		}
		if(!StringUtils.isEmpty(genre)){
			crit.add(Restrictions.like("genre", "%"+genre+"%"));
		}				
		List<Movie> searchResult = crit.list();		
		return searchResult;
	}
	
	

}
