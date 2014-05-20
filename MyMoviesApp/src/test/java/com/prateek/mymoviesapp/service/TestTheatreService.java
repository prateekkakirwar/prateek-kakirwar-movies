package com.prateek.mymoviesapp.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.prateek.mymoviesapp.entity.Show;


/**
 * Test class for Theatre Service
 * @author Prateek Kakirwar
 *
 */


@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestTheatreService extends AbstractJUnit4SpringContextTests  {
	
	@Autowired
	private TheatreService theatreService;
	
	//code to test Theatre Service. I haven't finished this tests yet.
	
}
