package com.server.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.entity.Persons;

public class PersonsDB {
	private static PersonsDB db = null;
	
	private SessionFactory sessionFactory;
	
	private PersonsDB() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	public static PersonsDB getInstance() {
		if (db == null)
			db = new PersonsDB();
		
		return db;
	}
	
	public boolean addPerson(Persons person) {
		Transaction tr = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
			session.save(person);
			tr.commit();
			return true;
		} catch(HibernateException he) {
			if (null != tr)
				tr.rollback();
			he.printStackTrace();
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}
}
