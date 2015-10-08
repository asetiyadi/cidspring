package com.wireless.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BucketDetailBean implements Serializable 
{
	private static final long serialVersionUID = -1344518881526660753L;

	private BucketUsageBean usageBean;
	private BigDecimal bucketBalance;
	private String bucketIdentifier;
	private String bucketType;
	private String mdn;
	private boolean isBoltOn;
	private Date startDate;
	private Date endDate;
	//private ApplicationErrorBean applicationErrorBean;
	
	public BucketDetailBean()		{}
	
	public BucketUsageBean getUsageBean() {
		return this.usageBean;
	}

	public void setUsageBean(BucketUsageBean usageBean) {
		this.usageBean = usageBean;
	}
	
	public void setBucketBalance( BigDecimal bucketBalance )	{
		this.bucketBalance = bucketBalance;
	}
	
	public BigDecimal getBucketBalance()	{
		return this.bucketBalance;
	}
	
	public void setBucketIdentifier( String bucketIdentifier )	{
		this.bucketIdentifier = bucketIdentifier;
	}
	
	public String getBucketIdentifier()	{
		return this.bucketIdentifier;
	}
	
	public void setBucketType( String bucketType )	{
		this.bucketType = bucketType;
	}
	
	public String getBucketType()	{
		return this.bucketType;
	}
	
	public String getMdn() {
		return this.mdn;
	}

	public void setMdn(String mdn) {
		this.mdn = mdn;
	}

	public boolean isBoltOn() {
		return this.isBoltOn;
	}

	public void setBoltOn(boolean isBoltOn) {
		this.isBoltOn = isBoltOn;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/*
	public ApplicationErrorBean getApplicationErrorBean() {
		return this.applicationErrorBean;
	}

	public void setApplicationErrorBean(ApplicationErrorBean applicationErrorBean) {
		this.applicationErrorBean = applicationErrorBean;
	}
	*/

	@Override
	public String toString() {
		return "BucketDetailBean [usageBean=" + usageBean + ", bucketBalance="
				+ bucketBalance + ", bucketIdentifier=" + bucketIdentifier
				+ ", bucketType=" + bucketType + ", mdn=" + mdn + ", isBoltOn="
				+ isBoltOn + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
}
