package com.prateek.mymoviesapp.repository;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.Show;
import com.prateek.mymoviesapp.entity.Theatre;
import com.prateek.mymoviesapp.entity.impl.MovieImpl;
import com.prateek.mymoviesapp.entity.impl.ShowImpl;
import com.prateek.mymoviesapp.entity.impl.TheatreImpl;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestShowRepository  extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private ShowRepository showRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	//private ShowRepository showRepository = new ShowRepositoryImpl();
	
	@Test
	public void addAndGetShow(){
		ShowImpl newShow = new ShowImpl();
		
		MovieImpl newMovie = new MovieImpl();
		newMovie.setMovieName("Teddy");
		newMovie.setRating(2);
		newMovie.setGenre("Comedy");
		
		long addedMovieId = movieRepository.addMovie(newMovie);
		System.out.println("movie added id "+addedMovieId);
		
		TheatreImpl newTheatre = new TheatreImpl();
		newTheatre.setTheatreName("AMC");
		newTheatre.setZipCode("94089");
		newTheatre.setCityName("Sunnyvale");
		newTheatre.setStateName("CA");
		
		long addedTheatreId = theatreRepository.addTheatre(newTheatre);
		System.out.println("theatre added id "+ addedTheatreId);
		
		Theatre theatre = theatreRepository.getTheatre(addedTheatreId);	
		Movie movie = movieRepository.getMovie(addedMovieId);
		
		newShow.setTheatre(theatre);
		newShow.setMovie(movie);
		newShow.setShowTime(new Date());
		
		
		long  addedShowId = showRepository.addShow(newShow);
		System.out.println("show added id "+addedShowId);
		Assert.assertNotEquals(0, addedShowId);		
		
		Show found = showRepository.getShow(addedShowId);
		Assert.assertEquals(found.getId(), addedShowId);
		Assert.assertEquals(found.getMovie(), newShow.getMovie());

	}

}
