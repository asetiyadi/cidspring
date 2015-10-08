package com.wireless.domain;

import java.io.Serializable;

public class Address implements Serializable 
{
	private static final long serialVersionUID = -3777498690663786008L;

	private String address1;
	private String city;
	private String state;
	private String zip;
	private String zipExtension = "0000";

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getZipExtension() {
		return zipExtension;
	}

	public void setZipExtension(String zipExtension) {
		this.zipExtension = zipExtension;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", zipExtension=" + zipExtension
				+ "]";
	}

}
