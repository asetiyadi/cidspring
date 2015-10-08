package com.wireless.services;

import org.springframework.stereotype.Service;

import com.wireless.bean.PaymentBean;
import com.wireless.bean.ResponseBean;
import com.wireless.domain.Cart;
import com.wireless.tibco.ManagePayment;

@Service
public class PaymentService 
{
	public Cart submitPayment(Cart cart)
	{
		ManagePayment managePayment = new ManagePayment(cart, ManagePayment.PAYMENT_TRANSACTION_ACTION_SUBMIT);
		
		ResponseBean response = managePayment.invokeService();
		PaymentBean payment = (PaymentBean) response.getObject();
		
		cart.getPayment().setApprovalTransactionId(payment.getApprovalTransactionId());
		cart.getPayment().setVestaResponseCode(payment.getVestaResponseCode());
		cart.getPayment().setVestaResponseText(payment.getVestaResponseText());
		
		return cart;
	}
	
	public Cart completePayment(Cart cart)
	{
		ManagePayment managePayment = new ManagePayment(cart, ManagePayment.PAYMENT_TRANSACTION_ACTION_SUBMIT);
		
		ResponseBean response = managePayment.invokeService();
		
		if(response.getCode() == 0)
		{
			PaymentBean payment = (PaymentBean) response.getObject();
			
			cart.getPayment().setVestaResponseCode(payment.getVestaResponseCode());
			cart.getPayment().setVestaResponseText(payment.getVestaResponseText());
		}
		
		return cart;
	}
}
