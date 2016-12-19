package com.ittraning.shresh.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bus get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
