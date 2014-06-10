package com.prateek.mymoviesapp.repository;

import com.prateek.mymoviesapp.entity.Show;

public interface ShowRepository {
	
	long addShow(Show show);
	
	Show getShow(long showId);

}
