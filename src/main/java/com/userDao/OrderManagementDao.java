package com.userDao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.pojo.ItemManagementPojo;
import com.userServices.OrderManagementServices;

import IuserDaoImpl.IorderManagementDao;

public class OrderManagementDao implements IorderManagementDao {
	
	final static Logger logger=Logger.getLogger(OrderManagementDao.class);

	public void addItemsToDb(ItemManagementPojo item) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = config.buildSessionFactory();

		Session op = sf.openSession();
		Transaction tx = op.beginTransaction();

		op.save(item);
		tx.commit();
		op.close();

	}

	public List showMenu() {

		logger.debug("this is the show menu ::: OrderManagementDao..!!");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = config.buildSessionFactory();

		Session op = sf.openSession();
		Query Query = op.createQuery("from ItemManagementPojo");
		List list = Query.list();

		return list;
	}

	public int deleteitem(int itemid) {
		logger.debug("enter into the  deleteitem:: userDao");

		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		Transaction tn = openSession.beginTransaction();

		Query query = openSession.createQuery("delete ItemManagementPojo where itemid = :id");
		query.setParameter("id", itemid);
		int result = query.executeUpdate();
		tn.commit();

		openSession.close();
		return result;
	}

	public List fetchmemory() {

		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		Transaction tn = openSession.beginTransaction();
		Query fetchMenuQuery = openSession.createQuery("from ItemManagementPojo");
		List menuData = fetchMenuQuery.list();
		logger.debug("ordermanagement dao :: through hibernate");
		openSession.close();
		return menuData;

	}

	public ItemManagementPojo edititem(int itemid) {

		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();

		Query query = openSession.createQuery("from ItemManagementPojo where itemid = :id");
		query.setParameter("id", itemid);
		ItemManagementPojo itemInfo = (ItemManagementPojo) query.list().get(0);
		return itemInfo;
	}

	public List updateitem(ItemManagementPojo useritem) {
		
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
			Transaction txn = openSession.beginTransaction();
			openSession.update(useritem);
			txn.commit();
			logger.debug("hello");
			Query query = openSession.createQuery("from ItemManagementPojo");
			List itemInfo = query.list();
			openSession.close();
			return itemInfo;
	}
}
