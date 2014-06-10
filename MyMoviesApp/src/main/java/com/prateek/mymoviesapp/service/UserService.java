package com.prateek.mymoviesapp.service;

import com.prateek.mymoviesapp.entity.User;

public interface UserService {
	
	User addUser(User user);

	User getUser(long userId);

}
