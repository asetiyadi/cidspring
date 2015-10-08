package com.wireless.tibco;


import java.util.HashMap;

import org.apache.axis.message.SOAPHeaderElement;

import com.cricket.esp.ESP.Namespaces.Container.Public.InquireCoverageRequest_xsd.InquireCoverageRequestInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.InquireCoverageResponse_xsd.InquireCoverageResponseInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressStateInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressZipInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.CoverageMarketInfo;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CricketESPHTTPServicesLocator;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.InquireCoverageStub;
import com.wireless.domain.Address;
import com.wireless.tibco.parser.ParseInquireCoverage;
import com.wireless.utilities.ESPHelper;

public class InquireCoverage implements IService {
	private ESPHelper espHelper = new ESPHelper();
	private InquireCoverageStub stub;
	private InquireCoverageRequestInfo request;
	private Address address;
	
	public InquireCoverage(Address address) 
	{
		this.address = address;
	}

	public String getServiceName() 
	{
		return "InquireCoverage";
	}

	public HashMap< String, Object> invokeService() 
	{
		HashMap<String, Object> espResponse = new HashMap<String, Object>();
		HashMap<String, String> networkProvider;
		
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
			InquireCoverageResponseInfo response = this.stub.inquireCoverage(this.request);
			CoverageMarketInfo coverageMarket = response.getCoverageMarket();
			
			if("SUCCESS".equalsIgnoreCase(response.getResponse().getDescription()))
			{
				espResponse.put( "isSuccessful", true);
			}		
			
			if(Integer.parseInt(response.getResponse().getCode()) == 0 && coverageMarket != null )	
			{
				networkProvider = ParseInquireCoverage.parseInquireCoverage(coverageMarket);
				espResponse.put( "espResponseObject", networkProvider);
			}
		}
		catch( Exception e )	
		{
			//throw new WebserviceException(e, getServiceName() + "." + "invokeService()");
			e.printStackTrace();
		}
		
		return espResponse;
	}

	public void createRequest() 
	{
		this.request = new InquireCoverageRequestInfo();
		
		AddressInfo addressInfo = new AddressInfo();
		addressInfo.setAddressLine1(this.address.getAddress1());
		addressInfo.setCity(this.address.getCity());
		
		AddressStateInfo stateInfo = AddressStateInfo.fromValue(this.address.getState());
		addressInfo.setState(stateInfo);
		
		AddressZipInfo zipInfo = new AddressZipInfo();
		zipInfo.setZipCode(this.address.getZip());
		zipInfo.setZipCodeExtension(this.address.getZipExtension());
		addressInfo.setZip(zipInfo);
		
		this.request.setAddress(addressInfo);
	}

	public void createStub() throws Exception 
	{
		try		
		{
			SOAPHeaderElement header = espHelper.createMessageHeader();
			CricketESPHTTPServicesLocator espService = espHelper.setService( getServiceName() );
			
			this.stub = new InquireCoverageStub(espHelper.getEndPoint( getServiceName() ), espService);
			this.stub.setHeader(header);
		}
		catch ( Exception e )	
		{
			e.printStackTrace();
			throw new Exception( "Error invoking createStub() method on " + getServiceName() + ": " + e.getMessage() );
		}
	}
}
