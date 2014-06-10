package com.prateek.mymoviesapp.repository;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.prateek.mymoviesapp.entity.User;
import com.prateek.mymoviesapp.entity.impl.UserImpl;
import com.prateek.mymoviesapp.repository.UserRepository;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserRepository extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void addAndGetUser(){
		UserImpl newUser = new UserImpl();
		newUser.setFirstName("Sam");
		newUser.setLastName("John");
		newUser.setEmail("sam@abc.com");
		
		long  addedUserId = userRepository.addUser(newUser);
		System.out.println("user added id "+addedUserId);
		Assert.assertNotEquals(0, addedUserId);		
		
		User found = userRepository.getUser(addedUserId);
		Assert.assertEquals(found.getId(), addedUserId);
		Assert.assertEquals(found.getFirstName(), newUser.getFirstName());
		Assert.assertEquals(found.getLastName(), newUser.getLastName());
		Assert.assertEquals(found.getEmail(), newUser.getEmail());
	}

}
