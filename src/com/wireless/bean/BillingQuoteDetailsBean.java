package com.wireless.bean;

import java.io.Serializable;
import java.util.Date;

public class BillingQuoteDetailsBean implements Serializable 
{
	private static final long serialVersionUID = 7317503371643348289L;

	private String billingQuoteNumber;
	private String quoteStatus;
	private String quoteType;
	private String billingAccountNumber;
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
	private String myCricketOrderPaymentHoldID;
	private float myCricketOrderPaymentAmount;
	private String posOrderPaymentHoldID;
	private String billingOrderNumber;
	private String orderStatus;

	private String dealerCode;
	private String locationId;
	private String drawerId;
	private String terminalId;
	private String notes;

	public BillingQuoteDetailsBean() {
	}

	private int depositRecommendationAmount;
	private int initialPaymentRecommendationAmount;
	private int nextBillAmount;
	private Date nextBillDate;
	private float oneTimeCharge;
	private int oneTimeTax;
	private int proratedAmount;

	private int recurringTax;
	private int totalOneTimeSaving;
	private float recurringChargeAmount;
	private String recurringChargeItemName;
	private boolean recurringChargesRecurringCharge;

	private float totalRecurringChargesAmount;
	private String totalRecurringChargePeriodUom;
	private int totalRecurringChargePeriod;

	private int recurringSavingAmount;
	private int recurringSavingPeriod;
	private String recurringSavingPeriodUom;

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

	public String getBillingAccountNumber() {
		return billingAccountNumber;
	}

