package com.prateek.mymoviesapp.entity.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.prateek.mymoviesapp.entity.impl.MovieImpl;
import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.Show;


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
	
	
	@Column(name="showtime")
	private Date showTime;
	
	public ShowImpl()
	{
		
	}

	public ShowImpl(long id, Movie movie, Date showTime) {
		super();
		this.id = id;
		this.movie = movie;
		this.showTime = showTime;
	}

	@Override	
	public Movie getMovie() {
		return movie;
	}

	public Date getshowTime() {
		return showTime;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setshowTime(Date showTime) {
		this.showTime = showTime;
	}
	
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public Date getShowTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "ShowImpl [id=" + id + ", movie=" + movie + ", showTime="
				+ showTime + "]";
	}
	
	
	
	

}
