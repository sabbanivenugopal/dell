package com.testIocScopes;

import java.util.List;

public class TestIocPojo {
	
	private int studentId;
	private String studentName;
	private String studentcollege;
	private String studentcity;
	
	private Passport passport;
	private AadharCard aadhar;
	
	private List<String> subjects;
	
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentcollege() {
		return studentcollege;
	}
	public void setStudentcollege(String studentcollege) {
		this.studentcollege = studentcollege;
	}
	public String getStudentcity() {
		return studentcity;
	}
	public void setStudentcity(String studentcity) {
		this.studentcity = studentcity;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public AadharCard getAadhar() {
		return aadhar;
	}
	public void setAadhar(AadharCard aadhar) {
		this.aadhar = aadhar;
	}
	
	

}
