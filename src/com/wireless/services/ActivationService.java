package com.wireless.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.webflow.context.ExternalContext;

import com.wireless.bean.BillingQuoteBean;
import com.wireless.bean.RateCenterBean;
import com.wireless.domain.Account;
import com.wireless.domain.Address;
import com.wireless.domain.Cart;
import com.wireless.domain.Contract;
import com.wireless.domain.Subscriber;
import com.wireless.domain.UserBean;
import com.wireless.tibco.CreateActivationQuote;
import com.wireless.utilities.Utility;

@Service
public class ActivationService 
{
	public Cart initializeCart() {
		Cart cart = new Cart();
			
		cart.setAccount(new Account());
		
		return cart;
	}
	
	public Subscriber[] setSubscribersOfferingCodes(Subscriber[] subscribers, int subscriberIndex, HttpServletRequest request)
	{
		Subscriber subscriber = subscribers[subscriberIndex];
		
		String ratePlanId = request.getParameter("ratePlanOptions");
		String featureIds = "feature_" + ratePlanId;
		
		String[] paramValues = request.getParameterValues(featureIds);
		List<String> features = new ArrayList<String>();
		features.add(ratePlanId);
		
		for(String value: paramValues)
		{
			features.add(value);
		}
		
		String[] offeringCodes = new String[features.size()];
		features.toArray(offeringCodes);
		
		subscriber.setOfferingCodes(offeringCodes);
		subscribers[subscriberIndex] = subscriber;
		
		return subscribers; 
	}
	
	public Cart createQuote(Cart cart) throws Exception
	{
		Account account = cart.getAccount();
		
		if(account.getEffectiveDate() == null) {
			account.setEffectiveDate(new Date());
		}
		
		String transactionType = cart.getTransactionType();

		CreateActivationQuote quote = new CreateActivationQuote(transactionType, account);
		
		HashMap< String, Object> response = new HashMap<String, Object>();
		response = quote.invokeService();
		
		BillingQuoteBean billingQuote = (BillingQuoteBean) response.get("espResponseObject");
		
		account.setAccountNumber(billingQuote.getBillingAccountNumber());
		
		
		cart.setBillingQuote(billingQuote);
		
		return cart;
	}
	
	public String getMarketIdByAddress(Address address) {
		String marketId = Utility.getNetworkCoverage(address).get("marketId");

		return marketId;
	}
	
	public RateCenterBean[] getRateCenterInfo(String marketId) {
		RateCenterBean[] rcBeans = Utility.getRateCenterInfo(marketId);
		
		return rcBeans;
	}
	
	public Cart loadLosInfoToCart(UserBean user, Cart cart) {
		//TODO: customerType should be set dynamically
		cart.getAccount().getCustomer().setCustomerType('S');
		
		String accountType;
		switch(cart.getAccount().getProductCode())
		{
			case 1:
				accountType = "P";
				break;
				
			case 4:
				accountType = "O";
				break;
				
			default:
				accountType = "P";
		}
		
		cart.getAccount().setAccountType(accountType);
		
		Contract contract = new Contract();
		contract.setLocationId(user.getLocationId());
		contract.setSalesRepresentative(user.getUserName());
		contract.setSalesChannel(user.getChannelType());
		
		//TODO: # of subscribers have to be set dynamically
		cart.getAccount().getSubscriber(0).setContract(contract);
		
		//TODO: type of transaction has to be set dynamically
		cart.setTransactionType(Cart.TRANSACTION_TYPE_NEW);
		
		return cart;
	}
	
	public Subscriber[] setLosOfferingCodes(Subscriber[] subscribers, int subscriberIndex, ExternalContext context)
	{
		Subscriber subscriber = subscribers[subscriberIndex];
		
		String ratePlanId = context.getRequestParameterMap().get("ratePlanOptions");
		String featureIds = "feature_" + ratePlanId;
		
		String[] paramValues = context.getRequestParameterMap().getArray(featureIds);
		List<String> features = new ArrayList<String>();
		features.add(ratePlanId);
		
		for(String value: paramValues)
		{
			features.add(value);
		}
		
		String[] offeringCodes = new String[features.size()];
		features.toArray(offeringCodes);
		
		subscriber.setOfferingCodes(offeringCodes);
		subscribers[subscriberIndex] = subscriber;
		
		return subscribers; 
	}

	public void setDealerInfo(Cart cart, UserBean user) {
		BillingQuoteBean billingQuoteBean = cart.getBillingQuote();
		
		billingQuoteBean.setLocationId(user.getLocationId());
		billingQuoteBean.setSalesRepresentative(user.getUserName());
		billingQuoteBean.setSalesChannel(user.getChannelType());
	}
}
