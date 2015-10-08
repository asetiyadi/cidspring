package com.wireless.domain;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable 
{
	private static final long serialVersionUID = 788378239381283607L;

	private String firstName;
	private String lastName;
	private Date dob;
	private Address address;
	private String authId;
	private char customerType;
	private String ssn = "999999999";
	private String id;
	private String homePhone;
	private String workPhone;
	private String businessName;
	private String email;

	public Customer(){
		this.address = new Address();
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public char getCustomerType() {
		return customerType;
	}

	public void setCustomerType(char customerType) {
		this.customerType = customerType;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName
				+ ", dob=" + dob + ", address=" + address + ", authId=" + authId + ", customerType="
				+ customerType + ", ssn=" + ssn + "]";
	}
}
