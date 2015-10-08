package com.wireless.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class BucketUsageBean implements Serializable 
{
	private static final long serialVersionUID = 3464435740099595601L;

	private String bucketName;
	private String bucketUnit;
	private BigDecimal bucketSizeMonetaryAmount;
	private String bucketSizeNonMonetaryAmount;
	private BigDecimal bucketUnitsSpentMonetaryAmount;
	private String bucketUnitsSpentNonMonetaryAmount;
	private BigDecimal bucketRemainsMonetaryAmount;
	private String bucketRemainsNonMonetaryAmount;
	private int usageUnit;
	private String eventType;
	private Integer totalUsageUnits;
	
	public BucketUsageBean()	{}
	
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getBucketUnit() {
		return bucketUnit;
	}
	public void setBucketUnit(String bucketUnit) {
		this.bucketUnit = bucketUnit;
	}
	
	public BigDecimal getBucketSizeMonetaryAmount() {
		return this.bucketSizeMonetaryAmount;
	}

	public void setBucketSizeMonetaryAmount(BigDecimal bucketSizeMonetaryAmount) {
		this.bucketSizeMonetaryAmount = bucketSizeMonetaryAmount;
	}

	public String getBucketSizeNonMonetaryAmount() {
		return bucketSizeNonMonetaryAmount;
	}

	public void setBucketSizeNonMonetaryAmount(String bucketSizeNonMonetaryAmount) {
		this.bucketSizeNonMonetaryAmount = bucketSizeNonMonetaryAmount;
	}

	public BigDecimal getBucketUnitsSpentMonetaryAmount() {
		return bucketUnitsSpentMonetaryAmount;
	}
	
	public void setBucketUnitsSpentMonetaryAmount( BigDecimal bucketUnitsSpentMonetaryAmount) {
		this.bucketUnitsSpentMonetaryAmount = bucketUnitsSpentMonetaryAmount;
	}
	
	public String getBucketUnitsSpentNonMonetaryAmount() {
		return bucketUnitsSpentNonMonetaryAmount;
	}
	
	public void setBucketUnitsSpentNonMonetaryAmount( String bucketUnitsSpentNonMonetaryAmount) {
		this.bucketUnitsSpentNonMonetaryAmount = bucketUnitsSpentNonMonetaryAmount;
	}
	
	public BigDecimal getBucketRemainsMonetaryAmount() {
		return bucketRemainsMonetaryAmount;
	}
	
	public void setBucketRemainsMonetaryAmount( BigDecimal bucketRemainsMonetaryAmount) {
		this.bucketRemainsMonetaryAmount = bucketRemainsMonetaryAmount;
	}
	
	public String getBucketRemainsNonMonetaryAmount() {
		return bucketRemainsNonMonetaryAmount;
	}
	
	public void setBucketRemainsNonMonetaryAmount( String bucketRemainsNonMonetaryAmount) {
		this.bucketRemainsNonMonetaryAmount = bucketRemainsNonMonetaryAmount;
	}

	public int getUsageUnit() {
		return this.usageUnit;
	}

	public void setUsageUnit(int usageUnit) {
		this.usageUnit = usageUnit;
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Integer getTotalUsageUnits() {
		return this.totalUsageUnits;
	}

	public void setTotalUsageUnits(Integer totalUsageUnits) {
		this.totalUsageUnits = totalUsageUnits;
	}

	@Override
	public String toString() {
		return "BucketUsageBean [bucketName=" + bucketName + ", bucketUnit="
				+ bucketUnit + ", bucketSizeMonetaryAmount="
				+ bucketSizeMonetaryAmount + ", bucketSizeNonMonetaryAmount="
				+ bucketSizeNonMonetaryAmount
				+ ", bucketUnitsSpentMonetaryAmount="
				+ bucketUnitsSpentMonetaryAmount
				+ ", bucketUnitsSpentNonMonetaryAmount="
				+ bucketUnitsSpentNonMonetaryAmount
				+ ", bucketRemainsMonetaryAmount="
				+ bucketRemainsMonetaryAmount
				+ ", bucketRemainsNonMonetaryAmount="
				+ bucketRemainsNonMonetaryAmount + ", usageUnit=" + usageUnit
				+ ", eventType=" + eventType + ", totalUsageUnits="
				+ totalUsageUnits + "]";
	}
}