	public void setBillingAccountNumber(String billingAccountNumber) {
		this.billingAccountNumber = billingAccountNumber;
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

	public void setManualOrderApprovalRequired(
			boolean manualOrderApprovalRequired) {
		this.manualOrderApprovalRequired = manualOrderApprovalRequired;
	}

	public String getSalesRepresentative() {
		return salesRepresentative;
	}

	public void setSalesRepresentative(String salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

	public String getMyCricketOrderPaymentHoldID() {
		return myCricketOrderPaymentHoldID;
	}

	public void setMyCricketOrderPaymentHoldID(
			String myCricketOrderPaymentHoldID) {
		this.myCricketOrderPaymentHoldID = myCricketOrderPaymentHoldID;
	}

	public float getMyCricketOrderPaymentAmount() {
		return myCricketOrderPaymentAmount;
	}

	public void setMyCricketOrderPaymentAmount(float myCricketOrderPaymentAmount) {
		this.myCricketOrderPaymentAmount = myCricketOrderPaymentAmount;
	}

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

	public int getDepositRecommendationAmount() {
		return depositRecommendationAmount;
	}

	public void setDepositRecommendationAmount(int depositRecommendationAmount) {
		this.depositRecommendationAmount = depositRecommendationAmount;
	}

	public int getInitialPaymentRecommendationAmount() {
		return initialPaymentRecommendationAmount;
	}

	public void setInitialPaymentRecommendationAmount(
			int initialPaymentRecommendationAmount) {
		this.initialPaymentRecommendationAmount = initialPaymentRecommendationAmount;
	}

	public int getNextBillAmount() {
		return nextBillAmount;
	}

	public void setNextBillAmount(int nextBillAmount) {
		this.nextBillAmount = nextBillAmount;
	}

	public Date getNextBillDate() {
		return nextBillDate;
	}

	public void setNextBillDate(Date nextBillDate) {
		this.nextBillDate = nextBillDate;
	}

	public float getOneTimeCharge() {
		return oneTimeCharge;
	}

	public void setOneTimeCharge(float oneTimeCharge) {
		this.oneTimeCharge = oneTimeCharge;
	}

	public int getOneTimeTax() {
		return oneTimeTax;
	}

	public void setOneTimeTax(int oneTimeTax) {
		this.oneTimeTax = oneTimeTax;
	}

	public int getProratedAmount() {
		return proratedAmount;
	}

	public void setProratedAmount(int proratedAmount) {
		this.proratedAmount = proratedAmount;
	}

	public int getRecurringTax() {
		return recurringTax;
	}

	public void setRecurringTax(int recurringTax) {
		this.recurringTax = recurringTax;
	}

	public int getTotalOneTimeSaving() {
		return totalOneTimeSaving;
	}

	public void setTotalOneTimeSaving(int totalOneTimeSaving) {
		this.totalOneTimeSaving = totalOneTimeSaving;
	}

	public float getRecurringChargeAmount() {
		return recurringChargeAmount;
	}

	public void setRecurringChargeAmount(float recurringChargeAmount) {
		this.recurringChargeAmount = recurringChargeAmount;
	}

	public String getRecurringChargeItemName() {
		return recurringChargeItemName;
	}

	public void setRecurringChargeItemName(String recurringChargeItemName) {
		this.recurringChargeItemName = recurringChargeItemName;
	}

	public boolean isRecurringChargesRecurringCharge() {
		return recurringChargesRecurringCharge;
	}

	public void setRecurringChargesRecurringCharge(
			boolean recurringChargesRecurringCharge) {
		this.recurringChargesRecurringCharge = recurringChargesRecurringCharge;
	}

	public float getTotalRecurringChargesAmount() {
		return totalRecurringChargesAmount;
	}

	public void setTotalRecurringChargesAmount(float totalRecurringChargesAmount) {
		this.totalRecurringChargesAmount = totalRecurringChargesAmount;
	}

	public String getTotalRecurringChargePeriodUom() {
		return totalRecurringChargePeriodUom;
	}

	public void setTotalRecurringChargePeriodUom(
			String totalRecurringChargePeriodUom) {
		this.totalRecurringChargePeriodUom = totalRecurringChargePeriodUom;
	}

	public int getTotalRecurringChargePeriod() {
		return totalRecurringChargePeriod;
	}

	public void setTotalRecurringChargePeriod(int totalRecurringChargePeriod) {
		this.totalRecurringChargePeriod = totalRecurringChargePeriod;
	}

	public int getRecurringSavingAmount() {
		return recurringSavingAmount;
	}

	public void setRecurringSavingAmount(int recurringSavingAmount) {
		this.recurringSavingAmount = recurringSavingAmount;
	}

	public int getRecurringSavingPeriod() {
		return recurringSavingPeriod;
	}

	public void setRecurringSavingPeriod(int recurringSavingPeriod) {
		this.recurringSavingPeriod = recurringSavingPeriod;
	}

	public String getRecurringSavingPeriodUom() {
		return recurringSavingPeriodUom;
	}

	public void setRecurringSavingPeriodUom(String recurringSavingPeriodUom) {
		this.recurringSavingPeriodUom = recurringSavingPeriodUom;
	}

	@Override
	public String toString() {
		return "BillingQuoteDetailsBean [billingQuoteNumber="
				+ billingQuoteNumber + ", quoteStatus=" + quoteStatus
				+ ", quoteType=" + quoteType + ", billingAccountNumber="
				+ billingAccountNumber + ", mdn=" + mdn + ", min=" + min
				+ ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + ", pointOfNoReturn=" + pointOfNoReturn
				+ ", orderType=" + orderType + ", salesChannel=" + salesChannel
				+ ", storeLocation=" + storeLocation
				+ ", manualOrderApprovalRequired="
				+ manualOrderApprovalRequired + ", salesRepresentative="
				+ salesRepresentative + ", myCricketOrderPaymentHoldID="
				+ myCricketOrderPaymentHoldID
				+ ", myCricketOrderPaymentAmount="
				+ myCricketOrderPaymentAmount + ", posOrderPaymentHoldID="
				+ posOrderPaymentHoldID + ", billingOrderNumber="
				+ billingOrderNumber + ", orderStatus=" + orderStatus
				+ ", dealerCode=" + dealerCode + ", locationId=" + locationId
				+ ", drawerId=" + drawerId + ", terminalId=" + terminalId
				+ ", notes=" + notes + ", depositRecommendationAmount="
				+ depositRecommendationAmount
				+ ", initialPaymentRecommendationAmount="
				+ initialPaymentRecommendationAmount + ", nextBillAmount="
				+ nextBillAmount + ", nextBillDate=" + nextBillDate
				+ ", oneTimeCharge=" + oneTimeCharge + ", oneTimeTax="
				+ oneTimeTax + ", proratedAmount=" + proratedAmount
				+ ", recurringTax=" + recurringTax + ", totalOneTimeSaving="
				+ totalOneTimeSaving + ", recurringChargeAmount="
				+ recurringChargeAmount + ", recurringChargeItemName="
				+ recurringChargeItemName
				+ ", recurringChargesRecurringCharge="
				+ recurringChargesRecurringCharge
				+ ", totalRecurringChargesAmount="
				+ totalRecurringChargesAmount
				+ ", totalRecurringChargePeriodUom="
				+ totalRecurringChargePeriodUom
				+ ", totalRecurringChargePeriod=" + totalRecurringChargePeriod
				+ ", recurringSavingAmount=" + recurringSavingAmount
				+ ", recurringSavingPeriod=" + recurringSavingPeriod
				+ ", recurringSavingPeriodUom=" + recurringSavingPeriodUom
				+ "]";
	}

}
