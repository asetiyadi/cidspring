package com.wireless.services;

import org.springframework.stereotype.Service;

import com.wireless.bean.PaymentBean;
import com.wireless.bean.ResponseBean;
import com.wireless.domain.Account;
import com.wireless.domain.Cart;
import com.wireless.tibco.InquireAccount;
import com.wireless.tibco.UpdateBillingQuoteStatus;

@Service
public class AccountService 
{
	public Cart updateQuoteStatus(Cart cart)
	{
		UpdateBillingQuoteStatus updateBillingQuoteStatus = new UpdateBillingQuoteStatus(cart);
		
		ResponseBean response = updateBillingQuoteStatus.invokeService();
		
		if(response.getCode() == 0)
		{
			PaymentBean paymentBean = (PaymentBean) response.getObject();
			
			cart.getPayment().setOrderId(paymentBean.getOrderId());
			cart.getPayment().setResultCode(paymentBean.getResultCode());
			cart.getPayment().setResultDescription(paymentBean.getResultDescription());
			cart.getPayment().setReferenceId(paymentBean.getReferenceId());
		}
		
		return cart;
	}
	
	public Account getAccount(String accountNumber)
	{
		InquireAccount inquireAccount = new InquireAccount(accountNumber);
		Account account = null;
		
		ResponseBean response = inquireAccount.invokeService();
		
		if(response.getCode() == 0)
		{
			account = (Account) response.getObject();
		}
		
		return account;
	}
}
