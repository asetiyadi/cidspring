package com.wireless.tibco.parser;

import com.cricket.esp.ESP.Namespaces.Container.Public.UpdateBillingQuoteStatusResponse_xsd.UpdateBillingQuoteStatusResponseInfoOrderInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.UpdateBillingQuoteStatusResponse_xsd.UpdateBillingQuoteStatusResponseInfoOrderInfoPaymentResult;
import com.wireless.bean.PaymentBean;

public class ParseUpdateBillingQuote 
{
	public static PaymentBean parseUpdateBillingQuoteStatus(UpdateBillingQuoteStatusResponseInfoOrderInfo quoteStatusInfo)
	{
		//HashMap<String, String> payment = new HashMap<String, String>();
		PaymentBean payment = new PaymentBean();
		
		UpdateBillingQuoteStatusResponseInfoOrderInfoPaymentResult[] arrPaymentResult = quoteStatusInfo.getPaymentResult();
		UpdateBillingQuoteStatusResponseInfoOrderInfoPaymentResult paymentResult = arrPaymentResult[0];
		
		payment.setOrderId(quoteStatusInfo.getOrderId());
		payment.setResultCode(paymentResult.getStatus().getCode());
		payment.setResultDescription(paymentResult.getStatus().getDescription());
		payment.setReferenceId(paymentResult.getPaymentReference().getPaymentReferenceId());
		
		return payment;
	}
}
