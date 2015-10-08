package com.wireless.tibco;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.wireless.bean.CreditCardBean;
import com.wireless.bean.PaymentBean;
import com.wireless.bean.ResponseBean;
import com.wireless.domain.Address;
import com.wireless.domain.Cart;

public class ManagePaymentTest 
{
	ManagePayment managePayment;
	
	@Before
	public void setUp() throws Exception 
	{
		String billingAccountNumber = "90976431767";
		String mdn = "9704577005";
		String channelCodeInfo = "2";
		String marketId = "330";
		int jointVentureCode = 401;
		String paymentMethod = PaymentBean.PAYMENT_TENDER_TYPE_CREDIT;
		
		
		CreditCardBean creditCard = new CreditCardBean();
		creditCard.setCardType(CreditCardBean.CREDITCARD_CARDTYPE_VISA);
		creditCard.setCardToken("4111900000001692");
		creditCard.setExpirationMonth("11");
		creditCard.setExpirationYear("14");
		creditCard.setFirstName("Sapi");
		creditCard.setLastName("Ompong");
		
		Address address = new Address();
		address.setAddress1("14395 Erin Ct");
		address.setCity("Broomfield");
		address.setState("CO");
		address.setZip("80023");
		creditCard.setAddress(address);
		
		creditCard.setDebit(false);
		creditCard.setCvn("1111");
		
		BigDecimal amount = new BigDecimal("71.89");
		String billingQuoteId = "3801277";
		
		/*managePayment = new ManagePayment(
				billingAccountNumber, 
				mdn, 
				channelCodeInfo, 
				marketId, 
				jointVentureCode, 
				paymentMethod, 
				creditCard,
				amount,
				billingQuoteId);*/
		
		Cart cart = new Cart();
		cart.getPayment().setCreditCard(creditCard);
	}

	@Test
	public void testInvokeService() throws ClassNotFoundException {
		ResponseBean response = managePayment.invokeService();
		PaymentBean payment = (PaymentBean) response.getObject();
		
		System.out.println(response.toString());
		System.out.println(payment.toString());
	}
}
