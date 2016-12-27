package com.ittraning.shresh.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ittraning.shresh.models.Location;

@Repository
public class LocationDaoImpl implements LocationDao{
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Long insert(Location location) {
		Session session = sessionFactory.getCurrentSession();
		Long id = (Long) session.save(location);
		return id;
	}

	@Override
	public List<Location> getAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Location.class);
		List<Location> locationList = criteria.list();
		session.close();
		return locationList;
	}

	@Override
	@Transactional
	public Location get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Location location = (Location) session.get(Location.class, id);
		return location;
	}

	@Override
	@Transactional
	public void insertUpdate(Location location) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(location);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Location location = (Location) session.get(Location.class, id);
		session.delete(location);
	}

}
