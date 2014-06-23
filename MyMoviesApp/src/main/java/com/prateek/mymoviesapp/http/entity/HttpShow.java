package com.prateek.mymoviesapp.http.entity;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.Show;
import com.prateek.mymoviesapp.entity.Theatre;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by pkakirwar on 6/22/14.
 */

@XmlRootElement(name = "show")
public class HttpShow {

    @XmlElement
    public long id;

    @XmlElement
    public Date showTime;

    @XmlElement
    public Movie movie;

    @XmlElement
    public Theatre theatre;

    //required by framework
    protected HttpShow() {}

    public HttpShow(Show show) {
        this.id=show.getId();
        this.showTime=show.getShowTime();
        this.movie=show.getMovie();
        this.theatre=show.getTheatre();
    }

}
