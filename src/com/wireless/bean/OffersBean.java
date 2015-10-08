package com.wireless.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class OffersBean implements Serializable {
	private static final long serialVersionUID = -6318421978518690380L;

	private ArrayList< OfferFeaturesBean > offerFeaturesBean;
	private OfferRatePlanBean offerRatePlanBean;
	
	public OffersBean()	{}
	
	public void setOfferFeaturesBean( ArrayList< OfferFeaturesBean > offerFeaturesBean )	{
		this.offerFeaturesBean = offerFeaturesBean;
	}
	
	public ArrayList< OfferFeaturesBean > getOfferFeaturesBean()	{
		return this.offerFeaturesBean;
	}
	
	public void setOfferRatePlanBean( OfferRatePlanBean offerRatePlanBean )	{
		this.offerRatePlanBean = offerRatePlanBean;
	}
	
	public OfferRatePlanBean getOfferRatePlanBean()		{
		return this.offerRatePlanBean;
	}

	@Override
	public String toString() {
		return "OffersBean [offerFeaturesBean=" + offerFeaturesBean
				+ ", offerRatePlanBean=" + offerRatePlanBean + "]";
	}
	
}
