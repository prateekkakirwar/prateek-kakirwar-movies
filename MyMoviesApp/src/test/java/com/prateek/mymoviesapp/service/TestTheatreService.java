package com.prateek.mymoviesapp.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestTheatreService extends AbstractJUnit4SpringContextTests  {
	
	@Autowired
	private TheatreService theatreService;
	
	
	@Test
	public void getShows()
	{
		theatreService.getShowsForMovie(1);
	}

}
