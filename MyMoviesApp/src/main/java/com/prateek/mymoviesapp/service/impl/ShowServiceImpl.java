package com.prateek.mymoviesapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.prateek.mymoviesapp.entity.Show;
import com.prateek.mymoviesapp.entity.User;
import com.prateek.mymoviesapp.entity.impl.ShowImpl;
import com.prateek.mymoviesapp.repository.ShowRepository;
import com.prateek.mymoviesapp.service.ShowService;
import com.prateek.mymoviesapp.service.exception.ErrorCode;
import com.prateek.mymoviesapp.service.exception.MyMoviesAppException;

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

	@Override
	@Transactional
	public List<Show> getShows(Date showTime, String movieName, String theatreName) {
		List<Show> returnList = new ArrayList<Show>();
		if(showTime==null&&StringUtils.isEmpty(movieName) && StringUtils.isEmpty(theatreName)){
			throw new MyMoviesAppException(ErrorCode.MISSING_DATA, "no search parameter provided");	
		}
		else{
			returnList = showRepository.search(showTime, movieName, theatreName);
		}		
		return returnList;
	}
	
	


}
