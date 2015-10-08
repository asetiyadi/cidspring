package com.wireless.bean;

import java.io.Serializable;

public class OfferFeaturesBean implements Serializable {
	private static final long serialVersionUID = -5712379221292538788L;

	//InquireOffersResponse.OfferRatePlan
	private double add;
	private int disableTriggerIndex;
	private int disableTriggerOfferId;
	private String featurePrice;
	private int displayTypeId;
	private int fcOfferIndex;
	private int fixedCostParentOfferId;
	private int groupId;
	private int id;
	private Boolean isPreSelect;
	private int offerArrayIndex;
	private int ratePlanArrayIndex;
	private int triggeringOfferId;
	private int triggeringOfferIndex;
	private String type;
	private boolean isAvailable;
	private boolean isDisplayOffer;
	private boolean isPositiveTrigger;
	private boolean isSelectable;
	private boolean isSelected;
	private boolean isStandAloneComboComponent;
	private boolean isDisablePositiveTrigger;
	
	//InquireOffersResponse.Offer
	private int arrayIndex;
	private String displayMessageId;
	private String offerName;
	private boolean isGroupExpand;
	private boolean isTopFeature;
	private Integer topFeaturePrecedence;
	private String offerType;
	private int orderNo;
	private int superOfferGroupId;
	private int superOfferGroupLocationId;
	private String superOfferGroupName;

	public OfferFeaturesBean() {}

	public double getAdd() {
		return this.add;
	}

	public void setAdd(double add) {
		this.add = add;
	}
	
	public int getDisableTriggerIndex() {
		return this.disableTriggerIndex;
	}

	public void setDisableTriggerIndex(int disableTriggerIndex) {
		this.disableTriggerIndex = disableTriggerIndex;
	}
	
	public int getDisableTriggerOfferId() {
		return this.disableTriggerOfferId;
	}

	public void setDisableTriggerOfferId(int disableTriggerOfferId) {
		this.disableTriggerOfferId = disableTriggerOfferId;
	}
	
	public String getFeaturePrice() {
		return this.featurePrice;
	}

	public void setFeaturePrice(String featurePrice) {
		this.featurePrice = featurePrice;
	}
	
	public String getDisplayMessageId() {
		return this.displayMessageId;
	}

	public void setDisplayMessageId(String displayMessageId) {
		this.displayMessageId = displayMessageId;
	}
	
	public int getDisplayTypeId() {
		return this.displayTypeId;
	}

	public void setDisplayTypeId(int displayTypeId) {
		this.displayTypeId = displayTypeId;
	}
	
	public int getFcOfferIndex() {
		return this.fcOfferIndex;
	}

	public void setFcOfferIndex(int fcOfferIndex) {
		this.fcOfferIndex = fcOfferIndex;
	}
	
	public int getFixedCostParentOfferId() {
		return this.fixedCostParentOfferId;
	}

	public void setFixedCostParentOfferId(int fixedCostParentOfferId) {
		this.fixedCostParentOfferId = fixedCostParentOfferId;
	}
	 
	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	 
	public int getId() {
		return this.id;
	}

	 public void setId(int id) {
		 this.id = id;
	 }
	 
	 public java.lang.Boolean getIsPreSelect() {
		 return this.isPreSelect;
	 }

	 public void setIsPreSelect(java.lang.Boolean isPreSelect) {
		 this.isPreSelect = isPreSelect;
	 }
	    
	 public int getOfferArrayIndex() {
		 return this.offerArrayIndex;
	 }
	
	 public void setOfferArrayIndex(int offerArrayIndex) {
		 this.offerArrayIndex = offerArrayIndex;
	 }  
	
	 public int getRatePlanArrayIndex() {
		 return this.ratePlanArrayIndex;
	 }

	 public void setRatePlanArrayIndex(int ratePlanArrayIndex) {
		 this.ratePlanArrayIndex = ratePlanArrayIndex;
	 }
	 
	 public int getTriggeringOfferId() {
		 return this.triggeringOfferId;
	 }

	 public void setTriggeringOfferId(int triggeringOfferId) {
		 this.triggeringOfferId = triggeringOfferId;
	 }
	 
	 public int getTriggeringOfferIndex() {
		 return this.triggeringOfferIndex;
	 }

	 public void setTriggeringOfferIndex(int triggeringOfferIndex) {
		 this.triggeringOfferIndex = triggeringOfferIndex;
	 }
	 
	 public String getType() {
		 return this.type;
	 }

	 public void setType(java.lang.String type) {
		 this.type = type;
	 }
	 
	 public boolean getIsAvailable() {
		 return this.isAvailable;
	 }

	 public void setIsAvailable(boolean isAvailable) {
		 this.isAvailable = isAvailable;
	 }
	 
	 public boolean getIsDisplayOffer() {
		 return this.isDisplayOffer;
	 }

	 public void setIsDisplayOffer(boolean isDisplayOffer) {
		 this.isDisplayOffer = isDisplayOffer;
	 }
	 
	 public boolean getIsPositiveTrigger() {
		 return this.isPositiveTrigger;
	 }

