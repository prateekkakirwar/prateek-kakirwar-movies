package com.prateek.mymoviesapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.impl.MovieImpl;
import com.prateek.mymoviesapp.repository.MovieRepository;
import com.prateek.mymoviesapp.service.MovieService;
import com.prateek.mymoviesapp.service.exception.ErrorCode;
import com.prateek.mymoviesapp.service.exception.MyMoviesAppException;

@Service
public class MovieServiceImpl implements MovieService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	@Transactional//at method level
	public Movie getMovie(long movieId) {
		return movieRepository.getMovie(movieId);
	}
	
	@Override	
	@Transactional//at method level
	public Movie addMovie(Movie movie) {
		
		MovieImpl impl = (MovieImpl)movie;
		long id =  movieRepository.addMovie(movie);
		logger.info("movie added.");
		return getMovie(id);
		
	}

	@Override
	public List<Movie> getMovies(String movieName, Date releaseDate, int rating,
			String genre) {
		List<Movie> returnList = new ArrayList<Movie>();
		if(StringUtils.isEmpty(movieName)&&StringUtils.isEmpty(genre)&&releaseDate==null&&rating<1)
		{
			throw new MyMoviesAppException(ErrorCode.MISSING_DATA, "no search parameter provided");	
		}
		else
		{
			returnList = movieRepository.search(movieName, releaseDate, rating, genre);
		}
		return returnList;
	}
	
	
	

}
