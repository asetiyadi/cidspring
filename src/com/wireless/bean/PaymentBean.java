package com.wireless.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;

public class PaymentBean implements Serializable
{
	private static final long serialVersionUID = -4425278583438359091L;

	public static final String PAYMENT_TENDER_TYPE_CREDIT = "CREDIT";
	public static final String PAYMENT_TENDER_TYPE_CHECK = "CASHIERS_CHECK";
	public static final String PAYMENT_TENDER_TYPE_CASH = "CASH";
	
	//public static final String PAYMENT_METHOD_CREDITCARD = "CreditCard";
	//public static final String PAYMENT_METHOD_CHECK = "Check";
	
	private String accountNumber;
	private String billingOrderId;
	private String[] billingTransactionId;
	private String contactPhoneNumber;
	private String mdn;
	private String approvalTransactionId;
	private String posSaleId;
	private String transactionId;
	private BigInteger vestaResponseCode;
	private String vestaResponseText;
	private String paymentMethod;
	private CreditCardBean creditCard;
	private String referenceId;
	private String orderId;
	private String resultCode;
	private String resultDescription;
	
	public PaymentBean() {
		this.creditCard = new CreditCardBean();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBillingOrderId() {
		return billingOrderId;
	}

	public void setBillingOrderId(String billingOrderId) {
		this.billingOrderId = billingOrderId;
	}

	public String[] getBillingTransactionId() {
		return billingTransactionId;
	}

	public void setBillingTransactionId(String[] billingTransactionId) {
		this.billingTransactionId = billingTransactionId;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getMdn() {
		return mdn;
	}

	public void setMdn(String mdn) {
		this.mdn = mdn;
	}

	public String getApprovalTransactionId() {
		return approvalTransactionId;
	}

	public void setApprovalTransactionId(String approvalTransactionId) {
		this.approvalTransactionId = approvalTransactionId;
	}

	public String getPosSaleId() {
		return posSaleId;
	}

	public void setPosSaleId(String posSaleId) {
		this.posSaleId = posSaleId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public BigInteger getVestaResponseCode() {
		return vestaResponseCode;
	}

	public void setVestaResponseCode(BigInteger vestaResponseCode) {
		this.vestaResponseCode = vestaResponseCode;
	}

	public String getVestaResponseText() {
		return vestaResponseText;
	}

	public void setVestaResponseText(String vestaResponseText) {
		this.vestaResponseText = vestaResponseText;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public CreditCardBean getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardBean creditCard) {
		this.creditCard = creditCard;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	@Override
	public String toString() {
		return "PaymentBean [accountNumber=" + accountNumber
				+ ", billingOrderId=" + billingOrderId
				+ ", billingTransactionId="
				+ Arrays.toString(billingTransactionId)
				+ ", contactPhoneNumber=" + contactPhoneNumber + ", mdn=" + mdn
				+ ", approvalTransactionId=" + approvalTransactionId
				+ ", posSaleId=" + posSaleId + ", transactionId="
				+ transactionId + ", vestaResponseCode=" + vestaResponseCode
				+ ", vestaResponseText=" + vestaResponseText
				+ ", paymentMethod=" + paymentMethod + ", creditCard="
				+ creditCard + ", referenceId=" + referenceId + ", orderId="
				+ orderId + ", resultCode=" + resultCode
				+ ", resultDescription=" + resultDescription + "]";
	}
}
