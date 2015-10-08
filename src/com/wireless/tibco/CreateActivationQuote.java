package com.wireless.tibco;

import java.util.HashMap;

import org.apache.axis.message.SOAPHeaderElement;
import org.apache.axis.types.PositiveInteger;

import com.cricket.esp.ESP.Namespaces.Container.Public.CreateActivationQuoteRequest_xsd.CreateActivationQuoteRequestInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.CreateActivationQuoteRequest_xsd.CreateActivationQuoteRequestInfoAccount;
import com.cricket.esp.ESP.Namespaces.Container.Public.CreateActivationQuoteRequest_xsd.CreateActivationQuoteRequestInfoAccountSubscriber;
import com.cricket.esp.ESP.Namespaces.Container.Public.CreateActivationQuoteRequest_xsd.CreateActivationQuoteRequestInfoAccountSubscriberContactInformation;
import com.cricket.esp.ESP.Namespaces.Container.Public.CreateActivationQuoteRequest_xsd.CreateActivationQuoteRequestInfoCustomer;
import com.cricket.esp.ESP.Namespaces.Container.Public.CreateActivationQuoteRequest_xsd.CreateActivationQuoteRequestInfoCustomerIdentity;
import com.cricket.esp.ESP.Namespaces.Container.Public.CreateActivationQuoteRequest_xsd.CreateActivationQuoteRequestInfoOrderInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.CreateActivationQuoteResponse_xsd.CreateActivationQuoteResponseInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AccountTypeIndicatorInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.ActionInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressStateInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressZipInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingMarketInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingPreferencesInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingPreferencesInfoElectronicBillReporting;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingQuoteResponseInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BirthInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.ContractTermInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.CustomerTypeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.DealerCommissionInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.DeviceInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.EffectiveDatesInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.LanguagePreferenceInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.ManufacturerInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.MobileDeviceIdentifierInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.NameInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.SolicitationContactPreferenceInfo;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CreateActivationQuoteStub;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CricketESPHTTPServicesLocator;
import com.wireless.bean.BillingQuoteBean;
import com.wireless.domain.Account;
import com.wireless.domain.Customer;
import com.wireless.domain.Subscriber;
import com.wireless.tibco.parser.ParseCreateActivationQuote;
import com.wireless.utilities.ESPHelper;

//This typically equal the ESP service name, ie ESP InquireAccount - className = "InquireAccount"
public class CreateActivationQuote implements IService {
	
	private ESPHelper espHelper = new ESPHelper();
	private CreateActivationQuoteStub stub;
	private CreateActivationQuoteRequestInfo request;
	
	private String transactionType;
	private Customer customer;
	private Account account;
	
	public CreateActivationQuote( String transactionType,
								 Account account )		{
	
		this.transactionType = transactionType;
		this.customer = account.getCustomer();
		this.account = account;
	}

	public String getServiceName() {
		return "CreateActivationQuote";
	}

	public HashMap< String, Object> invokeService() throws Exception  {
		HashMap<String, Object> espResponse = new HashMap< String, Object >();
		BillingQuoteBean billingQuoteBean = null;
		
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
			CreateActivationQuoteResponseInfo response = this.stub.createActivationQuote( this.request );
			BillingQuoteResponseInfo espResponseObj = response.getActivationQuoteInfo();
			
			espResponse.put( "isSuccessful", response.getResponse()[0].getDescription() );
			
			if( Integer.parseInt( response.getResponse()[0].getCode() ) == 0 && espResponseObj != null )	{
				billingQuoteBean = ParseCreateActivationQuote.parseCreateActivationQuote( espResponseObj );
				espResponse.put( "espResponseObject", billingQuoteBean );
			}
		}
		catch( Exception e )	{
			e.printStackTrace();
			throw new Exception( "Error invoking " + getServiceName() + ": " + e.getMessage() );
		}
		
