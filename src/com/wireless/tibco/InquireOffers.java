package com.wireless.tibco;

import java.util.HashMap;

import org.apache.axis.message.SOAPHeaderElement;

import com.cricket.esp.ESP.Namespaces.Container.Public.InquireOffersRequest_xsd.InquireOffersRequestInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.InquireOffersResponse_xsd.InquireOffersResponseInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.InquireOffersResponse_xsd.InquireOffersResponseInfoInquireOffersResponse;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AccountTypeIndicatorInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.CustomerTypeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.DeviceInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.ManufacturerInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.MobileDeviceIdentifierInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.OfferSelectionCriteriaInfo;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CricketESPHTTPServicesLocator;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.InquireOffersStub;
import com.wireless.bean.OffersBean;
import com.wireless.tibco.parser.ParseInquireOffers;
import com.wireless.utilities.ESPHelper;

public class InquireOffers implements IService {
	
	private ESPHelper espHelper = new ESPHelper();
	private InquireOffersStub stub;
	private InquireOffersRequestInfo request;
	
	private String salesChannelName;
	private String accountType;
	private String customerType;
	private String marketId;
	private String transactionName;
	private String deviceId;
	private String phoneCode;
	private String phoneType;
	private boolean isCricketPhone;
	private boolean hasEsnHistory;
	private boolean customerProvidedEquipment;
	private String  productCode;
	
	public InquireOffers( String salesChannelName, 
						String accountType,
						String customerType,
						String marketId,
						String transactionName,
						String deviceId,
						String phoneCode,
						String phoneType,
						boolean isCricketPhone,
						boolean hasEsnHistory,
						boolean customerProvidedEquipment,
						String productCode )		{
		
		this.salesChannelName = salesChannelName;
		this.accountType = accountType;
		this.customerType = customerType;
		this.marketId = marketId;
		this.transactionName = transactionName;
		this.deviceId = deviceId;
		this.phoneCode = phoneCode;
		this.phoneType = phoneType;
		this.isCricketPhone = isCricketPhone;
		this.hasEsnHistory = hasEsnHistory;
		this.customerProvidedEquipment = customerProvidedEquipment;
		this.productCode = productCode;
	}

	public String getServiceName() {
		return "InquireOffers";
	}

	public HashMap<String, Object> invokeService() throws Exception  {
		HashMap< String, Object> espResponse = new HashMap< String, Object >();
		OffersBean[] offersBean = null;
		
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
			InquireOffersResponseInfo response = this.stub.inquireOffers( this.request );
			InquireOffersResponseInfoInquireOffersResponse espResponseObj = response.getInquireOffersResponse();
			
			espResponse.put( "isSuccessful", response.getResponse()[0].getDescription() );
			
			if( Integer.parseInt( response.getResponse()[0].getCode() ) == 0 && espResponseObj != null )	{
				offersBean = ParseInquireOffers.parseInquireOffers( espResponseObj );
				espResponse.put( "espResponseObject", offersBean );
			}
		}
		catch( Exception e )	{
			e.printStackTrace();
			throw new Exception( "Error invoking " + getServiceName() + ": " + e.getMessage() );
		}
		
		return espResponse;
	}

	public void createRequest() {
		this.request = new InquireOffersRequestInfo();
		
		OfferSelectionCriteriaInfo offerSelectionCriteria = new OfferSelectionCriteriaInfo();
		offerSelectionCriteria.setSalesChannelName( this.salesChannelName );
		offerSelectionCriteria.setAccountType( AccountTypeIndicatorInfo.fromValue( this.accountType ));
		offerSelectionCriteria.setCustomerType( CustomerTypeInfo.fromValue( this.customerType ));
		offerSelectionCriteria.setMarketId( this.marketId );
		offerSelectionCriteria.setTransactionName( this.transactionName );
		offerSelectionCriteria.setSubTransactionName("TRACT");
		offerSelectionCriteria.setDeviceInfo( getDeviceInfo() );
		offerSelectionCriteria.setAccessLevel(0);
		offerSelectionCriteria.setProductCodes( getProductCodes() );
		
		request.setOfferSelectionCriteria( offerSelectionCriteria );
	}

	public void createStub() throws Exception {
		try		{
			SOAPHeaderElement header = espHelper.createMessageHeader();
			CricketESPHTTPServicesLocator espService = espHelper.setService( getServiceName() );
			
			this.stub = new InquireOffersStub( espHelper.getEndPoint( getServiceName() ), espService);
			this.stub.setHeader( header );
		}
		catch ( Exception e )	{
			throw new Exception( "Error invoking createStub() method on " + getServiceName() + ": " + e.getMessage() );
		}
	}
	
	private DeviceInfo getDeviceInfo()		{
		DeviceInfo deviceInfo = new DeviceInfo();
		
		//Device ID
		MobileDeviceIdentifierInfo mobileDeviceIdentifierInfo = new MobileDeviceIdentifierInfo();
		
		if( this.deviceId.length() == 11 )	{
			mobileDeviceIdentifierInfo.setEsn( this.deviceId );
		}
		else if( this.deviceId.length() == 18 )	{
			mobileDeviceIdentifierInfo.setMeid( this.deviceId );
		}
		
		deviceInfo.setEquipmentIdentifier( mobileDeviceIdentifierInfo );
		
		//Manufacturer
		ManufacturerInfo manufacturer = new ManufacturerInfo();
		manufacturer.setPhoneCode( this.phoneCode );
		manufacturer.setPhoneType( this.phoneType );
		
		deviceInfo.setManufacturer(manufacturer);
		
		//CricketPhone?
		deviceInfo.setIsCricketPhone( this.isCricketPhone );
		
		//Has history?
		deviceInfo.setHasEsnHistory( this.hasEsnHistory );
		
		//Customer provided?
		deviceInfo.setCustomerProvidedEquipment( this.customerProvidedEquipment );
		
		deviceInfo.setIsRefurbished(false);
		
		return deviceInfo;
	}
	
	private String[] getProductCodes()	{
		String[] productCodes = new String[1];
		
		productCodes[ 0 ] = this.productCode;
		
		return productCodes;
	}
}
