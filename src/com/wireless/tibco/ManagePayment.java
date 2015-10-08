package com.wireless.tibco;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

import org.apache.axis.message.SOAPHeaderElement;

import com.cricket.esp.ESP.Namespaces.Container.Public.ManagePaymentRequest_xsd.ManagePaymentRequestInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.ManagePaymentRequest_xsd.ManagePaymentRequestInfoCompletePaymentInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.ManagePaymentRequest_xsd.ManagePaymentRequestInfoNewPaymentInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.ManagePaymentResponse_xsd.ManagePaymentResponseInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.ManagePaymentResponse_xsd.ManagePaymentResponseInfoPaymentManagementStatus;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressStateInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressZipInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.ChargeCardInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.CreditCardExpirationDateInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.CreditCardTypeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.PaymentChannelCodeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.PaymentServiceActionInfo;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CricketESPHTTPServicesLocator;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.ManagePaymentStub;
import com.wireless.bean.BillingQuoteBean;
import com.wireless.bean.CreditCardBean;
import com.wireless.bean.HotBillChargesBean;
import com.wireless.bean.PaymentBean;
import com.wireless.bean.ResponseBean;
import com.wireless.domain.Cart;
import com.wireless.tibco.parser.ParseManagePayment;
import com.wireless.utilities.ESPHelper;

public class ManagePayment 
{
	public static final String PAYMENT_TRANSACTION_ACTION_SUBMIT = "SubmitPayment";
	public static final String PAYMENT_TRANSACTION_ACTION_COMPLETE = "CompletePayment";
	
	private ESPHelper espHelper = new ESPHelper();
	private ManagePaymentStub stub;
	private ManagePaymentRequestInfo request;
	
	private String billingAccountNumber;
	private String mdn;
	private String channelCodeInfo;
	private String marketId;
	private int jointVentureCode;
	private String paymentMethod;
	private CreditCardBean creditCard;
	private BigDecimal amount;
	private String billingQuoteId;
	private BillingQuoteBean billingQuote; 
	private HotBillChargesBean[] hotBillCharges;
	private String paymentTransactionAction;
	private Cart cart;
	
	/*public ManagePayment(
			String billingAccountNumber, 
			String mdn, 
			String channelCodeInfo, 
			String marketId, 
			int jointVentureCode, 
			String paymentMethod, 
			CreditCardBean creditCard,
			BigDecimal amount,
			String billingQuoteId)*/
	
	public ManagePayment(Cart cart, String paymentTransactionAction)
	{
		this.cart = cart;
		this.billingQuote = this.cart.getBillingQuote();
		this.hotBillCharges = this.billingQuote.getHotBillCharges();

		this.billingAccountNumber = billingQuote.getBillingAccountNumber();
		this.mdn = hotBillCharges[0].getSubscriberQuoteCharges()[0].getMdn();
		this.channelCodeInfo = "2";
		this.marketId = cart.getAccount().getMarketId();
		this.jointVentureCode = cart.getAccount().getJointVentureCode();
		this.paymentMethod = cart.getPayment().getPaymentMethod();
		this.creditCard = cart.getPayment().getCreditCard();
		this.amount = billingQuote.getAmountDueToday();
		this.billingQuoteId = billingQuote.getBillingQuoteId();
		this.paymentTransactionAction = paymentTransactionAction;
	}

	public String getServiceName() 
	{
		return "ManagePayment";
	}

	public ResponseBean invokeService() 
	{
		//HashMap<String, Object> espResponse = new HashMap<String, Object>();
		ResponseBean responseBean = new ResponseBean();
		
		
		/***
		 * Set the request
		 */
		createRequest();
		
		try	
		{
			/***
			 * Set the stub
			 */
			createStub();
			
			/***
			 * Invoke web service and capture the response
			 */
			ManagePaymentResponseInfo response = this.stub.managePayment(this.request);
			ManagePaymentResponseInfoPaymentManagementStatus espResponseObj = response.getPaymentManagementStatus();
			
			/*if("SUCCESS".equalsIgnoreCase(response.getResponse().getDescription()))
			{
				espResponse.put("isSuccessful", true);
			}*/		
			
			if(Integer.parseInt(response.getResponse().getCode()) == 0 && espResponseObj != null)	
			{
				responseBean.setObject((PaymentBean) ParseManagePayment.parseManagePayment(espResponseObj));
				responseBean.setCode(Integer.parseInt(response.getResponse().getCode()));
				responseBean.setDescription(response.getResponse().getDescription());
				responseBean.setClassName("PaymentBean");
			}
		}
		catch(Exception e)	
		{
			//throw new WebserviceException(e, getServiceName() + "." + "invokeService()");
			e.printStackTrace();
		}
		
		return responseBean;
	}

