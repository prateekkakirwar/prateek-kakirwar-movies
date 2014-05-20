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
import com.prateek.mymoviesapp.entity.impl.ActionMovie;
import com.prateek.mymoviesapp.entity.impl.MatineeShow;
import com.prateek.mymoviesapp.service.impl.ShowServiceImpl;


@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestShowService extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private ShowService showService;
	
	
	@Test
	public void testAddShow()
	{
		Movie movie = new ActionMovie(1,"Godzilla");
		Show show = new MatineeShow(1,movie,new Date());
		Assert.assertEquals(true, showService.addShow(show));
		
	}
	
	@Test
	public void testGetShow()
	{
		Movie movie = new ActionMovie(1,"Godzilla");
		Show show = new MatineeShow(1,movie,new Date());
		showService.addShow(show);
		Show testshow = showService.getShow(1);
		Assert.assertEquals(1, testshow.getId());
		Assert.assertEquals("Godzilla", testshow.getMovie().getMovieName());
		
	}
	
	

}
