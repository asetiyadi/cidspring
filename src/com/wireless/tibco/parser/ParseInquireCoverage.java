package com.wireless.tibco.parser;

import java.util.HashMap;

import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.CoverageMarketInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.NetworkProviderInfo;

public class ParseInquireCoverage 
{
	public static HashMap<String, String> parseInquireCoverage(CoverageMarketInfo coverageMarket)
	{
		NetworkProviderInfo networkProvider = coverageMarket.getNetworkProvider();
		int providerId = networkProvider.getId();
		String providerName = networkProvider.getName().toString();
		
		String marketId = coverageMarket.getMarketID();
		
		HashMap<String, String> coverageInfo = new HashMap<String, String>();
		coverageInfo.put("providerId", String.valueOf(providerId));
		coverageInfo.put("providerName", providerName);
		coverageInfo.put("marketId", marketId);
		
		return coverageInfo;
	}
}
