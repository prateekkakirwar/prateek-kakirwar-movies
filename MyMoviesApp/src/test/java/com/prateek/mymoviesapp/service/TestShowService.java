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
import com.prateek.mymoviesapp.entity.Theatre;
import com.prateek.mymoviesapp.entity.impl.MovieImpl;
import com.prateek.mymoviesapp.entity.impl.ShowImpl;
import com.prateek.mymoviesapp.entity.impl.TheatreImpl;
import com.prateek.mymoviesapp.repository.TheatreRepository;
import com.prateek.mymoviesapp.service.impl.ShowServiceImpl;


@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestShowService extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private ShowService showService ;
	
	@Autowired
	private MovieService movieService ;
	
	@Autowired
	private TheatreService theatreService;
	

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
		
		TheatreImpl newTheatre = new TheatreImpl();
		newTheatre.setTheatreName("AMC");
		newTheatre.setZipCode("94089");
		newTheatre.setCityName("Sunnyvale");
		newTheatre.setStateName("CA");
		
		Theatre addedTheatre = theatreService.addTheatre(newTheatre);
		System.out.println("theatre added id "+ addedTheatre);
		
		Theatre theatre = theatreService.getTheatre(addedTheatre.getId());	
		
		newShow.setTheatre(theatre);
		newShow.setMovie(movie);
		newShow.setShowTime(new Date());
		
		Show added = showService.addShow(newShow);
		logger.info("Show added "+ added);
		Assert.assertNotEquals(0, added.getId());//this should have been created so not zero anymore
		Assert.assertEquals(added.getMovie(), newShow.getMovie());
		
		
		Show found = showService.getShow(added.getId());
		logger.info("Show found "+ found);
		Assert.assertEquals(found.getId(), added.getId());
		//Assert.assertEquals(found.getMovie(), added.getMovie());
				
	}
	

}
