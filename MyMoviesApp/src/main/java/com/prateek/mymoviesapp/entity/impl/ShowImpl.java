package com.prateek.mymoviesapp.entity.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.prateek.mymoviesapp.entity.impl.MovieImpl;
import com.prateek.mymoviesapp.entity.impl.TheatreImpl;
import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.Show;
import com.prateek.mymoviesapp.entity.Theatre;


@Entity
@Table(name = "shows")
public class ShowImpl implements Show {
	
	@Id
	// primary key
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// vendor specific code
	private long id;
	
	
	@OneToOne(targetEntity=MovieImpl.class)
	@JoinColumn(name="movieid")	
	private Movie movie;
	
	@ManyToOne(targetEntity=TheatreImpl.class)
	@JoinColumn(name="theatreid")	
	private Theatre theatre;
	
	@Column(name="showtime")
	private Date showTime;
	
	public ShowImpl()
	{
		
	}

	public ShowImpl(long id, Movie movie, Date showTime, Theatre theatre) {
		super();
		this.id = id;
		this.movie = movie;
		this.showTime = showTime;
		this.theatre = theatre;
	}

	@Override	
	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
	
	public long getId() {
		return id;
	}

	@Override
	public Date getShowTime() {
		return showTime;
	}
	
	
	@Override
	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	@Override
	public String toString() {
		return "ShowImpl [id=" + id + ", movie=" + movie + ", theatre="
				+ theatre + ", showTime=" + showTime + "]";
	}

	
	
	
	

}
