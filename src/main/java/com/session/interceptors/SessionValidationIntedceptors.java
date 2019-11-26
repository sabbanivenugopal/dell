package com.session.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionValidationIntedceptors extends HandlerInterceptorAdapter{
	
	final static Logger logger=Logger.getLogger(SessionValidationIntedceptors.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession httpSession = request.getSession();
		
		String emailId=(String) httpSession.getAttribute("emailId");
		System.out.println("show menu");
		logger.debug("username in session is:" +emailId);
		if(emailId==null||emailId.isEmpty()) {
			logger.debug("userName not available in session");
			
			ModelAndView mv=new ModelAndView("Login");
			mv.addObject("message", "please login to access this page");
			throw new ModelAndViewDefiningException(mv);
			
		}else {
			logger.debug("userName available in this session");
			logger.debug("User already loged in!!");
			return true;
			
		}
		
		
	}

}
