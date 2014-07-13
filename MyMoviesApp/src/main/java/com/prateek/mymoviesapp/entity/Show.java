package com.prateek.mymoviesapp.entity;

import java.util.Date;

/**
 * A generic Show
 * @author Prateek
 *
 */

public interface Show {
	
	long getId();	
	Date getShowTime();
	Movie getMovie();
	Theatre getTheatre();
}
