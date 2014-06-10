package com.prateek.mymoviesapp.entity.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;


import com.prateek.mymoviesapp.entity.Theatre;

@Entity
@Table(name = "theatre")
@SecondaryTable(name="theatre_shows", pkJoinColumns = @PrimaryKeyJoinColumn(name="theatreid", referencedColumnName="id"))

public class TheatreImpl implements Theatre {
	
	@Id
	// primary key
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// vendor specific code
	private long id;
	
	@Column(name="theatreName")
	private String theatreName;
	
	@Column(name="zipcode")
	private String zipCode;
	
	@Column(name="cityname")
	private String cityName;
	
	@Column(name="statename")
	private String stateName;
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getTheatreName() {
		return theatreName;
	}


	@Override
	public String getZipCode() {
		return zipCode;
	}

	@Override
	public String getCityName() {
		return cityName;
	}

	@Override
	public String getStateName() {
		return stateName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "TheatreImpl [id=" + id + ", theatreName=" + theatreName
				+ ", zipCode=" + zipCode + ", cityName=" + cityName
				+ ", stateName=" + stateName + "]";
	}
	
	

}
