package com.wireless.domain;

import java.io.Serializable;

import com.wireless.bean.BillingQuoteBean;
import com.wireless.bean.PaymentBean;

public class Cart implements Serializable 
{
	private static final long serialVersionUID = -2469105690251103074L;
	
	public static final String TRANSACTION_TYPE_NEW = "ACT";
	
	private Account account;
	private String transactionType; 
	private BillingQuoteBean billingQuote;
	private PaymentBean payment;
	
	public Cart() {
		this.account = new Account();
		this.payment = new PaymentBean();
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BillingQuoteBean getBillingQuote() {
		return billingQuote;
	}

	public void setBillingQuote(BillingQuoteBean billingQuote) {
		this.billingQuote = billingQuote;
	}

	public PaymentBean getPayment() {
		return payment;
	}

	public void setPayment(PaymentBean payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Cart [account=" + account + ", transactionType="
				+ transactionType + ", billingQuote=" + billingQuote
				+ ", payment=" + payment + "]";
	}
}
