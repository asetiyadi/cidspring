package com.wireless.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import com.wireless.bean.BillingBean;

public class Account implements Serializable 
{
	private static final long serialVersionUID = 7239025522835906270L;
	
	private Customer customer;
	private Subscriber[] subscribers;
	private String marketId;
	private String accountNumber;
	private char language;
	private String solicitationContactPreference;
	private String accountType;
	private int rateCenterId;
	private int jointVentureCode = 401;
	private char electronicBillReporting = 'A';
	//private String networkProviderName;
	private int productCode;
	private Date effectiveDate;
	private String accountStatus;
	private BillingBean billing;
	private String[] creditRiskCodes;
	
	public Account(){
		this.customer = new Customer();
		
		Subscriber subscriber = new Subscriber();
		this.subscribers = new Subscriber[1];
		this.subscribers[0] = subscriber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Subscriber getSubscriber(int index) {
		return this.subscribers[index];
	}
	
	public Subscriber[] getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Subscriber[] subscribers) {
		this.subscribers = subscribers;
	}

	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public char getLanguage() {
		return language;
	}

	public void setLanguage(char language) {
		this.language = language;
	}

	public String getSolicitationContactPreference() {
		return solicitationContactPreference;
	}

	public void setSolicitationContactPreference(
			String solicitationContactPreference) {
		this.solicitationContactPreference = solicitationContactPreference;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getRateCenterId() {
		return rateCenterId;
	}

	public void setRateCenterId(int rateCenterId) {
		this.rateCenterId = rateCenterId;
	}

	public int getJointVentureCode() {
		return jointVentureCode;
	}

	public void setJointVentureCode(int jointVentureCode) {
		this.jointVentureCode = jointVentureCode;
	}

	public char getElectronicBillReporting() {
		return electronicBillReporting;
	}

	public void setElectronicBillReporting(char electronicBillReporting) {
		this.electronicBillReporting = electronicBillReporting;
	}
	/*
	public String getNetworkProviderName() {
		return networkProviderName;
	}

	public void setNetworkProviderName(String networkProviderName) {
		this.networkProviderName = networkProviderName;
	}
	*/
	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public BillingBean getBilling() {
		return billing;
	}

	public void setBilling(BillingBean billing) {
		this.billing = billing;
	}

	public String[] getCreditRiskCodes() {
		return creditRiskCodes;
	}

	public void setCreditRiskCodes(String[] creditRiskCodes) {
		this.creditRiskCodes = creditRiskCodes;
	}

	@Override
	public String toString() {
		return "Account [customer=" + customer + ", subscribers="
				+ Arrays.toString(subscribers) + ", marketId=" + marketId
				+ ", accountNumber=" + accountNumber + ", language=" + language
				+ ", solicitationContactPreference="
				+ solicitationContactPreference + ", accountType="
				+ accountType + ", rateCenterId=" + rateCenterId
				+ ", jointVentureCode=" + jointVentureCode
				+ ", electronicBillReporting=" + electronicBillReporting
				+ ", productCode=" + productCode + ", effectiveDate="
				+ effectiveDate + ", accountStatus=" + accountStatus
				+ ", billing=" + billing + ", creditRiskCodes="
				+ Arrays.toString(creditRiskCodes) + "]";
	}
}
