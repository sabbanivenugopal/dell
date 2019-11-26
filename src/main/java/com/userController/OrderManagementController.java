package com.userController;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.pojo.ItemManagementPojo;
import com.userDao.OrderManagementDao;
import com.userServices.OrderManagementServices;
import com.userServices.UserServices;


@Controller
public class OrderManagementController {
	
	final static Logger logger=Logger.getLogger(OrderManagementController.class);

	@Autowired
	OrderManagementServices ms;

	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public String saveItem() {

		logger.debug("This is the java class--userItem");

		return "enteritem";
	}

	@RequestMapping(value = "/addtomenu", method = RequestMethod.POST)
	public String addItemsToDb(ItemManagementPojo item, Model m) {

		ms.addItemsToDb(item, m);

		m.addAttribute("msg", "Item added to menu successfully..!!");
		return "enteritem";
	}

	@RequestMapping(value = "/showitemmenu", method = RequestMethod.POST)
	public String showMenu(Model m) {

		logger.debug("this is the show menu::OrderManagementController ..!!");

		String res = ms.showMenu(m);

		

		return res;
	}

	@RequestMapping(value = "/deleteitem", method = RequestMethod.POST)
	public String deleteitem(@RequestParam("itemid") int itemid, Model m) {

		logger.debug("enter into the  deleteitem:: userController");

		String result = ms.deleteitem(itemid, m);

		return result;
	}

	@RequestMapping(value = "/edititem")
	public String edititem(@RequestParam("itemid") int itemid, Model model) {
		
		logger.debug("this  is the edititem page :: OrderManagement Controller");
		
		String res=ms.edititem(itemid, model);
		
		return res;
	}
	@RequestMapping(value="/updateitem",method= RequestMethod.POST)
	public String updateitem(ItemManagementPojo useritem,Model model) {
		
		String res=null;
		try {
		res=ms.updateitem(useritem,model);
		}
		catch(StaleObjectStateException e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",
					"The record has been modified by other by user, kindly take the latest and update");
			return "updateitem";
		}
		
		return res;
	}
}
