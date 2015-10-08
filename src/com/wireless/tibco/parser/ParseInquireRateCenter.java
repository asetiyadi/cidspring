package com.wireless.tibco.parser;

import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.RateCenterInfo;
import com.wireless.bean.RateCenterBean;

public class ParseInquireRateCenter	{// extends	ParseSuper {

	/**
	 * 
	 * @param rateCentersResponse RateCenterInfo
	 * @return {@link com.cricket.cid.bean.info.RateCenterBean}
	 */
	public static RateCenterBean[] parseInquireRateCenter(
			RateCenterInfo[] rateCentersResponse)	{
		RateCenterBean[] rateCenterBeans = null; 
		RateCenterBean rateCenterBean= null;
		
		int totalRateCenters = 0;
		if(rateCentersResponse != null){
			totalRateCenters = rateCentersResponse.length;
			rateCenterBeans = new RateCenterBean[totalRateCenters];
			for(int i=0; i< totalRateCenters; i++){
				if (rateCentersResponse[i] != null){
					rateCenterBean= new RateCenterBean();
					rateCenterBean.setId(rateCentersResponse[i].getId().toString());
					rateCenterBean.setName(rateCentersResponse[i].getName());
					rateCenterBean.setDescription(rateCentersResponse[i].getDescription());
					rateCenterBean.setNpa(rateCentersResponse[i].getNpa());
					rateCenterBean.setEffectiveDate(rateCentersResponse[i].getEffectiveDate());
					rateCenterBeans[i] = rateCenterBean;
				}
			}
		}
		return rateCenterBeans;
	}
	
}
