package com.wireless.bean;

import java.util.Date;

public class EffectiveDatesBean {

	private Date effectiveDate;
	private Date expirationDate;
	
	public EffectiveDatesBean()	{}
	
	public void setEffectiveDate( Date effectiveDate )	{
		this.effectiveDate = effectiveDate;
	}
	
	public Date getEffectiveDate()		{
		return this.effectiveDate;
	}
	
	public void setExpirationDate( Date expirationDate )		{
		this.expirationDate = expirationDate;
	}
	
	public Date getExpirationDate()	{
		return this.expirationDate;
	}
}
