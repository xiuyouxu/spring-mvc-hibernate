package com.dc.test.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dc.test.entity.User;

@Component("userDao")
public class UserDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery(
				"from user").list();
	}

}
