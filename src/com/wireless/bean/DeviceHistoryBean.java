package com.wireless.bean;

import java.io.Serializable;
import java.util.Calendar;

public class DeviceHistoryBean implements Serializable 
{
	private static final long serialVersionUID = 8904619437582107354L;

	private String billingAccountNumber;
	private String billingSourceSystemId;
	private String customerServiceRep;
	private Calendar effectiveDate;
	private String mdn;
	private Calendar processedDate;
	private String deviceStatus;
	private String workOrderNumber;
	
	public DeviceHistoryBean()	{}
	
	/**
	 * @return the customerServiceRep
	 */
	public String getCustomerServiceRep() {
		return customerServiceRep;
	}

	/**
	 * @param customerServiceRep the customerServiceRep to set
	 */
	public void setCustomerServiceRep(String customerServiceRep) {
		this.customerServiceRep = customerServiceRep;
	}

	/**
	 * @return the effectiveDate
	 */
	public Calendar getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Calendar effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the mdn
	 */
	public String getMdn() {
		return mdn;
	}

	/**
	 * @param mdn the mdn to set
	 */
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}

	/**
	 * @return the processedDate
	 */
	public Calendar getProcessedDate() {
		return processedDate;
	}

	/**
	 * @param processedDate the processedDate to set
	 */
	public void setProcessedDate(Calendar processedDate) {
		this.processedDate = processedDate;
	}

	/**
	 * @return the deviceStatus
	 */
	public String getDeviceStatus() {
		return deviceStatus;
	}

	/**
	 * @param deviceStatus the deviceStatus to set
	 */
	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	/**
	 * @return the workOrderNumber
	 */
	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	/**
	 * @param workOrderNumber the workOrderNumber to set
	 */
	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}

	/**
	 * @return the billingAccountNumber
	 */
	public String getBillingAccountNumber() {
		return billingAccountNumber;
	}

	/**
	 * @param billingAccountNumber the billingAccountNumber to set
	 */
	public void setBillingAccountNumber(String billingAccountNumber) {
		this.billingAccountNumber = billingAccountNumber;
	}

	/**
	 * @return the billingSourceSystemId
	 */
	public String getBillingSourceSystemId() {
		return billingSourceSystemId;
	}

	/**
	 * @param billingSourceSystemId the billingSourceSystemId to set
	 */
	public void setBillingSourceSystemId(String billingSourceSystemId) {
		this.billingSourceSystemId = billingSourceSystemId;
	}
}
