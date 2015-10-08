package com.wireless.tibco;

import org.apache.axis.message.SOAPHeaderElement;

import com.cricket.esp.ESP.Namespaces.Container.Public.InquireAccountRequest_xsd.InquireAccountRequestInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.InquireAccountResponse_xsd.InquireAccountResponseInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.InquireAccountResponse_xsd.InquireAccountResponseInfoAccount;
import com.cricket.esp.ESP.Namespaces.Container.Public.InquireAccountResponse_xsd.InquireAccountResponseInfoAccountCustomer;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.GenericRecordLocatorInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.GenericRecordLocatorInfoAccountSelector;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CricketESPHTTPServicesLocator;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.InquireAccountStub;
import com.wireless.bean.ResponseBean;
import com.wireless.domain.Account;
import com.wireless.tibco.parser.ParseInquireAccount;
import com.wireless.utilities.ESPHelper;

public class InquireAccount {
	
	private ESPHelper espHelper = new ESPHelper();
	private InquireAccountStub stub;
	private String accountNumber;
	private InquireAccountRequestInfo request;
	
	public InquireAccount( String accountNumber )		{
		this.accountNumber = accountNumber; 
	}

	public String getServiceName() {
		return "InquireAccount";
	}

	public ResponseBean invokeService() {	//throws WebserviceException  {
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
			InquireAccountResponseInfo response = this.stub.inquireAccount( this.request );
			InquireAccountResponseInfoAccount espResponseObj = response.getAccount();
			
			//espResponse.put( "isSuccessful", response.getResponse().getDescription() );
			
			if( Integer.parseInt( response.getResponse().getCode() ) == 0 && espResponseObj != null )	{
				responseBean.setObject((Account) ParseInquireAccount.parseInquireAccount(espResponseObj));
				responseBean.setCode(Integer.parseInt(response.getResponse().getCode()));
				responseBean.setDescription(response.getResponse().getDescription());
				responseBean.setClassName("Account");
			}
		}
		catch( Exception e )	{
			//throw new WebserviceException(e, getServiceName() + ".invokeService()");
			e.printStackTrace();
		}
		
		return responseBean;
	}

	public void createRequest() {
		this.request = new InquireAccountRequestInfo();

		/***
		 * Set the account number to search
		 */
		GenericRecordLocatorInfoAccountSelector accountSelector = new GenericRecordLocatorInfoAccountSelector();
		accountSelector.setBillingAccountNumber( this.accountNumber );
		
		GenericRecordLocatorInfo genericRecordLocator = new GenericRecordLocatorInfo();
		genericRecordLocator.setAccountSelector( accountSelector );
		
		this.request.setGenericRecordLocator( genericRecordLocator );
		
		/***
		 * Set the mask
		 */
		this.request.setMask( "AE:SL:DC:PP:OO:DF" );
	}

	public void createStub() throws Exception {
		try		{
			SOAPHeaderElement header = espHelper.createMessageHeader();
			CricketESPHTTPServicesLocator espService = espHelper.setService( getServiceName() );
			
			this.stub = new InquireAccountStub( espHelper.getEndPoint( getServiceName() ), espService);
			this.stub.setHeader( header );
		}
		catch ( Exception e )	{
			e.printStackTrace();
			throw new Exception( "Error invoking createStub() method on " + getServiceName() + ": " + e.getMessage() );
		}
	}
}
