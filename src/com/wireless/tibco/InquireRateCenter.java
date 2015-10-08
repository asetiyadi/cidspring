package com.wireless.tibco;


import java.util.HashMap;

import org.apache.axis.message.SOAPHeaderElement;

import com.cricket.esp.ESP.Namespaces.Container.Public.InquireRateCenterRequest_xsd.InquireRateCenterRequestInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.InquireRateCenterResponse_xsd.InquireRateCenterResponseInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.RateCenterInfo;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CricketESPHTTPServicesLocator;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.InquireRateCenterStub;
import com.wireless.bean.RateCenterBean;
import com.wireless.tibco.parser.ParseInquireRateCenter;
import com.wireless.utilities.ESPHelper;

public class InquireRateCenter implements IService {
	private ESPHelper espHelper = new ESPHelper();
	private InquireRateCenterStub stub;
	private String marketId;
	private InquireRateCenterRequestInfo request;
	
	public InquireRateCenter(String marketId) {
		this.marketId = marketId;
	}

	public String getServiceName() {
		return "InquireRateCenter";
	}

	public HashMap< String, Object> invokeService() {// throws WebserviceException  {
		HashMap< String, Object> espResponse = new HashMap< String, Object >();
		RateCenterBean[] rateCenterBeans = null;
		
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
			InquireRateCenterResponseInfo response = this.stub.inquireRateCenter(this.request );
			RateCenterInfo[] inquireRateCenterResponse = response.getRateCenter();
			
			if("SUCCESS".equalsIgnoreCase(response.getResponse().getDescription())){
				espResponse.put( "isSuccessful", true);
			}		
			
			if( Integer.parseInt( response.getResponse().getCode() ) == 0 && inquireRateCenterResponse!= null )	{
				rateCenterBeans = ParseInquireRateCenter.parseInquireRateCenter(inquireRateCenterResponse);
				espResponse.put( "espResponseObject", rateCenterBeans );
			}
		}
		catch( Exception e )	{
			//throw new WebserviceException(e, getServiceName() + "." + "invokeService()");
			e.printStackTrace();
		}
		
		return espResponse;
	}

	public void createRequest() {
		this.request = new InquireRateCenterRequestInfo();
		this.request.setMarketId(marketId);
	}

	public void createStub() throws Exception {
		try		{
			SOAPHeaderElement header = espHelper.createMessageHeader();
			CricketESPHTTPServicesLocator espService = espHelper.setService( getServiceName() );
			
			this.stub = new InquireRateCenterStub( espHelper.getEndPoint( getServiceName() ), espService);
			this.stub.setHeader( header );
		}
		catch ( Exception e )	{
			e.printStackTrace();
			throw new Exception( "Error invoking createStub() method on " + getServiceName() + ": " + e.getMessage() );
		}
	}
}
