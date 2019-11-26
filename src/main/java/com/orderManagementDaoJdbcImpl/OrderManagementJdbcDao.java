package com.orderManagementDaoJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.user.pojo.ItemManagementPojo;
import com.user.pojo.UserPojo;
import com.userDaoJdbcImpl.UserJdbcDao;
import com.userServices.OrderManagementServices;

import IuserDaoImpl.IorderManagementDao;

public class OrderManagementJdbcDao implements IorderManagementDao {
	
	final static Logger logger=Logger.getLogger(OrderManagementJdbcDao.class);

	public void addItemsToDb(ItemManagementPojo item) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.debug("Driver class loading...");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents", "root",
					"root");

			logger.debug("connection establishing....!!");
			PreparedStatement ps = connection
					.prepareStatement("insert into  OrderFood (itemid,item,price,quantity,typeof) values(?,?,?,?,?)");
			logger.debug("hello--1");
			ps.setInt(1, item.getItemid());
			ps.setString(2, item.getItem());
			ps.setString(3, item.getPrice());
			ps.setString(4, item.getQuantity());
			ps.setString(5, item.getTypeof());

			logger.debug("hello--2");
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List showMenu() {
		List<ItemManagementPojo> items = new ArrayList<ItemManagementPojo>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.debug("Driver class loading...");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents", "root",
					"root");

			logger.debug("connection establishing....!!");

			PreparedStatement ps = connection.prepareStatement("select * from OrderFood");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {

				int itemid = resultSet.getInt("itemid");
				String item = resultSet.getString("item");
				String price = resultSet.getString("price");
				String quantity = resultSet.getString("quantity");
				String typeof = resultSet.getString("typeof");

				ItemManagementPojo itemInfo = new ItemManagementPojo();

				itemInfo.setItemid(itemid);
				itemInfo.setItem(item);
				itemInfo.setPrice(price);
				itemInfo.setQuantity(quantity);
				itemInfo.setTypeof(typeof);

				items.add(itemInfo);
			}
			ps.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return items;
	}

	public int deleteitem(int itemid) {
		logger.debug("enter into the  deleteitem:: OrderManagementJdbcDao");

		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.debug("Driver class loading...");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents", "root",
					"root");

			logger.debug("connection establishing....!!");

			PreparedStatement ps = connection.prepareStatement("DELETE FROM OrderFood WHERE itemid=" + itemid);
			result = ps.executeUpdate();

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public List fetchmemory() {

		OrderManagementJdbcDao menu = new OrderManagementJdbcDao();
		List menuData = menu.showMenu();

		return menuData;
	}

	public ItemManagementPojo edititem(int itemid) {
		
		List<ItemManagementPojo> items = new ArrayList<ItemManagementPojo>();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.debug("Driver class loading...");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents", "root",
					"root");

			logger.debug("connection establishing....!!");

			PreparedStatement ps = connection.prepareStatement("select * from OrderFood where itemid=?");
			ps.setInt(1, itemid);
			ResultSet resultSet = ps.executeQuery();
			logger.debug("this  is the edititem page :: OrderManagement DAO--1");
			while (resultSet.next()) {

				int itemId = resultSet.getInt("itemid");
				String item = resultSet.getString("item");
				String price = resultSet.getString("price");
				String quantity = resultSet.getString("quantity");
				String typeof = resultSet.getString("typeof");
				
				ItemManagementPojo itemInfo = new ItemManagementPojo();

				itemInfo.setItemid(itemId);
				itemInfo.setItem(item);
				itemInfo.setPrice(price);
				itemInfo.setQuantity(quantity);
				itemInfo.setTypeof(typeof);
				

				items.add(itemInfo);

			}}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("this  is the edititem page :: OrderManagement DAO--2");
		return (ItemManagementPojo) items.get(0);
	}

	public List updateitem(ItemManagementPojo useritem) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.debug("Driver class loading...");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents", "root",
					"root");

			logger.debug("connection establishing....!!");

			PreparedStatement ps = connection.prepareStatement(
					"UPDATE OrderFood SET item=?, price=?,quantity=?,typeof=? WHERE itemid=?");

			logger.debug("hello--1");

			ps.setString(1, useritem.getItem());
			ps.setString(2, useritem.getPrice());
			ps.setString(3, useritem.getQuantity());
			ps.setString(4, useritem.getTypeof());
			ps.setInt(5, useritem.getItemid());
			logger.debug("hello--2");
			ps.executeUpdate();
			ps.close();
			logger.debug("hello--32");
		} catch (Exception e) {
			e.printStackTrace();
		}
		OrderManagementJdbcDao menu = new OrderManagementJdbcDao();
		List itemInfo = menu.showMenu();
		return itemInfo;
	}

}
