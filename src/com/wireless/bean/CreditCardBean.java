package com.wireless.bean;

import java.io.Serializable;

import com.wireless.domain.Address;

public class CreditCardBean implements Serializable
{
	private static final long serialVersionUID = 5646309250389405639L;

	public static final String CREDITCARD_CARDTYPE_VISA = "VISA";
	public static final String CREDITCARD_CARDTYPE_MASTER = "MASTER";
	
	private String cardType;
	private String cardToken;
	private String expirationMonth;
	private String expirationYear;
	private String firstName;
	private String lastName;
	private Address address;
	private boolean isDebit;
	private String cvn;

	public CreditCardBean() {
		this.address = new Address();
	}
	
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardToken() {
		return cardToken;
	}

	public void setCardToken(String cardToken) {
		this.cardToken = cardToken;
	}

	public String getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public String getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isDebit() {
		return isDebit;
	}

	public void setDebit(boolean isDebit) {
		this.isDebit = isDebit;
	}

	public String getCvn() {
		return cvn;
	}

	public void setCvn(String cvn) {
		this.cvn = cvn;
	}

	@Override
	public String toString() {
		return "CreditCardBean [cardType=" + cardType + ", cardToken="
				+ cardToken + ", expirationMonth=" + expirationMonth
				+ ", expirationYear=" + expirationYear + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address
				+ ", isDebit=" + isDebit + ", cvn=" + cvn + "]";
	}
}
