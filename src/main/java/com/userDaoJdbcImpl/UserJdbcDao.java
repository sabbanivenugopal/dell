package com.userDaoJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.pojo.UserPojo;
import com.userController.UserController;

import IuserDaoImpl.IuserDao;

public class UserJdbcDao implements IuserDao {
	
	final static Logger logger = Logger.getLogger(UserJdbcDao.class);

	public void saveUser(UserPojo user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.debug("Driver class loading...");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents", "root",
					"root");

			logger.debug("connection establishing....!!");
			PreparedStatement ps = connection.prepareStatement(
					"insert into  delluser (userId,userName,emailId,mobile,password,city) values(?,?,?,?,?,?)");
			logger.debug("hello--1");
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmailId());
			ps.setString(4, user.getMobile());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getCity());
			logger.debug("hello--2");
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List loginUser(String emailId, String password) {

		List<UserPojo> list = new ArrayList<UserPojo>();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.debug("Driver class loading...");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents", "root",
					"root");

			logger.debug("connection establishing....!!");

			PreparedStatement ps = connection
					.prepareStatement("select emailId,password from delluser where emailId=? and password=?");

			ps.setString(1, emailId);

			ps.setString(2, password);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {

				String emailid = resultSet.getString("emailId");
				String Password = resultSet.getString("password");

				UserPojo user = new UserPojo();

				user.setEmailId(emailid);
				user.setPassword(Password);

				list.add(user);

			}

			ps.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<UserPojo> showUserDetails() {

		List<UserPojo> userdetails = new ArrayList<UserPojo>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.debug("Driver class loading...");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents", "root",
					"root");

			logger.debug("connection establishing....!!");

			PreparedStatement ps = connection.prepareStatement("select * from delluser");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {

				int userId = resultSet.getInt("userId");
				String userName = resultSet.getString("userName");
				String emailId = resultSet.getString("emailId");
				String mobile = resultSet.getString("mobile");
				String password = resultSet.getString("password");
				String city = resultSet.getString("city");

				UserPojo user = new UserPojo();

				user.setUserId(userId);
				user.setUserName(userName);
				user.setEmailId(emailId);
				user.setMobile(mobile);
				user.setPassword(password);
				user.setCity(city);

				userdetails.add(user);
			}
			ps.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userdetails;
	}

	public List<UserPojo> editUser(int userId) {

		List<UserPojo> userInfo = new ArrayList<UserPojo>();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.debug("Driver class loading...");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents", "root",
					"root");

			logger.debug("connection establishing....!!");

			PreparedStatement ps = connection.prepareStatement("select * from delluser where userId=?");
			ps.setInt(1, userId);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {

				int userid = resultSet.getInt("userId");
				String userName = resultSet.getString("userName");
				String emailId = resultSet.getString("emailId");
				String mobile = resultSet.getString("mobile");
				String password = resultSet.getString("password");
				String city = resultSet.getString("city");

				UserPojo user = new UserPojo();

				user.setUserId(userid);
				user.setUserName(userName);
				user.setEmailId(emailId);
				user.setMobile(mobile);
				user.setPassword(password);
				user.setCity(city);

				userInfo.add(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}

	@Override
	public List<UserPojo> updateUser(UserPojo user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.debug("Driver class loading...");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents", "root",
					"root");

			logger.debug("connection establishing....!!");

			PreparedStatement ps = connection.prepareStatement(
					"UPDATE delluser SET userName=?, emailId=?,mobile=?,password=?, city=? WHERE userId=?");

			logger.debug("hello--1");

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getEmailId());
			ps.setString(3, user.getMobile());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getCity());
			ps.setInt(6, user.getUserId());
			logger.debug("hello--2");
			ps.executeUpdate();
			ps.close();
			logger.debug("hello--32");
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserJdbcDao userjdbc = new UserJdbcDao();
		List<UserPojo> userInfo = userjdbc.showUserDetails();
		return userInfo;
	}

	public int deleteUserDetails(int userId) {

		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.debug("Driver class loading...");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents", "root",
					"root");

			logger.debug("connection establishing....!!");

			PreparedStatement ps = connection.prepareStatement("DELETE FROM delluser WHERE userId=" + userId);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<UserPojo> fetchmemory() {

		UserJdbcDao userjdbc = new UserJdbcDao();
		List<UserPojo> userInfo = userjdbc.showUserDetails();

		return userInfo;
	}
}
