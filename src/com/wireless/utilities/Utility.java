package com.wireless.utilities;

import java.util.HashMap;

import com.wireless.bean.RateCenterBean;
import com.wireless.domain.Address;
import com.wireless.tibco.InquireCoverage;
import com.wireless.tibco.InquireRateCenter;

public class Utility 
{
	public static RateCenterBean[] getRateCenterInfo(String marketId)
	{
		InquireRateCenter rateCenterSvc = new InquireRateCenter(marketId);
		HashMap<String, Object> result = rateCenterSvc.invokeService();
		
		RateCenterBean[] rcBeans = (RateCenterBean[]) result.get("espResponseObject");
		return rcBeans;
	}
	
	public static HashMap<String, String> getNetworkCoverage(Address address)
	{
		InquireCoverage inquireCoverage = new InquireCoverage(address);
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> networkCoverage = (HashMap<String, String>) inquireCoverage.invokeService().get("espResponseObject");
		
		return networkCoverage;
	}
}
