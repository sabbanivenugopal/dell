package com.userController;



import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.pojo.UserPojo;
import com.userServices.UserServices;

@Controller
public class UserController{
	
	@Autowired
	UserServices us;
	final static Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/userregister")
	public String saveUser(UserPojo user, Model m) {

		logger.debug("enter to the saveUser method...!!");

		
		String res = us.saveUser(user, m);

		return res;
	}

	@RequestMapping(value = "/loginuser", method = RequestMethod.POST)
	public String loginUser(@RequestParam("emailId") String emailId, @RequestParam("password") String password,
			Model m,HttpSession httpsession) {

		logger.debug("enter into the loginuser page...!!");
		
		String res = us.loginUser(emailId, password, m,httpsession);
		
		

		return res;
	}
	
	@RequestMapping(value = "/showuserdetails", method = RequestMethod.POST)
	public String showUserDetails(Model model) {

		logger.debug("This is the java class--showuserdetails::UserControllers");
		String res = us.showUserDetails(model);
		
		
		return res;
	}
	@RequestMapping(value="/edituser",method= RequestMethod.POST)
	public String editUser(@RequestParam("userId") int userId,Model model) {
		
		String res = us.editUser(userId,model);
		
		logger.debug("controller");
		return res;
		
	}
	@RequestMapping(value="/updateUserPage",method=RequestMethod.POST)
	public String updateUser(UserPojo user, Model model) {
		String updateUser =null;
		try {
		 updateUser = us.updateUser(user,model);
		}catch(StaleObjectStateException e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",
					"The record has been modified by other by user, kindly take the latest and update");
			return "updateUser";
		}
		
		return updateUser;
}
	@RequestMapping(value = "/deleteuser",method=RequestMethod.POST)
	public String deleteUserDetails(@RequestParam("userId") int userId, Model model) {
		
		logger.debug("this is the deleteUserDetails::controllers");
		
		String userDetails = us.deleteUserDetails(userId,model);
		
		return userDetails;
	}

}