package com.prateek.mymoviesapp.service.impl;


import javax.transaction.Transactional;

import com.prateek.mymoviesapp.entity.User;
import com.prateek.mymoviesapp.service.exception.ErrorCode;
import com.prateek.mymoviesapp.service.exception.MyMoviesAppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.mymoviesapp.entity.Theatre;
import com.prateek.mymoviesapp.entity.impl.TheatreImpl;
import com.prateek.mymoviesapp.repository.TheatreRepository;
import com.prateek.mymoviesapp.service.TheatreService;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

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
    public List<Theatre> getTheatres(String theatreName, String zipCode, String cityName, String stateName) {
        List<Theatre> returnList = new ArrayList<Theatre>();
        if(StringUtils.isEmpty(theatreName) && StringUtils.isEmpty(zipCode) && StringUtils.isEmpty(cityName) && StringUtils.isEmpty(stateName)){
            throw new MyMoviesAppException(ErrorCode.MISSING_DATA, "no search parameter provided");
        }
        else{
            returnList = theatreRepository.search(theatreName, zipCode,cityName, stateName);
        }
        return returnList;
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
