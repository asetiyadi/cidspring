package com.wireless.domain;

import java.io.Serializable;
import java.util.HashMap;

public class UserBean implements Serializable
{
	private static final long serialVersionUID = 6429415225729803507L;

	public static final String SALES_CHANNEL_CSR = "CID-CSR";
	
	private String userName;
	private Boolean authenticated;
	private String password;
	private String channelType;
	private String firstName;
	private String lastName;
	private String authRoles;
	private String authRolesDistinguishedName;
	private Boolean clockedIn;
	private String authorizedLocations;
	private HashMap<String, String> permissions;
	private String locationId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
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

	public String getAuthRoles() {
		return authRoles;
	}

	public void setAuthRoles(String authRoles) {
		this.authRoles = authRoles;
	}

	public String getAuthRolesDistinguishedName() {
		return authRolesDistinguishedName;
	}

	public void setAuthRolesDistinguishedName(String authRolesDistinguishedName) {
		this.authRolesDistinguishedName = authRolesDistinguishedName;
	}

	public Boolean getClockedIn() {
		return clockedIn;
	}

	public void setClockedIn(Boolean clockedIn) {
		this.clockedIn = clockedIn;
	}

	public String getAuthorizedLocations() {
		return authorizedLocations;
	}

	public void setAuthorizedLocations(String authorizedLocations) {
		this.authorizedLocations = authorizedLocations;
	}

	public HashMap<String, String> getPermissions() {
		return permissions;
	}

	public void setPermissions(HashMap<String, String> permissions) {
		this.permissions = permissions;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "UserBean [userName=" + userName + ", authenticated="
				+ authenticated + ", password=" + password + ", channelType="
				+ channelType + ", firstName=" + firstName + ", lastName="
				+ lastName + ", authRoles=" + authRoles
				+ ", authRolesDistinguishedName=" + authRolesDistinguishedName
				+ ", clockedIn=" + clockedIn + ", authorizedLocations="
				+ authorizedLocations + ", permissions=" + permissions
				+ ", locationId=" + locationId + "]";
	}
}
