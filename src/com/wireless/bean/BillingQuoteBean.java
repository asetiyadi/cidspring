package com.wireless.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.wireless.domain.Device;

public class BillingQuoteBean implements Serializable 
{
	private static final long serialVersionUID = -1064399819235906809L;

	private String billingAccountNumber;
	//private BillingQuoteDetailsBean billingQuoteDetailsBean;
	private String billingQuoteId;
	private String customerId;
	private HotBillChargesBean[] hotBillCharges;
	private Device device;
	private String newEsn;
	private String newMeid;
	private String newMdn;
	private String newMin;
	private PostPaymentReferenceBean[] paymentReference;
	
	private String billingQuoteNumber;
	private String quoteStatus;
	private String quoteType;    
	private String mdn;
	private String min;
	private Date createdDate;
	private Date lastModifiedDate;
	private boolean pointOfNoReturn;
	private String orderType;
	private String salesChannel;
	private String storeLocation;
	private boolean manualOrderApprovalRequired;
	private String salesRepresentative;
	//private String myCricketOrderPaymentHoldID;
	//private float myCricketOrderPaymentAmount;	
	private String posOrderPaymentHoldID;
	private String billingOrderNumber;
	private String orderStatus;
	
	private String dealerCode;
	private String locationId;
	private String drawerId;
	private String terminalId;
	private String notes;
	private BigDecimal amountDueToday;
	
	//private ApplicationErrorBean applicationErrorBean;
	
	public BillingQuoteBean()		{}

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

	/*
	public BillingQuoteDetailsBean getBillingQuoteDetailsBean() {
		return billingQuoteDetailsBean;
	}

	
	public void setBillingQuoteDetailsBean(
			BillingQuoteDetailsBean billingQuoteDetailsBean) {
		this.billingQuoteDetailsBean = billingQuoteDetailsBean;
	}
	*/
	/**
	 * @return the billingQuoteId
	 */
	public String getBillingQuoteId() {
		return billingQuoteId;
	}

