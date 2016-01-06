package com.dc.test.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dc.test.dao.IEntityDao;

public class EntityDaoImpl implements IEntityDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> createQuery(final String queryString) {
		return getSession().createQuery(queryString).list();
//		return (List<Object>) getHibernateTemplate().execute(
//				new HibernateCallback<Object>() {
//					public Object doInHibernate(org.hibernate.Session session)
//							throws org.hibernate.HibernateException {
//						Query query = session.createQuery(queryString);
//						List<Object> rows = query.list();
//						return rows;
//					}
//				});
	}

	public Object save(final Object model) {
		return getSession().save(model);
//		return getHibernateTemplate().execute(new HibernateCallback<Object>() {
//			public Object doInHibernate(org.hibernate.Session session)
//					throws org.hibernate.HibernateException {
//				session.save(model);
//				return null;
//			}
//		});
	}

	public void update(final Object model) {
		getSession().update(model);
//		getHibernateTemplate().execute(new HibernateCallback<Object>() {
//			public Object doInHibernate(org.hibernate.Session session)
//					throws org.hibernate.HibernateException {
//				session.update(model);
//				return null;
//			}
//		});
	}

	public void delete(final Object model) {
		getSession().delete(model);
//		getHibernateTemplate().execute(new HibernateCallback<Object>() {
//			public Object doInHibernate(org.hibernate.Session session)
//					throws org.hibernate.HibernateException {
//				session.delete(model);
//				return null;
//			}
//		});
	}
}