package com.prateek.mymoviesapp.repository.impl;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prateek.mymoviesapp.entity.Theatre;
import com.prateek.mymoviesapp.entity.impl.TheatreImpl;
import com.prateek.mymoviesapp.repository.TheatreRepository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class TheatreRepositoryImpl implements TheatreRepository {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public long addTheatre(Theatre theatre) {
		return (Long) this.sessionFactory.getCurrentSession().save(theatre);		
	}

	@Override
	public Theatre getTheatre(long theatreId) {
		return (Theatre) this.sessionFactory.getCurrentSession().get(TheatreImpl.class, theatreId);
	}

    @Override
    public List<Theatre> search(String theatreName, String zipCode, String cityName, String stateName) {
        Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(Theatre.class);
        if(!StringUtils.isEmpty(theatreName)){
            crit.add(Restrictions.like("theatreName", "%" + theatreName + "%"));
        }
        if(!StringUtils.isEmpty(zipCode)){
            crit.add(Restrictions.like("zipCode", "%"+zipCode+"%"));
        }
        if(!StringUtils.isEmpty(cityName)){
            crit.add(Restrictions.like("cityName", "%" + cityName + "%"));
        }
        if(!StringUtils.isEmpty(stateName)){
            crit.add(Restrictions.like("stateName", "%"+stateName+"%"));
        }
        List<Theatre> searchResult = crit.list();
        return searchResult;
    }


}
