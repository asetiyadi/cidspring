package com.wireless.domain;

import java.io.Serializable;

import com.wireless.bean.BundledOfferingBean;
import com.wireless.bean.PricePlanBean;

public class Subscriber implements Serializable
{
	private static final long serialVersionUID = -5029668193090290427L;
	
	private Device device;
	private boolean billingResponsibleParty;
	private Contract contract;
	//private CricketOfferingCodes cricketOfferingCodes;
	private boolean receiveNotification;
	private String[] offeringCodes;
	private BundledOfferingBean[] bundledOfferings;
	private PricePlanBean pricePlan;
	private String mdn;
	private String[] notes;
	private int rateCenterId;
	private String status;
	private String subscriptionLifeCycleType;
	private String subscriptionType;
	private String portStatus;

	public Subscriber() {
		this.device = new Device();
	}
	
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public boolean isBillingResponsibleParty() {
		return billingResponsibleParty;
	}

	public void setBillingResponsibleParty(boolean billingResponsibleParty) {
		this.billingResponsibleParty = billingResponsibleParty;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public boolean isReceiveNotification() {
		return receiveNotification;
	}

	public void setReceiveNotification(boolean receiveNotification) {
		this.receiveNotification = receiveNotification;
	}

	public String[] getOfferingCodes() {
		return offeringCodes;
	}

	public void setOfferingCodes(String[] offeringCodes) {
		this.offeringCodes = offeringCodes;
	}

	public BundledOfferingBean[] getBundledOfferings() {
		return bundledOfferings;
	}

	public void setBundledOfferings(BundledOfferingBean[] bundleOfferings) {
		this.bundledOfferings = bundleOfferings;
	}

	public PricePlanBean getPricePlan() {
		return pricePlan;
	}

	public void setPricePlan(PricePlanBean pricePlan) {
		this.pricePlan = pricePlan;
	}

	public String getMdn() {
		return mdn;
	}

	public void setMdn(String mdn) {
		this.mdn = mdn;
	}

	public String[] getNotes() {
		return notes;
	}

	public void setNotes(String[] notes) {
		this.notes = notes;
	}

	public int getRateCenterId() {
		return rateCenterId;
	}

	public void setRateCenterId(int rateCenterId) {
		this.rateCenterId = rateCenterId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubscriptionLifeCycleType() {
		return subscriptionLifeCycleType;
	}

	public void setSubscriptionLifeCycleType(String subscriptionLifeCycleType) {
		this.subscriptionLifeCycleType = subscriptionLifeCycleType;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public String getPortStatus() {
		return portStatus;
	}

	public void setPortStatus(String portStatus) {
		this.portStatus = portStatus;
	}

	@Override
	public String toString() {
		return "Subscriber [device=" + device + ", billingResponsibleParty="
				+ billingResponsibleParty + ", contract=" + contract
				+ ", receiveNotification=" + receiveNotification
				+ ", offeringCode=" + offeringCodes + "]";
	}
	
}
