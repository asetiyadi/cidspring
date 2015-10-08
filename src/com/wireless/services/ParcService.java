package com.wireless.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wireless.bean.OffersBean;
import com.wireless.bean.ProductBean;
import com.wireless.domain.Account;
import com.wireless.domain.Cart;
import com.wireless.domain.Subscriber;
import com.wireless.tibco.InquireOffers;
import com.wireless.tibco.InquireProducts;

@Service
public class ParcService 
{
	public List<ProductBean> getProducts(Account account, String channelType, String type)
	{
		String salesChannel = channelType;							//hardcoding for now
		String customerType = String.valueOf(account.getCustomer().getCustomerType());
		String marketId = account.getMarketId();
		String transactionType = Cart.TRANSACTION_TYPE_NEW;
		String deviceType = type;
		String[] accountTypes = {"P","O"};
		
		InquireProducts inquireProducts = new InquireProducts(salesChannel, customerType, marketId, transactionType, deviceType, accountTypes);
		
		HashMap<String, Object> response = inquireProducts.invokeService();
		
		@SuppressWarnings("unchecked")
		List<ProductBean> products = (List<ProductBean>) response.get("espResponseObject");

		return products;
	}
	
	public OffersBean[] getOffers(Account account, int subscriberIndex, String channelType) throws Exception
	{
		Subscriber subscriber = account.getSubscriber(subscriberIndex);
		
		String salesChannel = channelType;							
		String accountType = account.getAccountType();
		String customerType = String.valueOf(account.getCustomer().getCustomerType());
		String marketId = account.getMarketId();
		String transactionType = Cart.TRANSACTION_TYPE_NEW;
		String deviceId = subscriber.getDevice().getDeviceId();
		String phoneCode = subscriber.getDevice().getDeviceCode();
		String phoneType = subscriber.getDevice().getDeviceType();
		boolean isCricketPhone = subscriber.getDevice().isCricketPhone();
		boolean hasEsnHistory = subscriber.getDevice().isHasEsnHistory();
		boolean cpe = subscriber.getDevice().isCpe();
		String productCode = String.valueOf(account.getProductCode());
		
		InquireOffers inquireOffers = new InquireOffers(salesChannel,accountType,customerType,marketId,transactionType,deviceId,phoneCode,phoneType,isCricketPhone,hasEsnHistory,cpe,productCode);
		HashMap<String, Object> response = inquireOffers.invokeService();
		
		OffersBean[] offers = (OffersBean[]) response.get("espResponseObject");
		
		return offers;
	}
}
