package com.wireless.tibco.parser;

import com.cricket.esp.ESP.Namespaces.Container.Public.ManagePaymentResponse_xsd.ManagePaymentResponseInfoPaymentManagementStatus;
import com.wireless.bean.PaymentBean;

public class ParseManagePayment 
{
	public static PaymentBean parseManagePayment(ManagePaymentResponseInfoPaymentManagementStatus paymentInfo)
	{
		//HashMap<String, String> payment = new HashMap<String, String>();
		PaymentBean payment = new PaymentBean();
		
		
		payment.setAccountNumber(paymentInfo.getAccountNumber());
		payment.setBillingOrderId(paymentInfo.getBillingOrderId());
		payment.setBillingTransactionId(paymentInfo.getBillingTransactionId());
		payment.setContactPhoneNumber(paymentInfo.getContactPhoneNumber());
		payment.setMdn(paymentInfo.getMdn());
		payment.setApprovalTransactionId(paymentInfo.getOrderId().toString());
		payment.setPosSaleId(paymentInfo.getPOSSalesID());
		payment.setTransactionId(paymentInfo.getTransactionId());
		payment.setVestaResponseCode(paymentInfo.getVestaResponse().getResponseCode());
		payment.setVestaResponseText(paymentInfo.getVestaResponse().getResponseText());
		
		return payment;
	}
}
