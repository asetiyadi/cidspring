package com.wireless.tibco;

import java.util.HashMap;

import org.apache.axis.message.SOAPHeaderElement;

import com.cricket.esp.ESP.Namespaces.Container.Public.EchoRequest_xsd.EchoRequestInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.EchoResponse_xsd.EchoResponseInfo;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CricketESPHTTPServicesLocator;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.EchoStub;
import com.wireless.utilities.ESPHelper;


public class Echo implements IService 
{
	private ESPHelper espHelper = new ESPHelper();
	private EchoStub stub;
	private EchoRequestInfo request;
	
	public Echo()	{
	}
	
	public String getServiceName()	{
		return "Echo";
	}
	
	public HashMap< String, Object > invokeService() throws Exception	{
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
			EchoResponseInfo response = this.stub.echo( this.request );
			
			String conversationId = this.espHelper.getConversationId( this.stub.getResponseHeaders() );

			espResponse.put( "conversationId", conversationId );
			espResponse.put( "isSuccessful", response.getResponse().getDescription() );
		}
		catch( Exception e )	{
			e.printStackTrace();
			throw new Exception( "Error invoking " + getServiceName() + ": " + e.getMessage() );
		}
		
		return espResponse;
	}
	
	public void createRequest()	{
		this.request = new EchoRequestInfo();
	}
	
	public void createStub() throws Exception {
		try		{
			SOAPHeaderElement header = espHelper.createMessageHeader();
			CricketESPHTTPServicesLocator espService = espHelper.setService( getServiceName() );
			
			this.stub = new EchoStub( espHelper.getEndPoint( getServiceName() ), espService);
			this.stub.setHeader( header );
		}
		catch ( Exception e )	{
			throw new Exception( "Error invoking createStub() method on " + getServiceName() + ": " + e.getMessage() );
		}
	}
}