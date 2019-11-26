package com.testIocScopes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestIocScopes {
	
	@Autowired
	private	TestIocPojo std1;
	
	@Autowired
	private TestIocPojo std2;
	
	@Qualifier(value="brl")
	@Autowired
	private College c1;

	@Qualifier(value="vks")
	@Autowired
	private College c2;
	
	@Qualifier(value="brl")
	@Autowired
	private College c3;
	
	@RequestMapping(value="/testIoc")
	public String testIoc(){
		
		System.out.println("Hai Spring Ioc");
		
		System.out.println("-----college----");
		
		c1.setLocation("Karimnager");
		c2.setLocation("sircilla");
		c3.setLocation("hyderabad");
		
		System.out.println(c1.getClgname()+"  " +c1.getLocation());
		System.out.println(c2.getClgname()+"  " +c2.getLocation());
		System.out.println(c3.getClgname()+"  " +c3.getLocation());
		
		System.out.println("-----college----");
		
	
		std1.setStudentId(101);
		std1.setStudentName("venugopal");
		std1.getPassport().setPassPortId(5501);
		std1.getPassport().setIssueLocation("hyd");
		
		//std1.getAadhar().setAadharNumber(1234);
		//std1.getAadhar().setDob(1994);
		
		
		
	
		std2.setStudentId(102);
		std2.setStudentName("Harish");
		
		std2.getPassport().setPassPortId(5502);
		std2.getPassport().setIssueLocation("sec");
		
	//	std2.getAadhar().setAadharNumber(4321);
		// std2.getAadhar().setDob(1995);
		
		/*
		 * List<String> sub=std1.getSubjects(); for (String subjects : sub) {
		 * System.out.println(subjects);
		 * 
		 * }
		 */
		
		System.out.println(std2.getStudentId()+"--"+std2.getStudentName()+"--"+std2.getStudentcollege()+"--"+std2.getStudentcity()+"--"+std2.getPassport().getIssueLocation()+"--"+std2.getPassport().getPassPortId()+"--"+std2.getAadhar().getAadharNumber());
		System.out.println(std1.getStudentId()+"--"+std1.getStudentName()+"--"+std1.getStudentcollege()+"--"+std1.getStudentcity()+"--"+std1.getPassport().getIssueLocation()+"--"+std1.getPassport().getPassPortId()+"--"+std1.getAadhar().getAadharNumber());
		
		return "Register";
	}

}
