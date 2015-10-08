/**
 * 
 */
package com.wireless.tibco;

import org.apache.axis.message.SOAPHeaderElement;

import com.cricket.esp.ESP.Namespaces.Container.Public.UpdateBillingQuoteStatusRequest_xsd.UpdateBillingQuoteStatusRequestInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.UpdateBillingQuoteStatusRequest_xsd.UpdateBillingQuoteStatusRequestInfoPaymentInformation;
import com.cricket.esp.ESP.Namespaces.Container.Public.UpdateBillingQuoteStatusResponse_xsd.UpdateBillingQuoteStatusResponseInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.UpdateBillingQuoteStatusResponse_xsd.UpdateBillingQuoteStatusResponseInfoOrderInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingQuoteStatusInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BucketDetailsInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BucketTypeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.CreditCardTypeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.DealerCommissionInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.GenericRecordLocatorInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.GenericRecordLocatorInfoAccountSelector;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.GenericRecordLocatorInfoAccountSelectorCustomerInformation;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.PostRegularPaymentInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.TenderTypeInfo;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CricketESPHTTPServicesLocator;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.UpdateBillingQuoteStatusStub;
import com.wireless.bean.BillingQuoteBean;
import com.wireless.bean.PaymentBean;
import com.wireless.bean.ResponseBean;
import com.wireless.domain.Cart;
import com.wireless.tibco.parser.ParseUpdateBillingQuote;
import com.wireless.utilities.ESPHelper;

public class UpdateBillingQuoteStatus	{
	
	private ESPHelper espHelper = new ESPHelper();
	private UpdateBillingQuoteStatusStub stub;
	private BillingQuoteBean billingQuoteBean;
	private PaymentBean paymentBean;
	private UpdateBillingQuoteStatusRequestInfo request;
	private Cart cart;
	
	public UpdateBillingQuoteStatus( Cart cart )		{
		this.cart = cart;
		this.billingQuoteBean = this.cart.getBillingQuote();
		this.paymentBean = this.cart.getPayment();
	}

	public String getServiceName() {
		return "UpdateBillingQuoteStatus";
	}

	public ResponseBean invokeService()	{// throws WebserviceException{
		ResponseBean responseBean = new ResponseBean();
		
		/***
		 * Set the request
		 */
		createRequest();
		
		try	{
			/***
			 * Set the stub
			 */
			createStub();
			
			/***
			 * Invoke web service and capture the response
			 */
			UpdateBillingQuoteStatusResponseInfo response = this.stub.updateBillingQuoteStatus( this.request );
			UpdateBillingQuoteStatusResponseInfoOrderInfo espResponseObject = response.getOrderInfo();

			if( response != null && Integer.parseInt( response.getResponse()[0].getCode() ) == 0 )	{
				responseBean.setObject((PaymentBean) ParseUpdateBillingQuote.parseUpdateBillingQuoteStatus(espResponseObject));
				responseBean.setCode(Integer.parseInt(response.getResponse()[0].getCode()));
				responseBean.setDescription(response.getResponse()[0].getDescription());
				responseBean.setClassName("PaymentBean");
			}
		}
		catch( Exception e )	{
			//throw new WebserviceException(e, getServiceName() + "." + "invokeService()");
			e.printStackTrace();
		}
		
		return responseBean;
	}

	public void createRequest() {

		this.request = new UpdateBillingQuoteStatusRequestInfo();
		
		this.request.setQuoteId(billingQuoteBean.getBillingQuoteId());
		
		if(this.cart.getTransactionType().equalsIgnoreCase(Cart.TRANSACTION_TYPE_NEW))
		{
			this.request.setQuoteStatus(BillingQuoteStatusInfo.X);
		}
		
		
		DealerCommissionInfo dealerCommissionInfo = new DealerCommissionInfo();
		//DealerInfo dealerInfo = new DealerInfo();
		//dealerInfo.setCode(billingQuoteBean.getDealerCode());
		
		//dealerCommissionInfo.setDealer(dealerInfo);
		//dealerCommissionInfo.setDrawerId(billingQuoteBean.getDrawerId());
		//dealerCommissionInfo.setTerminalId(billingQuoteBean.getTerminalId());
		dealerCommissionInfo.setLocationId(billingQuoteBean.getLocationId());
		dealerCommissionInfo.setSalesRepresentative(billingQuoteBean.getSalesRepresentative());
		dealerCommissionInfo.setSalesChannel(billingQuoteBean.getSalesChannel());
		
		this.request.setCommission(dealerCommissionInfo);
		
		
		UpdateBillingQuoteStatusRequestInfoPaymentInformation paymentInformation = new UpdateBillingQuoteStatusRequestInfoPaymentInformation();
		
		GenericRecordLocatorInfoAccountSelector accountSelector = new GenericRecordLocatorInfoAccountSelector();
		accountSelector.setBillingAccountNumber( this.billingQuoteBean.getBillingAccountNumber());
		GenericRecordLocatorInfoAccountSelectorCustomerInformation customerInfo = new GenericRecordLocatorInfoAccountSelectorCustomerInformation();
		customerInfo.setCustomerId(this.billingQuoteBean.getCustomerId());
		accountSelector.setCustomerInformation(customerInfo);
		
		GenericRecordLocatorInfo genericRecordLocator = new GenericRecordLocatorInfo();
		genericRecordLocator.setAccountSelector( accountSelector );
		
		paymentInformation.setGenericRecordLocator(genericRecordLocator);

		//String[] notes = {billingQuoteBean.getNotes()};
		//this.request.setNotes(notes);
		
		//AccountPayments
		PostRegularPaymentInfo[] arrAccountPayments = new PostRegularPaymentInfo[1];
		PostRegularPaymentInfo accountPayment = new PostRegularPaymentInfo();
		
		BucketDetailsInfo bucketDetailsInfo = new BucketDetailsInfo();
		bucketDetailsInfo.setBucketType(BucketTypeInfo.FLEX_DVI);
		accountPayment.setBucketDetails(bucketDetailsInfo);
		
		accountPayment.setPaymentAmount(this.billingQuoteBean.getAmountDueToday());
		accountPayment.setPaymentApprovalTransactionId(this.paymentBean.getApprovalTransactionId());
		accountPayment.setTenderType(TenderTypeInfo.fromString(this.paymentBean.getPaymentMethod()));
		accountPayment.setCreditCardType(CreditCardTypeInfo.fromString(this.paymentBean.getCreditCard().getCardType()));
		
		arrAccountPayments[0] = accountPayment;
		paymentInformation.setAccountPayments(arrAccountPayments);
		
		
		this.request.setPaymentInformation(paymentInformation);
	}

	public void createStub() throws Exception {
		try		{
			SOAPHeaderElement header = espHelper.createMessageHeader();
			CricketESPHTTPServicesLocator espService = espHelper.setService( getServiceName() );
			
			this.stub = new UpdateBillingQuoteStatusStub( espHelper.getEndPoint( getServiceName() ), espService);
			this.stub.setHeader( header );
		}
		catch ( Exception e )	{
			e.printStackTrace();
			throw new Exception( "Error invoking createStub() method on " + getServiceName() + ": " + e.getMessage() );
		}
	}
}
