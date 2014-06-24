package com.prateek.mymoviesapp.repository;

import java.util.Date;
import java.util.List;

import com.prateek.mymoviesapp.entity.Show;

public interface ShowRepository {
	
	long addShow(Show show);
	
	Show getShow(long showId);
	
	List<Show> search(Date showTime, String movieName, String theatreName);

}
