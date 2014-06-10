package com.prateek.mymoviesapp.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.impl.MovieImpl;
import com.prateek.mymoviesapp.repository.MovieRepository;
import com.prateek.mymoviesapp.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public Movie getMovie(long movieId) {
		return movieRepository.getMovie(movieId);
	}
	
	@Override	
	@Transactional//at method level
	public long addMovie(Movie movie) {
		
		MovieImpl impl = (MovieImpl)movie;
		long id =  movieRepository.addMovie(movie);
		logger.info("movie added.");
		return id;
		
	}
	

}
