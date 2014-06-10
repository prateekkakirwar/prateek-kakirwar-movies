package com.prateek.mymoviesapp.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.repository.MovieRepository;
import com.prateek.mymoviesapp.repository.impl.MovieRepositoryImpl;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieRepository extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired 
	private MovieRepository movieRepository;
	
	//private MovieRepository movieRepository = new MovieRepositoryImpl();
	
	@Test
	public void getMovie(){
	
	Movie movie = movieRepository.getMovie(10);
	Assert.assertEquals(movie.getId(), 10);
	
	}

}
