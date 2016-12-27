package com.ittraning.shresh.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ittraning.shresh.models.SetRoute;

@Repository
public class SetRouteDaoImpl implements SetRouteDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Long insert(SetRoute setroute) {
		Session session = sessionFactory.getCurrentSession();
		Long id = (Long) session.save(setroute);
		return id;
	}

	@Override
	public List<SetRoute> getAll() {
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(SetRoute.class);
		List<SetRoute> setRouteList = criteria.list();
		session.close();
		return setRouteList;
	}

	@Override
	@Transactional
	public void insertUpdate(SetRoute setroute) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(setroute);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		SetRoute setRoute = (SetRoute) session.get(SetRoute.class, id);
		session.delete(setRoute);
	}

	@Override
	@Transactional
	public SetRoute get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		SetRoute setRoute = (SetRoute) session.get(SetRoute.class, id);
		return setRoute;
	}
}