	/**
	 * @param billingQuoteId the billingQuoteId to set
	 */
	public void setBillingQuoteId(String billingQuoteId) {
		this.billingQuoteId = billingQuoteId;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the hotBillCharges
	 */
	public HotBillChargesBean[] getHotBillCharges() {
		return hotBillCharges;
	}

	/**
	 * @param hotBillCharges the hotBillCharges to set
	 */
	public void setHotBillCharges(HotBillChargesBean[] hotBillCharges) {
		this.hotBillCharges = hotBillCharges;
	}

	/**
	 * @return the device
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(Device device) {
		this.device = device;
	}

	/**
	 * @return the newEsn
	 */
	public String getNewEsn() {
		return newEsn;
	}

	/**
	 * @param newEsn the newEsn to set
	 */
	public void setNewEsn(String newEsn) {
		this.newEsn = newEsn;
	}

	/**
	 * @return the newMeid
	 */
	public String getNewMeid() {
		return newMeid;
	}

	/**
	 * @param newMeid the newMeid to set
	 */
	public void setNewMeid(String newMeid) {
		this.newMeid = newMeid;
	}

	/**
	 * @return the newMdn
	 */
	public String getNewMdn() {
		return newMdn;
	}

	/**
	 * @param newMdn the newMdn to set
	 */
	public void setNewMdn(String newMdn) {
		this.newMdn = newMdn;
	}

	/**
	 * @return the newMin
	 */
	public String getNewMin() {
		return newMin;
	}

	/**
	 * @param newMin the newMin to set
	 */
	public void setNewMin(String newMin) {
		this.newMin = newMin;
	}

	/**
	 * @return the paymentReference
	 */
	public PostPaymentReferenceBean[] getPaymentReference() {
		return paymentReference;
	}

	/**
	 * @param paymentReference the paymentReference to set
	 */
	public void setPaymentReference(PostPaymentReferenceBean[] paymentReference) {
		this.paymentReference = paymentReference;
	}

	public boolean isPointOfNoReturn() {
		return pointOfNoReturn;
	}

	public void setPointOfNoReturn(boolean pointOfNoReturn) {
		this.pointOfNoReturn = pointOfNoReturn;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

	public boolean isManualOrderApprovalRequired() {
		return manualOrderApprovalRequired;
	}

	public void setManualOrderApprovalRequired(boolean manualOrderApprovalRequired) {
		this.manualOrderApprovalRequired = manualOrderApprovalRequired;
	}

	public String getSalesRepresentative() {
		return salesRepresentative;
	}

	public void setSalesRepresentative(String salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

	public String getBillingQuoteNumber() {
		return billingQuoteNumber;
	}

	public void setBillingQuoteNumber(String billingQuoteNumber) {
		this.billingQuoteNumber = billingQuoteNumber;
	}

	public String getQuoteStatus() {
		return quoteStatus;
	}

	public void setQuoteStatus(String quoteStatus) {
		this.quoteStatus = quoteStatus;
	}

	public String getQuoteType() {
		return quoteType;
	}

	public void setQuoteType(String quoteType) {
		this.quoteType = quoteType;
	}

	public String getMdn() {
		return mdn;
	}

	public void setMdn(String mdn) {
		this.mdn = mdn;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	/*
	public String getMyCricketOrderPaymentHoldID() {
		return myCricketOrderPaymentHoldID;
	}

	public void setMyCricketOrderPaymentHoldID(String myCricketOrderPaymentHoldID) {
		this.myCricketOrderPaymentHoldID = myCricketOrderPaymentHoldID;
	}

	public float getMyCricketOrderPaymentAmount() {
		return myCricketOrderPaymentAmount;
	}

	public void setMyCricketOrderPaymentAmount(float myCricketOrderPaymentAmount) {
		this.myCricketOrderPaymentAmount = myCricketOrderPaymentAmount;
	}
	*/
	public String getPosOrderPaymentHoldID() {
		return posOrderPaymentHoldID;
	}

	public void setPosOrderPaymentHoldID(String posOrderPaymentHoldID) {
		this.posOrderPaymentHoldID = posOrderPaymentHoldID;
	}

	public String getBillingOrderNumber() {
		return billingOrderNumber;
	}

	public void setBillingOrderNumber(String billingOrderNumber) {
		this.billingOrderNumber = billingOrderNumber;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getDrawerId() {
		return drawerId;
	}

	public void setDrawerId(String drawerId) {
		this.drawerId = drawerId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	/*
	public ApplicationErrorBean getApplicationErrorBean() {
		return applicationErrorBean;
	}

	public void setApplicationErrorBean(ApplicationErrorBean applicationErrorBean) {
		this.applicationErrorBean = applicationErrorBean;
	}
	*/

	public BigDecimal getAmountDueToday() {
		return amountDueToday;
	}

	public void setAmountDueToday(BigDecimal amountDueToday) {
		this.amountDueToday = amountDueToday;
	}

	@Override
	public String toString() {
		return "BillingQuoteBean [billingAccountNumber=" + billingAccountNumber
				+ ", billingQuoteId=" + billingQuoteId + ", customerId="
				+ customerId + ", hotBillCharges="
				+ Arrays.toString(hotBillCharges) + ", device=" + device
				+ ", newEsn=" + newEsn + ", newMeid=" + newMeid + ", newMdn="
				+ newMdn + ", newMin=" + newMin + ", paymentReference="
				+ Arrays.toString(paymentReference) + ", billingQuoteNumber="
				+ billingQuoteNumber + ", quoteStatus=" + quoteStatus
				+ ", quoteType=" + quoteType + ", mdn=" + mdn + ", min=" + min
				+ ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + ", pointOfNoReturn=" + pointOfNoReturn
				+ ", orderType=" + orderType + ", salesChannel=" + salesChannel
				+ ", storeLocation=" + storeLocation
				+ ", manualOrderApprovalRequired="
				+ manualOrderApprovalRequired + ", salesRepresentative="
				+ salesRepresentative + ", posOrderPaymentHoldID="
				+ posOrderPaymentHoldID + ", billingOrderNumber="
				+ billingOrderNumber + ", orderStatus=" + orderStatus
				+ ", dealerCode=" + dealerCode + ", locationId=" + locationId
				+ ", drawerId=" + drawerId + ", terminalId=" + terminalId
				+ ", notes=" + notes + ", amountDueToday=" + amountDueToday
				+ "]";
	}
}	
