package com.userServices;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.orderManagementDaoJdbcImpl.OrderManagementJdbcDao;
import com.user.pojo.ItemManagementPojo;
import com.userDao.OrderManagementDao;
import com.userDao.UserDao;

import IuserDaoImpl.IorderManagementDao;


public class OrderManagementServices {
	
	final static Logger logger=Logger.getLogger(OrderManagementServices.class);

	@Autowired
	IorderManagementDao md;

	public void addItemsToDb(ItemManagementPojo item, Model m) {
		logger.debug(item.getItemid() + "--" + item.getItem() + "--" + item.getTypeof());
		logger.debug("This is the java class--addItemsToDb");

		md.addItemsToDb(item);

	}

	public String showMenu(Model m) {

		logger.debug("this is the show menu::: OrderManagementServices..!!");
		
		List res = md.showMenu();
		m.addAttribute("menu", res);

		return "showmenu";
	}

	public String deleteitem(int itemid, Model m) {

		logger.debug("enter into the  deleteitem:: userServices");

		int result = md.deleteitem(itemid);

		if (result == 1) {
			logger.debug("successfully deleted item..!!");
			m.addAttribute("message", itemid+" "+"itemId delete sucessfully..!!");

		} else {
			logger.debug("failed to deleted..!!");
			m.addAttribute("msg", itemid + "delete failed");
		}
		
		List menuData = md.fetchmemory();
		
		m.addAttribute("menu", menuData);
		
		return "showmenu";
	}

	public String edititem(int itemid, Model model) {

		logger.debug("this  is the edititem page :: OrderManagement Services");
		
		ItemManagementPojo	itemInfo=md.edititem(itemid);
		if (itemInfo.getTypeof().equals("veg")) {
			model.addAttribute("veg", "checked");
		} else {
			model.addAttribute("nonveg", "checked");
		}
		
		model.addAttribute("message", "item Updated sucessfully..!");
		
		model.addAttribute("itemInfo", itemInfo);
		return "updateitem";
	}
	
	public String updateitem(ItemManagementPojo useritem,Model model) {
		
		
		List<ItemManagementPojo> itemInfo=md.updateitem(useritem);
		
		model.addAttribute("menu", itemInfo);
		return "showmenu";
	}
}
