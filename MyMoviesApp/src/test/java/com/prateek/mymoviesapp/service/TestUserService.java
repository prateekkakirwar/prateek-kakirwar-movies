package com.prateek.mymoviesapp.service;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.prateek.mymoviesapp.entity.User;
import com.prateek.mymoviesapp.entity.impl.UserImpl;
import com.prateek.mymoviesapp.service.UserService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserService extends AbstractJUnit4SpringContextTests {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@Test
	public void addAndGetUser(){
		UserImpl newUser = new UserImpl();
		newUser.setFirstName("Prateek");
		newUser.setLastName("Kakirwar");
		newUser.setEmail("prateek@xyz.com");
		
		User added = userService.addUser(newUser);
		logger.info("user added "+ added);
		Assert.assertNotEquals(0, added.getId());//this should have been created so not zero anymore
		Assert.assertEquals(newUser.getFirstName(), added.getFirstName());
		Assert.assertEquals(newUser.getLastName(), added.getLastName());
		Assert.assertEquals(newUser.getEmail(), added.getEmail());
		
		User found = userService.getUser(added.getId());
		Assert.assertEquals(found.getId(), added.getId());
		Assert.assertEquals(found.getFirstName(), added.getFirstName());
		Assert.assertEquals(found.getLastName(), added.getLastName());
		Assert.assertEquals(found.getEmail(), added.getEmail());
	}

}