	 public void setIsPositiveTrigger(boolean isPositiveTrigger) {
		 this.isPositiveTrigger = isPositiveTrigger;
	 }
	 
	 public boolean getIsSelectable() {
		 return this.isSelectable;
	 }

	 public void setIsSelectable(boolean isSelectable) {
		 this.isSelectable = isSelectable;
	 }
	 
	 public boolean getIsSelected() {
		 return this.isSelected;
	 }

	 public void setIsSelected(boolean isSelected) {
		 this.isSelected = isSelected;
	 }

	 public boolean getIsStandAloneComboComponent() {
		 return this.isStandAloneComboComponent;
	 }

	 public void setIsStandAloneComboComponent(boolean isStandAloneComboComponent) {
		 this.isStandAloneComboComponent = isStandAloneComboComponent;
	 }

	 public boolean getIsDisablePositiveTrigger() {
		 return this.isDisablePositiveTrigger;
	 }

	 public void setIsDisablePositiveTrigger(boolean isDisablePositiveTrigger) {
		 this.isDisablePositiveTrigger = isDisablePositiveTrigger;
	 }
	 
	 public void setArrayIndex( int arrayIndex )	{
		this.arrayIndex = arrayIndex;
	}
		
	public int getArrayIndex()	{
		return this.arrayIndex;
	}
		
	public void setOfferName( String offerName )	{
		this.offerName = offerName;
	}
	
	public String getOfferName()		{
		return this.offerName;
	}
	
	public void setIsGroupExpand( boolean isGroupExpand )	{
		this.isGroupExpand = isGroupExpand;
	}
	
	public boolean getIsGroupExpand()	{
		return this.isGroupExpand;
	}
	
	public void setIsTopFeature( boolean isTopFeature )	{
		this.isTopFeature = isTopFeature;
	}
	
	public boolean getIsTopFeature()	{
		return this.isTopFeature;
	}
	
	public void setTopFeaturePrecedence( Integer topFeaturePrecedence )		{
		this.topFeaturePrecedence = topFeaturePrecedence;
	}
	
	public Integer getTopFeaturePrecedence()	{
		return this.topFeaturePrecedence;
	}
	
	public void setOfferType( String offerType )		{
		this.offerType = offerType;
	}
	
	public String getOfferType()	{
		return this.offerType;
	}
	
	public void setOrderNo( int orderNo )		{
		this.orderNo = orderNo;
	}
	
	public int getOrderNo()	{
		return this.orderNo;
	}
	
	public void setSuperOfferGroupId( int superOfferGroupId )	{
		this.superOfferGroupId = superOfferGroupId;
	}
	
	public int getSuperOfferGroupId()		{
		return this.superOfferGroupId;
	}
	
	public void setSuperOfferGroupLocationId( int superOfferGroupLocationId )	{
		this.superOfferGroupLocationId = superOfferGroupLocationId;
	}
	
	public int getSuperOfferGroupLocationId()		{
		return this.superOfferGroupLocationId;
	}
	
	public void setSuperOfferGroupName( String superOfferGroupName )		{
		this.superOfferGroupName = superOfferGroupName;
	}
	
	public String getSuperOfferGroupName()	{
		return this.superOfferGroupName;
	}

	@Override
	public String toString() {
		return "OfferFeaturesBean [add=" + add + ", disableTriggerIndex="
				+ disableTriggerIndex + ", disableTriggerOfferId="
				+ disableTriggerOfferId + ", featurePrice=" + featurePrice
				+ ", displayTypeId=" + displayTypeId + ", fcOfferIndex="
				+ fcOfferIndex + ", fixedCostParentOfferId="
				+ fixedCostParentOfferId + ", groupId=" + groupId + ", id="
				+ id + ", isPreSelect=" + isPreSelect + ", offerArrayIndex="
				+ offerArrayIndex + ", ratePlanArrayIndex="
				+ ratePlanArrayIndex + ", triggeringOfferId="
				+ triggeringOfferId + ", triggeringOfferIndex="
				+ triggeringOfferIndex + ", type=" + type + ", isAvailable="
				+ isAvailable + ", isDisplayOffer=" + isDisplayOffer
				+ ", isPositiveTrigger=" + isPositiveTrigger
				+ ", isSelectable=" + isSelectable + ", isSelected="
				+ isSelected + ", isStandAloneComboComponent="
				+ isStandAloneComboComponent + ", isDisablePositiveTrigger="
				+ isDisablePositiveTrigger + ", arrayIndex=" + arrayIndex
				+ ", displayMessageId=" + displayMessageId + ", offerName="
				+ offerName + ", isGroupExpand=" + isGroupExpand
				+ ", isTopFeature=" + isTopFeature + ", topFeaturePrecedence="
				+ topFeaturePrecedence + ", offerType=" + offerType
				+ ", orderNo=" + orderNo + ", superOfferGroupId="
				+ superOfferGroupId + ", superOfferGroupLocationId="
				+ superOfferGroupLocationId + ", superOfferGroupName="
				+ superOfferGroupName + "]";
	}
	
}
