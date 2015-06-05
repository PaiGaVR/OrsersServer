package com.server.database;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static HibernateUtil hibernate = null;
	private SessionFactory sessionFactory = null;
	private Configuration conf = null;
	
	private HibernateUtil() {
		try {
			conf = new Configuration().configure();
		} catch (HibernateException he) {
			he.printStackTrace();
		}
	}
	
	public static HibernateUtil getInstance() {
		if (hibernate == null)
			hibernate = new HibernateUtil();
		
		return hibernate;
	}

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = conf.buildSessionFactory();
		
		return sessionFactory;
	}
}
