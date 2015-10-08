package com.wireless.bean;

import java.math.BigInteger;
import java.util.Date;

public class BundledOfferingBean {

	private String action;
	private Date effectiveDate;
	private Date expirationDate;
	private String offeringCode;
	private String offeringDescription;
	private FeatureBean[] features;
	private String offeringName;
	private String offeringValue;
	private BigInteger offerTypeId;
	//private OfferingTaxBean offeringTax;
	
	public BundledOfferingBean()		{}
	
	public void setAction( String action )	{
		this.action = action;
	}
	
	public String getAction()	{
		return this.action;
	}
	

    public Date getEffectiveDate(){
    	return this.effectiveDate;
    }
    public void setEffectiveDate(Date effectiveDate){
    	this.effectiveDate = effectiveDate;
    }
    
    public Date getExpirationDate(){
    	return this.expirationDate;
    }
    public void setExpirationDate(Date expirationDate){
    	this.expirationDate = expirationDate;
    }
    
	
	public void setOfferingCode( String offeringCode )	{
		this.offeringCode = offeringCode;
	}
	
	public String getOfferingCode()	{
		return this.offeringCode;
	}
	
	public void setOfferingDescription( String offeringDescription )	{
		this.offeringDescription = offeringDescription;
	}
	
	public String getOfferingDescription()	{
		return this.offeringDescription;
	}
	
	public void setFeatures(FeatureBean[] features){
		this.features = features;
	}
	public FeatureBean[] getFeatures()	{
		return this.features;
	}
	
	public void setOfferingName( String offeringName )		{
		this.offeringName = offeringName;
	}
	
	public String getOfferingName()	{
		return this.offeringName;
	}
	
	public void setOfferingValue( String offeringValue )		{
		this.offeringValue = offeringValue;
	}
	
	public String getOfferingValue()	{
		return this.offeringValue;
	}
	
	public void setOfferTypeId( BigInteger offerTypeId )	{
		this.offerTypeId = offerTypeId;
	}
	
	public BigInteger getOfferTypeId()	{
		return this.offerTypeId;
	}
	/*
	public void setOfferingTax(OfferingTaxBean offeringTax){
		this.offeringTax = offeringTax;
	}
	
	public OfferingTaxBean getOfferingTax(){
		return this.offeringTax;
	}*/
}
