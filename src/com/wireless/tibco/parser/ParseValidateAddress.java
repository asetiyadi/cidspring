package com.wireless.tibco.parser;

import java.util.HashMap;

import com.cricket.esp.ESP.Namespaces.Container.Public.ValidateAddressResponse_xsd.ValidateAddressResponseInfoValidateAddressResponse;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.CoverageMarketInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.NetworkProviderInfo;

public class ParseValidateAddress 
{
	public static HashMap<String, String> parseValidateAddress(ValidateAddressResponseInfoValidateAddressResponse espResponseObj)
	{
		
		HashMap<String, String> addressInfo = new HashMap<String, String>();
		
		return addressInfo;
	}
}
