package com.prateek.mymoviesapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.Show;
import com.prateek.mymoviesapp.entity.impl.GenericMovie;
import com.prateek.mymoviesapp.entity.impl.GenericShow;
import com.prateek.mymoviesapp.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {

	
	List<Show> shows = new ArrayList<Show>();
	
	
	
	@Override
	public Show getShow(long showId) {
		// TODO Auto-generated method stub
		Show localShow = null;
		
		for(Show show:shows)
		{
			if(show.getId()==showId)
			{
				localShow = show;
			}
		}
		
		return localShow;
	}



	@Override
	public boolean addShow(Show show) {
		shows.add(show);
		return true;
		
	}

}
