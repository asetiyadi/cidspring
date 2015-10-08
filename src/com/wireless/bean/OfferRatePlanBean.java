package com.wireless.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class OfferRatePlanBean implements Serializable {
	private static final long serialVersionUID = -4492666122525279828L;

	private int arrayIndex;
	private int displayMessageId;
	private int groupId;
	private String groupName;
	private int orderNo;
	private int planId;
	private String planName;
	private BigDecimal price;
	
	public OfferRatePlanBean()	{}
	
	public void setArrayIndex( int arrayIndex )	{
		this.arrayIndex = arrayIndex;
	}
	
	public int getArrayIndex()	{
		return this.arrayIndex;
	}
	
	public void setDisplayMessageId( int displayMessageId )		{
		this.displayMessageId = displayMessageId;
	}
	
	public int getDisplayMessageId()	{
		return this.displayMessageId;
	}
	
	public void setGroupId( int groupId )	{
		this.groupId = groupId;
	}
	
	public int getGroupId()	{
		return this.groupId;
	}
	
	public void setGroupName( String groupName )	{
		this.groupName = groupName;
	}
	
	public String getGroupName()		{
		return this.groupName;
	}
	
	public void setOrderNo( int orderNo )		{
		this.orderNo = orderNo;
	}
	
	public int getOrderNo()	{
		return this.orderNo;
	}
	
	public void setPlanId( int planId )	{
		this.planId = planId;
	}
	
	public int getPlanId()	{
		return this.planId;
	}
	
	public void setPlanName( String planName )	{
		this.planName = planName;
	}
	
	public String getPlanName()	{
		return this.planName;
	}
	
	public void setPrice( BigDecimal price )	{
		this.price = price;
	}
	
	public BigDecimal getPrice()	{
		return this.price;
	}
}
