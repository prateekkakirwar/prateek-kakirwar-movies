package com.prateek.mymoviesapp.service;

import com.prateek.mymoviesapp.entity.Show;

public interface ShowService {
	
	
	public Show getShow(long showId);
	public boolean addShow(Show show);
	
	
	
}
