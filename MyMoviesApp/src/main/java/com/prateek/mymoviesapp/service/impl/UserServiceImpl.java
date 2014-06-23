package com.prateek.mymoviesapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.prateek.mymoviesapp.entity.impl.UserImpl;
import com.prateek.mymoviesapp.entity.User;
import com.prateek.mymoviesapp.repository.UserRepository;
import com.prateek.mymoviesapp.service.UserService;
import com.prateek.mymoviesapp.service.exception.MyMoviesAppException;
import com.prateek.mymoviesapp.service.exception.ErrorCode;

@Service
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional//at method level
	public User getUser(long userId) {
		return userRepository.getUser(userId);
	}
	
	@Override	
	@Transactional//at method level
	public User addUser(User user) {
		
		UserImpl impl = (UserImpl)user;
		long id =  userRepository.addUser(user);
		logger.info("user added.");
		return getUser(id);
		
	}
	
	@Override
	@Transactional
	public List<User> getUsers(String firstName, String lastName) {
		List<User> returnList = new ArrayList<User>();
		if(StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)){
			throw new MyMoviesAppException(ErrorCode.MISSING_DATA, "no search parameter provided");	
		}
		else{
			returnList = userRepository.search(firstName, lastName);
		}		
		return returnList;
	}

}
