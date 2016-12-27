package com.ittraning.shresh.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.criteria.expression.ConcatExpression;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ittraning.shresh.models.Bus;

@Repository
public class BusDaoImpl implements BusDao{
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Long insert(Bus bus) {
		Session session = sessionFactory.getCurrentSession();		
		Long id = (Long) session.save(bus);
		return id;
	}

	@Override
	public List<Bus> getAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Bus.class);
		List<Bus> busList = criteria.list();
		session.close();
		return busList;
	}

	@Override
	@Transactional
	public Bus get(Long id) {
		Session session = sessionFactory.openSession();
		Bus bus = (Bus) session.get(Bus.class, id);
		session.close();
		return bus;
	}

	@Override
	@Transactional
	public void insertUpdate(Bus bus) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(bus);		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Bus bus = (Bus) session.get(Bus.class, id);
		session.delete(bus);
	}

}
