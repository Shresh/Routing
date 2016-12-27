package com.ittraning.shresh.daos;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ittraning.shresh.models.Users;

@Repository
public class UsersDaoImpl implements UsersDao {

	@Resource
	private SessionFactory sessionFactory;

	@Autowired
	private DataSource dataSource;

	@Override
	@Transactional
	public Long insert(Users users) {
		Session session = sessionFactory.getCurrentSession();
		Long id = (Long) session.save(users);
		return id;
	}

	@Override
	public List<Users> getAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Users.class);
		List<Users> usersList = criteria.list();
		session.close();
		return usersList;
	}

	@Override
	@Transactional
	public Users get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Users user = (Users) session.get(Users.class, id);
		return user;
	}

	@Override
	public boolean validateuser(Users users) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			String query = "select username from users where username = '" + users.getUsername() + "' and password = '"
					+ users.getPassword() + "'";
			String dbUserName = jdbcTemplate.queryForObject(query, String.class);
			if (dbUserName != null && dbUserName.equals(users.getUsername())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	@Transactional
	public Users get(Users users) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Users.class);
		criteria.add(Restrictions.eq("username", users.getUsername()));
		criteria.add(Restrictions.eq("password", users.getPassword()));
		Users user = (Users) criteria.uniqueResult();

		return user;
	}

	@Override
	@Transactional
	public void insertUpdate(Users users) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(users);
	}

}
