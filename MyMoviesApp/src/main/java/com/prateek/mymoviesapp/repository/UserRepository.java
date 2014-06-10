package com.prateek.mymoviesapp.repository;

import com.prateek.mymoviesapp.entity.User;

public interface UserRepository {
	
	/**
	 * 
	 * @param user
	 * @return the id of the newly added user
	 */
	long addUser(User user);
	
	User getUser(long userId);

}