		return espResponse;
	}

	public void createRequest() {
		request = new CreateActivationQuoteRequestInfo();
		
		/**
		 * ORDER INFO
		 */
		CreateActivationQuoteRequestInfoOrderInfo orderInfo = new CreateActivationQuoteRequestInfoOrderInfo();
		orderInfo.setTransactionType( this.transactionType );
	
		request.setOrderInfo(orderInfo);
		
		
		/**
		 * CUSTOMER
		 */
		CreateActivationQuoteRequestInfoCustomer customer = new CreateActivationQuoteRequestInfoCustomer();
		customer.setCustomerType( CustomerTypeInfo.fromValue( Character.toString(this.customer.getCustomerType()) ) );
		
		//Name
		NameInfo name = new NameInfo();
		name.setFirstName( this.customer.getFirstName() );
		name.setLastName( this.customer.getLastName() );
		customer.setName( name );
		
		//Identity
		CreateActivationQuoteRequestInfoCustomerIdentity identity = new CreateActivationQuoteRequestInfoCustomerIdentity();
		BirthInfo birth = new BirthInfo();
		birth.setDateOfBirth(this.customer.getDob());
		identity.setBirth(birth);
		identity.setSocialSecurityNumber(this.customer.getSsn());
		customer.setIdentity(identity);
		
		request.setCustomer(customer);
		
		
		/**
		 * ACCOUNT
		 */
		CreateActivationQuoteRequestInfoAccount[] arrAccounts = new CreateActivationQuoteRequestInfoAccount[ 1 ];
		
		CreateActivationQuoteRequestInfoAccount account = new CreateActivationQuoteRequestInfoAccount();
		
		//AccountType
		account.setAccountType( AccountTypeIndicatorInfo.fromValue( this.account.getAccountType() ));
		
		//EffectiveDates
		EffectiveDatesInfo effectiveDates = new EffectiveDatesInfo();
		effectiveDates.setEffectiveDate( this.account.getEffectiveDate());
		account.setEffectiveDates( effectiveDates );
		
		//BillingMarket
		BillingMarketInfo billingMarket = new BillingMarketInfo();
		billingMarket.setMarketId( this.account.getMarketId() );
		billingMarket.setRateCenterId( new PositiveInteger(String.valueOf(this.account.getRateCenterId())));
		billingMarket.setJointVentureCode( String.valueOf(this.account.getJointVentureCode()));
		account.setBillingMarket( billingMarket );
		
		//MarketAddress = Customer Address
		AddressInfo marketAddress = new AddressInfo();
		marketAddress.setAddressLine1( this.customer.getAddress().getAddress1());
		marketAddress.setCity( this.customer.getAddress().getCity() );
		marketAddress.setState( AddressStateInfo.fromValue( this.customer.getAddress().getState() ));
		
		AddressZipInfo zip = new AddressZipInfo();
		zip.setZipCode( this.customer.getAddress().getZip() );
		zip.setZipCodeExtension( this.customer.getAddress().getZipExtension() );
		marketAddress.setZip( zip );
		
		account.setMarketAddress( marketAddress );
		
		//BillingPreferences
		BillingPreferencesInfo billingPreferences = new BillingPreferencesInfo();
		
		BillingPreferencesInfoElectronicBillReporting electronicBillReporting = new BillingPreferencesInfoElectronicBillReporting();
		electronicBillReporting.setAction( ActionInfo.fromValue(Character.toString(this.account.getElectronicBillReporting())));
		billingPreferences.setElectronicBillReporting( electronicBillReporting );
		//billingPreferences.setBillReminderFlag( this.account.getBillingInfo().getBillReminderFlag() );
		billingPreferences.setLanguage( LanguagePreferenceInfo.fromValue( Character.toString(this.account.getLanguage() )));
		account.setBillingPreferences( billingPreferences );
		
		//SolicitationContactPreference
		account.setSolicitationContactPreference( SolicitationContactPreferenceInfo.ANY );
		
		//Subscriber
		CreateActivationQuoteRequestInfoAccountSubscriber[] arrSubscribers = new CreateActivationQuoteRequestInfoAccountSubscriber[ this.account.getSubscribers().length ];
		Subscriber[] subscriberBeans = this.account.getSubscribers();
		
		for( int x=0; x<subscriberBeans.length; x++ )		{
			CreateActivationQuoteRequestInfoAccountSubscriber subscriber = new  CreateActivationQuoteRequestInfoAccountSubscriber();
			Subscriber temp = subscriberBeans[ x ];
			
			//BillingResponsibility
			subscriber.setBillingResponsibility( temp.isBillingResponsibleParty() );
			
			//Device
			DeviceInfo device = new DeviceInfo();
				//EquipmentIdentifier
				MobileDeviceIdentifierInfo equipmentIdentifier = new MobileDeviceIdentifierInfo();
				if(temp.getDevice().getDeviceId().length() == 11 )	{
					equipmentIdentifier.setEsn( temp.getDevice().getDeviceId());
				}
				else if(temp.getDevice().getDeviceId().length() == 18 )	{
					equipmentIdentifier.setMeid( temp.getDevice().getDeviceId());
				}
				device.setEquipmentIdentifier( equipmentIdentifier );
				
				//Manufacturer
				ManufacturerInfo manufacturer = new ManufacturerInfo();
				manufacturer.setPhoneCode( temp.getDevice().getDeviceCode());
				device.setManufacturer( manufacturer );
				
				//IsCricketPhone
				device.setIsCricketPhone( temp.getDevice().isCricketPhone());
				
				//HasEsnHistory
				device.setHasEsnHistory( temp.getDevice().isHasEsnHistory());
				
				//CPE
				device.setCustomerProvidedEquipment( temp.getDevice().isCpe());
			
			subscriber.setDevice( device );
			
			//EffectiveDate
			EffectiveDatesInfo effectiveDate = new EffectiveDatesInfo();
			effectiveDate.setEffectiveDate( this.account.getEffectiveDate());
			subscriber.setEffectiveDate( effectiveDate );
			
			//Contract
			ContractTermInfo contract = new ContractTermInfo();
			contract.setTerm(temp.getContract().getTerm() );
			
			/*
			 * HARD CODING FOR NOW
			 */
			DealerCommissionInfo commission = new DealerCommissionInfo();
			commission.setLocationId("7197");
			commission.setSalesRepresentative("csrint");
			commission.setSalesChannel("CID-CSR");
			contract.setCommission( commission );
			
			subscriber.setContract( contract );
			
			//ContactInformation
			CreateActivationQuoteRequestInfoAccountSubscriberContactInformation contact = new CreateActivationQuoteRequestInfoAccountSubscriberContactInformation();
			contact.setName( name );
			
			AddressInfo contactAddress = new AddressInfo();
			contactAddress.setAddressLine1( this.customer.getAddress().getAddress1() );
			//contactAddress.setAddressLine2( this.customer.getAddress().getAddress2() );
			contactAddress.setCity( this.customer.getAddress().getCity() );
			contactAddress.setState( AddressStateInfo.fromValue( this.customer.getAddress().getState() ));
			
			AddressZipInfo contactZip = new AddressZipInfo();
			contactZip.setZipCode( this.customer.getAddress().getZip() );
			contactZip.setZipCodeExtension( this.customer.getAddress().getZipExtension());
			contactAddress.setZip( contactZip );
			
			contact.setAddress( contactAddress );
			subscriber.setContactInformation( contact );
			
			//CricketOfferingCodes
			subscriber.setCricketOfferingCodes( temp.getOfferingCodes() );
			
			arrSubscribers[ x ] = subscriber;
		}
		
		account.setSubscriber( arrSubscribers );
		
		arrAccounts[0] = account;
		request.setAccount( arrAccounts );
	}

	public void createStub() throws Exception {
		try		{
			SOAPHeaderElement header = espHelper.createMessageHeader();
			CricketESPHTTPServicesLocator espService = espHelper.setService( getServiceName() );
			
			this.stub = new CreateActivationQuoteStub( espHelper.getEndPoint( getServiceName() ), espService);
			this.stub.setHeader( header );
		}
		catch ( Exception e )	{
			throw new Exception( "Error invoking createStub() method on " + getServiceName() + ": " + e.getMessage() );
		}
	}
}
