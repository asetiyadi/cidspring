package com.wireless.bean;

import java.math.BigDecimal;

public class ReversedTransactionBean {

	private String creditCardType;
	private BucketDetailBean newBucketDetails;
	private String[] notes;
	private String originalPaymentReferenceId;
	private String prePaidPin;
	private String reasonText;
	private BigDecimal reversalAmount;
	private String reversalTransactionType;
	private String tenderType;
	
	public ReversedTransactionBean()	{}

	/**
	 * @return the creditCardType
	 */
	public String getCreditCardType() {
		return creditCardType;
	}

	/**
	 * @param creditCardType the creditCardType to set
	 */
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	/**
	 * @return the newBucketDetails
	 */
	public BucketDetailBean getNewBucketDetails() {
		return newBucketDetails;
	}

	/**
	 * @param newBucketDetails the newBucketDetails to set
	 */
	public void setNewBucketDetails(BucketDetailBean newBucketDetails) {
		this.newBucketDetails = newBucketDetails;
	}

	/**
	 * @return the notes
	 */
	public String[] getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String[] notes) {
		this.notes = notes;
	}

	/**
	 * @return the originalPaymentReferenceId
	 */
	public String getOriginalPaymentReferenceId() {
		return originalPaymentReferenceId;
	}

	/**
	 * @param originalPaymentReferenceId the originalPaymentReferenceId to set
	 */
	public void setOriginalPaymentReferenceId(String originalPaymentReferenceId) {
		this.originalPaymentReferenceId = originalPaymentReferenceId;
	}

	/**
	 * @return the prePaidPin
	 */
	public String getPrePaidPin() {
		return prePaidPin;
	}

	/**
	 * @param prePaidPin the prePaidPin to set
	 */
	public void setPrePaidPin(String prePaidPin) {
		this.prePaidPin = prePaidPin;
	}

	/**
	 * @return the reasonText
	 */
	public String getReasonText() {
		return reasonText;
	}

	/**
	 * @param reasonText the reasonText to set
	 */
	public void setReasonText(String reasonText) {
		this.reasonText = reasonText;
	}

	/**
	 * @return the reversalAmount
	 */
	public BigDecimal getReversalAmount() {
		return reversalAmount;
	}

	/**
	 * @param reversalAmount the reversalAmount to set
	 */
	public void setReversalAmount(BigDecimal reversalAmount) {
		this.reversalAmount = reversalAmount;
	}

	/**
	 * @return the reversalTransactionType
	 */
	public String getReversalTransactionType() {
		return reversalTransactionType;
	}

	/**
	 * @param reversalTransactionType the reversalTransactionType to set
	 */
	public void setReversalTransactionType(String reversalTransactionType) {
		this.reversalTransactionType = reversalTransactionType;
	}

	/**
	 * @return the tenderType
	 */
	public String getTenderType() {
		return tenderType;
	}

	/**
	 * @param tenderType the tenderType to set
	 */
	public void setTenderType(String tenderType) {
		this.tenderType = tenderType;
	}
}
