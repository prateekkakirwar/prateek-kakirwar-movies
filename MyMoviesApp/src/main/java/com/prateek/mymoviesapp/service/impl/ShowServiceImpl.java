package com.prateek.mymoviesapp.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.prateek.mymoviesapp.entity.Show;
import com.prateek.mymoviesapp.entity.impl.ShowImpl;
import com.prateek.mymoviesapp.repository.ShowRepository;
import com.prateek.mymoviesapp.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {

private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShowRepository showRepository;
	
	@Override
	@Transactional//at method level
	public Show getShow(long showId) {
		return showRepository.getShow(showId);
	}
	
	@Override	
	@Transactional//at method level
	public Show addShow(Show show) {
		
		ShowImpl impl = (ShowImpl)show;
		long id =  showRepository.addShow(show);
		logger.info("show added.");
		return getShow(id);
		
	}


}
