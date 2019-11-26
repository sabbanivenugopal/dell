package com.userServices;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.emailvalidation.MailidValidation;
import com.user.pojo.UserPojo;
import com.userDaoJdbcImpl.UserJdbcDao;

import IuserDaoImpl.IuserDao;
import mobilevalidation.Validation;

public class UserServices {

	final static Logger logger = Logger.getLogger(UserServices.class);
	
	@Autowired
	IuserDao ud;

	public String saveUser(UserPojo user, Model m) {
		logger.debug("enter in to the saveUser metnod :: userServices class");

		Validation valid = new Validation();
		boolean validMobile = valid.isValidMobile(user.getMobile());

		if (!validMobile) {
			m.addAttribute("message", "Invalid mobile number plese enter valid mobile number!!");
			return "Register";
		}
		logger.debug("completed mobile validation..!!");

		boolean validEmail = MailidValidation.isValid(user.getEmailId());

		if (!validEmail) {
			m.addAttribute("message", "Invalid emailid plese enter valid emailid!!");
			return "Register";
		}

		ud.saveUser(user);

		return "Login";
	}

	public String loginUser(String emailId, String password, Model m,HttpSession httpsession) {

		List list = ud.loginUser(emailId, password);
		logger.debug("hello--4");

		if (list.isEmpty()) {
			m.addAttribute("message", "Invalid emailid and password");
			return "Login";
		}

		httpsession.setAttribute("emailId",emailId );
		
		return "Home";
	}

	public String showUserDetails(Model model) {

		logger.debug("This is the java class--showuserdetails:: UserServices");
		List<UserPojo> userdetails = ud.showUserDetails();

		model.addAttribute("userdetails", userdetails);
		return "showuserdetails";
	}

	public String editUser(int userId, Model model) {

		List<UserPojo> userInfo = ud.editUser(userId);
		logger.debug("edituser page is here done..!!");
		model.addAttribute("userInfo", userInfo.get(0));

		return "updateUser";
	}

	public String updateUser(UserPojo user, Model model) {

		List<UserPojo> userInfo = ud.updateUser(user);
		model.addAttribute("user", "user details updated sucessfully..!!");
		model.addAttribute("userdetails", userInfo);
		return "showuserdetails";
	}

	public String deleteUserDetails(int userId, Model model) {

		logger.debug("this is the deleteUserDetails::Services");

		int result = ud.deleteUserDetails(userId);
		if (result == 1) {
			model.addAttribute("user", userId + " details deleted sucessfully..!!");
		} else {
			model.addAttribute("user", "failed to deleted..!!");
		}

		List<UserPojo> fetchmemory = ud.fetchmemory();
		model.addAttribute("userdetails", fetchmemory);
		return "showuserdetails";
	}

	

}