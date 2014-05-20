package com.prateek.mymoviesapp.service;

import java.util.List;

import com.prateek.mymoviesapp.entity.Show;



public interface TheatreService {
	
	List<Show> getShowsForMovie(long movieId);

}
