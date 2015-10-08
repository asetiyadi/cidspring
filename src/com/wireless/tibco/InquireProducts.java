package com.wireless.tibco;


import java.util.HashMap;
import java.util.List;

import org.apache.axis.message.SOAPHeaderElement;

import com.cricket.esp.ESP.Namespaces.Container.Public.InquireProductsRequest_xsd.InquireProductsRequestInfo;
import com.cricket.esp.ESP.Namespaces.Container.Public.InquireProductsResponse_xsd.InquireProductsResponseInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AccountTypeIndicatorInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.CustomerTypeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.ManufacturerInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.ProductInfo;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CricketESPHTTPServicesLocator;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.InquireProductsStub;
import com.wireless.bean.ProductBean;
import com.wireless.tibco.parser.ParseInquireProducts;
import com.wireless.utilities.ESPHelper;

public class InquireProducts implements IService 
{
	private ESPHelper espHelper = new ESPHelper();
	private InquireProductsStub stub;
	private InquireProductsRequestInfo request;
	
	private String salesChannel;
	private String customerType;
	private String marketId;
	private String transactionType;
	private String deviceType;
	private String[] accountTypes;
	
	public InquireProducts(String salesChannel, String customerType, String marketId, String transactionType, String deviceType, String[] accountTypes) 
	{
		this.salesChannel = salesChannel;
		this.customerType = customerType;
		this.marketId = marketId;
		this.transactionType = transactionType;
		this.deviceType = deviceType;
		this.accountTypes = accountTypes;
	}

	public String getServiceName() 
	{
		return "InquireProducts";
	}

	public HashMap< String, Object> invokeService() 
	{
		HashMap<String, Object> espResponse = new HashMap<String, Object>();
		List<ProductBean> products;
		
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
			InquireProductsResponseInfo response = this.stub.inquireProducts(this.request);
			ProductInfo[] espResponseObj = response.getInquireProductsResponse();
			
			/*
			if("SUCCESS".equalsIgnoreCase(response.getResponse().getDescription()))
			{
				espResponse.put("isSuccessful", true);
			}		
			*/
			if(Integer.parseInt(response.getResponse()[0].getCode()) == 0 && espResponseObj != null)	
			{
				products = ParseInquireProducts.parseInquireProducts(espResponseObj);
				espResponse.put("espResponseObject", products);
			}
		}
		catch(Exception e)	
		{
			//throw new WebserviceException(e, getServiceName() + "." + "invokeService()");
			e.printStackTrace();
		}
		
		return espResponse;
	}

	@Override
	public String toString() {
		return "InquireProducts [request=" + request + "]";
	}

	public void createRequest() 
	{
		this.request = new InquireProductsRequestInfo();

		this.request.setSalesChannelName(this.salesChannel);
		
		AccountTypeIndicatorInfo[] accountTypeInfo = new AccountTypeIndicatorInfo[ this.accountTypes.length ];
		for( int x=0; x<this.accountTypes.length; x++ )	{
			accountTypeInfo[x] = AccountTypeIndicatorInfo.fromValue( this.accountTypes[x] );
		}
		
		this.request.setAccountTypes(accountTypeInfo);
		
		if(this.customerType.equalsIgnoreCase("S"))
		{
			this.request.setCustomerType(CustomerTypeInfo.S);
		}
		
		this.request.setMarketId(this.marketId);
		this.request.setTransactionName(this.transactionType);
		
		ManufacturerInfo manufacturerInfo = new ManufacturerInfo();
		manufacturerInfo.setPhoneType(this.deviceType);
		this.request.setManufacturerInfo(manufacturerInfo);
		
		System.out.println("REQUEST: " + this.request.toString());
	}

	public void createStub() throws Exception 
	{
		try		
		{
			SOAPHeaderElement header = espHelper.createMessageHeader();
			CricketESPHTTPServicesLocator espService = espHelper.setService(getServiceName());
			
			this.stub = new InquireProductsStub(espHelper.getEndPoint(getServiceName()), espService);
			this.stub.setHeader(header);
		}
		catch(Exception e)	
		{
			e.printStackTrace();
			throw new Exception("Error invoking createStub() method on " + getServiceName() + ": " + e.getMessage());
		}
	}
}
