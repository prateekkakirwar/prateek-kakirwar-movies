package com.prateek.mymoviesapp.http.entity;

import com.prateek.mymoviesapp.entity.Theatre;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by pkakirwar on 6/22/14.
 */
@XmlRootElement(name = "theatre")
public class HttpTheatre {


    @XmlElement
    public long id;

    @XmlElement
    public String theatreName;

    @XmlElement
    public String zipcode;

    @XmlElement
    public String cityname;

    @XmlElement
    public String statename;

    //required by framework
    protected HttpTheatre() {}

    public HttpTheatre(Theatre theatre) {
        this.id=theatre.getId();
        this.theatreName=theatre.getTheatreName();
        this.zipcode=theatre.getZipCode();
        this.cityname=theatre.getCityName();
        this.statename=theatre.getStateName();
    }
}

