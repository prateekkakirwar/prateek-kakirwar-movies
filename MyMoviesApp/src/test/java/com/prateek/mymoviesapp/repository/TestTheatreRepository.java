package com.prateek.mymoviesapp.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.prateek.mymoviesapp.entity.impl.TheatreImpl;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestTheatreRepository extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	@Test
	public void addAndGetTheatre(){
		
		TheatreImpl newTheatre = new TheatreImpl();
		newTheatre.setTheatreName("AMC");
		newTheatre.setZipCode("94089");
		newTheatre.setCityName("Sunnyvale");
		newTheatre.setStateName("CA");
		
		long addedTheatreId = theatreRepository.addTheatre(newTheatre);
		System.out.println("theatre added id "+ addedTheatreId);
		
	}

}
