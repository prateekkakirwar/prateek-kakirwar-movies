package com.prateek.mymoviesapp.service;

import java.util.Date;
import java.util.List;

import com.prateek.mymoviesapp.entity.Show;

public interface ShowService {
	
	
	public Show getShow(long showId);
	public Show addShow(Show show);
	
	List<Show> getShows(Date showTime, String movieName, String theatreName);
	
	
}
