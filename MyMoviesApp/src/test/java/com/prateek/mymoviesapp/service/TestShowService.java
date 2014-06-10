package com.prateek.mymoviesapp.service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.Show;
import com.prateek.mymoviesapp.entity.impl.MovieImpl;
import com.prateek.mymoviesapp.entity.impl.ShowImpl;
import com.prateek.mymoviesapp.service.impl.ShowServiceImpl;


@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestShowService extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private ShowService showService ;
	
	@Autowired
	private MovieService movieService ;
	

	@Test
	public void addAndGetShow()
	{
		ShowImpl newShow = new ShowImpl();
		
		MovieImpl newMovie = new MovieImpl();
		newMovie.setMovieName("Godzilla");
		newMovie.setRating(3);
		newMovie.setReleaseDate(new Date());
		newMovie.setGenre("Horror");
		
		Movie movie = movieService.addMovie(newMovie);
		logger.info("Movie added "+ movie);
		
		newShow.setMovie(movie);
		newShow.setshowTime(new Date());
		
		Show added = showService.addShow(newShow);
		logger.info("Movie added "+ added);
		Assert.assertNotEquals(0, added.getId());//this should have been created so not zero anymore
		Assert.assertEquals(added.getMovie(), newShow.getMovie());
		
		
		Show found = showService.getShow(added.getId());
		logger.info("Show found "+ found);
		Assert.assertEquals(found.getId(), added.getId());
		//Assert.assertEquals(found.getMovie(), added.getMovie());
				
	}
	

}
