package com.prateek.mymoviesapp.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.impl.MovieImpl;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieService extends AbstractJUnit4SpringContextTests {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieService movieService;
	
	@Test
	public void addAndGetMovie()
	{
		MovieImpl newMovie = new MovieImpl();
		newMovie.setMovieName("Godzilla");
		newMovie.setRating(3);
		newMovie.setReleaseDate(new Date());
		newMovie.setGenre("Horror");
		
		Movie added = movieService.addMovie(newMovie);
		logger.info("Movie added "+ added);
		Assert.assertNotEquals(0, added.getId());//this should have been created so not zero anymore
		Assert.assertEquals(added.getMovieName(), newMovie.getMovieName());
		Assert.assertEquals(added.getRating(), newMovie.getRating());
		Assert.assertEquals(added.getReleaseDate(), newMovie.getReleaseDate());
		Assert.assertEquals(added.getGenre(), newMovie.getGenre());
		
		Movie found = movieService.getMovie(added.getId());
		Assert.assertEquals(found.getId(), added.getId());
		Assert.assertEquals(found.getMovieName(), added.getMovieName());
		Assert.assertEquals(found.getRating(), added.getRating());
		Assert.assertEquals(found.getReleaseDate(), added.getReleaseDate());
		Assert.assertEquals(found.getGenre(), added.getGenre());
				
	}
	

}
