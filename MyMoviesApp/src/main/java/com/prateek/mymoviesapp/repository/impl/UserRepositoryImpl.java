package com.prateek.mymoviesapp.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.prateek.mymoviesapp.entity.User;
import com.prateek.mymoviesapp.entity.impl.UserImpl;
import com.prateek.mymoviesapp.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public long addUser(User user) {
		return (Long) this.sessionFactory.getCurrentSession().save(user);	
	}

	@Override
	public User getUser(long userId) {
		return (User) this.sessionFactory.getCurrentSession().get(UserImpl.class, userId);
	}

}