	public void createRequest() 
	{
		this.request = new ManagePaymentRequestInfo();
		
		if(this.paymentTransactionAction.equalsIgnoreCase(ManagePayment.PAYMENT_TRANSACTION_ACTION_SUBMIT))
		{
			ManagePaymentRequestInfoNewPaymentInfo newPaymentInfo = new ManagePaymentRequestInfoNewPaymentInfo();
			newPaymentInfo.setBillingAccountNumber(this.billingAccountNumber);
			newPaymentInfo.setMdn(this.mdn);
			newPaymentInfo.setTransactionId(UUID.randomUUID().toString());
			newPaymentInfo.setChannelCode(PaymentChannelCodeInfo.fromString(this.channelCodeInfo));
			newPaymentInfo.setMarketCode(this.marketId);
			newPaymentInfo.setJointVentureCode(String.valueOf(jointVentureCode));
			newPaymentInfo.setSettleForLessThanAuthorized(false);
			
			if(this.paymentMethod.equalsIgnoreCase(PaymentBean.PAYMENT_TENDER_TYPE_CREDIT))
			{
				ChargeCardInfo chargeCard = new ChargeCardInfo();
				chargeCard.setChargeCardType(CreditCardTypeInfo.fromString(this.creditCard.getCardType()));
				chargeCard.setChargeCardToken(this.creditCard.getCardToken());
				
				CreditCardExpirationDateInfo chargeCardExpirationDate = new CreditCardExpirationDateInfo();
				chargeCardExpirationDate.setExpirationMonth(this.creditCard.getExpirationMonth());
				chargeCardExpirationDate.setExpirationYear(this.creditCard.getExpirationYear());
							
				chargeCard.setChargeCardExpirationDate(chargeCardExpirationDate);
				chargeCard.setChargeCardCustomerName(this.creditCard.getFirstName() + " " + this.creditCard.getLastName());
				
				AddressInfo chargeCardBillingAddress = new AddressInfo();
				chargeCardBillingAddress.setAddressLine1(this.creditCard.getAddress().getAddress1());
				chargeCardBillingAddress.setCity(this.creditCard.getAddress().getCity());
				chargeCardBillingAddress.setState(AddressStateInfo.fromString(this.creditCard.getAddress().getState()));
				
				AddressZipInfo zip = new AddressZipInfo();
				zip.setZipCode(this.creditCard.getAddress().getZip());
				chargeCardBillingAddress.setZip(zip);
							
				chargeCard.setChargeCardBillingAddress(chargeCardBillingAddress);
				chargeCard.setIsDebitCard(this.creditCard.isDebit());
				chargeCard.setCVN(this.creditCard.getCvn());
				
				newPaymentInfo.setChargeCard(chargeCard);
				
				this.request.setAction(PaymentServiceActionInfo.CREATE_ORDER);
			}

			this.request.setNewPaymentInfo(newPaymentInfo);
			this.request.setAmount(this.amount);
			this.request.setBillingQuoteId(this.billingQuoteId);
		}
		
		else if(this.paymentTransactionAction.equalsIgnoreCase(ManagePayment.PAYMENT_TRANSACTION_ACTION_COMPLETE))
		{
			ManagePaymentRequestInfoCompletePaymentInfo completePaymentInfo = new ManagePaymentRequestInfoCompletePaymentInfo();
			
			completePaymentInfo.setOrderId(new BigInteger(this.cart.getPayment().getApprovalTransactionId()));
			completePaymentInfo.setIsFulfillmentSuccessful(true);
			completePaymentInfo.setBillingOrderId(this.cart.getPayment().getOrderId());
			
			String[] billingTransactionId = new String[1];
			billingTransactionId[0] = this.cart.getPayment().getTransactionId();
			completePaymentInfo.setBillingTransActionId(billingTransactionId);
			
			this.request.setCompletePaymentInfo(completePaymentInfo);
			this.request.setAmount(this.billingQuote.getAmountDueToday());
			this.request.setBillingQuoteId(this.billingQuoteId);
			this.request.setAction(PaymentServiceActionInfo.COMPLETE_ORDER);
		}
		
	}

	public void createStub() throws Exception 
	{
		try		
		{
			SOAPHeaderElement header = espHelper.createMessageHeader();
			CricketESPHTTPServicesLocator espService = espHelper.setService(getServiceName());
			
			this.stub = new ManagePaymentStub(espHelper.getEndPoint(getServiceName()), espService);
			this.stub.setHeader(header);
		}
		catch(Exception e)	
		{
			e.printStackTrace();
			throw new Exception("Error invoking createStub() method on " + getServiceName() + ": " + e.getMessage());
		}
	}
}
