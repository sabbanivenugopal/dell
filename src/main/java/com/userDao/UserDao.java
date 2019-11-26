package com.userDao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;

import com.user.pojo.UserPojo;

import IuserDaoImpl.IuserDao;

public class UserDao implements IuserDao {
	
	final static Logger logger= Logger.getLogger(UserDao.class);

	public void saveUser(UserPojo user) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = config.buildSessionFactory();

		Session op = sf.openSession();
		Transaction tx = op.beginTransaction();

		op.save(user);
		tx.commit();
		op.close();

	}

	public List loginUser(String emailId, String password) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = config.buildSessionFactory();

		Session op = sf.openSession();
		
		Query Query = op.createQuery("from UserPojo where emailId =? and password=?");
		Query.setParameter(0, emailId);
		Query.setParameter(1, password);

		List list = Query.list();
		
		op.close();
		
		return list;
	}

	public List<UserPojo> showUserDetails() {

		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory session = configure.buildSessionFactory();
		Session openSession = session.openSession();
		Transaction beginTransaction = openSession.beginTransaction();

		Query query = openSession.createQuery("from UserPojo");
		List<UserPojo> userdetails = query.list();
		return userdetails;

	}

	public List<UserPojo> editUser(int userId) {

		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();

		Query query = openSession.createQuery("from UserPojo where userId=:userId");

		query.setParameter("userId", userId);
		List<UserPojo> userInfo = query.list();

		return userInfo;
	}

	public List<UserPojo> updateUser(UserPojo user) {
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		Session session = configure.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		Query query = session.createQuery("from UserPojo");
		List<UserPojo> userInfo = query.list();
		return userInfo;
	}

	public int deleteUserDetails(int userId) {
		
		logger.debug("this is the deleteUserDetails::Services");

		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();

		Query query = openSession.createQuery("delete UserPojo where userId=:userId");
		query.setParameter("userId", userId);
		int result = query.executeUpdate();
		beginTransaction.commit();
		
		openSession.close();
		return result;
	}
	public List<UserPojo> fetchmemory() {
		
		logger.debug("this is the deleteUserDetails::fetchmemory");
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		Query query = openSession.createQuery("from UserPojo");
		List<UserPojo> userInfo =query.list();
		return userInfo;
	}


}
