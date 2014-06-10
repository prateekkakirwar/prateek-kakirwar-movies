package com.prateek.mymoviesapp.service.impl;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.mymoviesapp.entity.Theatre;
import com.prateek.mymoviesapp.entity.impl.TheatreImpl;
import com.prateek.mymoviesapp.repository.TheatreRepository;
import com.prateek.mymoviesapp.service.TheatreService;

@Service
public class TheatreServiceImpl implements TheatreService {


private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	@Override
	@Transactional//at method level
	public Theatre getTheatre(long theatreId) {
		return theatreRepository.getTheatre(theatreId);
	}
	
	@Override	
	@Transactional//at method level
	public Theatre addTheatre(Theatre theatre) {
		
		TheatreImpl impl = (TheatreImpl)theatre;
		long id =  theatreRepository.addTheatre(theatre);
		logger.info("theatre added.");
		return getTheatre(id);
		
	}

}
