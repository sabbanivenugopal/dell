package com.testIocScopes;

public class AadharCard {
	
	private int aadharNumber;
	private int dob;
	
	
	public AadharCard(int aadharNumber, int dob) {
		
		this.aadharNumber = aadharNumber;
		this.dob = dob;
	}



	public int getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(int aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	

}
