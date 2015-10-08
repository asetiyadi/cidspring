package com.wireless.bean;

import java.math.BigDecimal;

public class PostPaymentReferenceBean {

	private BigDecimal paymentAmount;
	private String paymentReferenceId;
	private ReversedTransactionBean reversedTransaction;
	
	public PostPaymentReferenceBean()	{}

	/**
	 * @return the paymentAmount
	 */
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount the paymentAmount to set
	 */
	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * @return the paymentReferenceId
	 */
	public String getPaymentReferenceId() {
		return paymentReferenceId;
	}

	/**
	 * @param paymentReferenceId the paymentReferenceId to set
	 */
	public void setPaymentReferenceId(String paymentReferenceId) {
		this.paymentReferenceId = paymentReferenceId;
	}

	/**
	 * @return the reversedTransaction
	 */
	public ReversedTransactionBean getReversedTransaction() {
		return reversedTransaction;
	}

	/**
	 * @param reversedTransaction the reversedTransaction to set
	 */
	public void setReversedTransaction(ReversedTransactionBean reversedTransaction) {
		this.reversedTransaction = reversedTransaction;
	}
}
