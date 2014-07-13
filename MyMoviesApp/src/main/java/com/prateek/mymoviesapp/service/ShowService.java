package com.prateek.mymoviesapp.service;

import java.util.Date;
import java.util.List;

import com.prateek.mymoviesapp.entity.Show;

public interface ShowService {
	
	Show addShow(Show show);
	
	Show getShow(long showId);
    
	List<Show> getShows(Date showTime, String movieName, String theatreName);
	
	
}
