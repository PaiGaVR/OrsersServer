package com.server.database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
		if (null != getPerson(person.getName(), person.getPasswd()))
			return false;
		
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
	
	public Persons getPerson(String name, String passwd) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Persons.class);
			c.add(Restrictions.eq("name", name));
			c.add(Restrictions.eq("passwd", passwd));
			List<Persons> list = c.list();
			for (Persons p : list) {
				return p;
			}
		} finally {
			if (null != session)
				session.close();
		}
		
		return null;
	}
}
