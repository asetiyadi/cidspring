/***
 * @Note
 * This template can be used as skeleton to create new ESP service;
 * It just needs to replace some variables, request/response object, method name, etc.
 *
 ***/

package com.wireless.tibco;

import java.util.HashMap;

import org.apache.axis.message.SOAPHeaderElement;

import com.cricket.esp.ESP.Namespaces.Container.Public.ValidateDeviceRequest_xsd.ValidateDeviceRequestInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.ValidateDeviceResponse_xsd.ValidateDeviceResponseInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.ValidateDeviceResponse_xsd.ValidateDeviceResponseInfoDeviceInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.MarketInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.MobileDeviceIdentifierInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.NetworkProviderInfo;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CricketESPHTTPServicesLocator;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.ValidateDeviceStub;
import com.wireless.domain.Device;
import com.wireless.tibco.parser.ParseValidateDevice;
import com.wireless.utilities.ESPHelper;

public class ValidateDevice implements IService {
	
	private ESPHelper espHelper = new ESPHelper();
	private ValidateDeviceStub stub;
	private ValidateDeviceRequestInfo request;
	
	private HashMap<String, String> deviceInfo;
	private String phoneId;
	private String marketId;
	//private String iccid;
	
	/*public ValidateDevice( String phoneId, String marketId, String iccid )		{
		this.phoneId = phoneId;
		this.marketId = marketId;
		this.iccid = iccid;
	}*/

	public ValidateDevice(HashMap<String, String> deviceInfo, String marketId)		{
		this.deviceInfo = deviceInfo;
		this.marketId = marketId;
	}
	
	/*public ValidateDevice( String phoneId )		{
		this.phoneId = phoneId;
		this.marketId = "";
		this.iccid = "";
	}*/
	
	public String getServiceName() {
		return "ValidateDevice";
	}

	public HashMap< String, Object> invokeService() {
		HashMap< String, Object> espResponse = new HashMap< String, Object >();
		
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
			ValidateDeviceResponseInfo response = this.stub.validateDevice( this.request );
			ValidateDeviceResponseInfoDeviceInfo espResponseObj = response.getDeviceInfo();
			NetworkProviderInfo[] networks = response.getNetworkProvider();
			
			
			espResponse.put( "isSuccessful", response.getResponse()[0].getDescription() );
			
			if( Integer.parseInt( response.getResponse()[0].getCode() ) == 0 && espResponseObj != null )	{
				Device deviceBean = new Device();
				
				deviceBean = ParseValidateDevice.parseValidateDevice( espResponseObj, networks );
				espResponse.put( "espResponseObject", deviceBean );
			}
		}
		catch( Exception e )	{
			//throw new WebserviceException(e, getServiceName() + "." + "invokeService()");
			e.printStackTrace();
		}
		
		return espResponse;
	}

	public void createRequest() {
		this.request = new ValidateDeviceRequestInfo();
		this.phoneId = deviceInfo.get("deviceId");
		
		/***
		 * Device Info
		 */
		MobileDeviceIdentifierInfo mobileDevice = new MobileDeviceIdentifierInfo();
		if( this.phoneId.length() == 11 )	{
			mobileDevice.setEsn( this.phoneId );
		}
		else if( this.phoneId.length() == 14 )	{
			mobileDevice.setImei( this.phoneId );
		}
		else if( this.phoneId.length() == 18 )	{
			mobileDevice.setMeid( this.phoneId );
		}
		this.request.setDevice( mobileDevice );
		
		/***
		 * ICCID (Card) Info
		 */
		/*
		if( this.iccid.length() > 0 )	{
			ValidateDeviceRequestInfoCard deviceCardInfo = new ValidateDeviceRequestInfoCard();
			deviceCardInfo.setIccid( this.iccid );
			
			this.request.setCard( deviceCardInfo );
		}*/
		
		/***
		 * Billing Market
		 */
		if( this.marketId.length() > 0 )	{
			MarketInfo billingMarket = new MarketInfo();
			billingMarket.setId( this.marketId );
			
			this.request.setBillingMarket( billingMarket );
		}
		
		/***
		 * Mask
		 */
		this.request.setMask( "HI" );
	}

	public void createStub() throws Exception {
		try		{
			SOAPHeaderElement header = espHelper.createMessageHeader();
			CricketESPHTTPServicesLocator espService = espHelper.setService( getServiceName() );
			
			this.stub = new ValidateDeviceStub( espHelper.getEndPoint( getServiceName() ), espService);
			this.stub.setHeader( header );
		}
		catch ( Exception e )	{
			throw new Exception( "Error invoking createStub() method on " + getServiceName() + ": " + e.getMessage() );
		}
	}
}
