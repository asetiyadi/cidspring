package com.wireless.bean;

import java.math.BigDecimal;
import java.util.Date;

public class PricePlanBean {

	private String planCode;
    private String oldPlanCode;
    private String planType;
    private String pricePlanStatus;
    private String planName;
    private String planDescription;
    private BigDecimal recurringCharge;
    private Date effectiveDate;
    private Date expirationDate;
    //private ActivationFeeBean[] activationFee;
    //private EarlyTerminationFeeBean[] earlyTerminationFee;
    //private ContractTermBean[] contractTerm;
    private BundledOfferingBean[] bundledOfferings;
    //private NameValuePairBean[] pricePlanProperties;

    public PricePlanBean() {    
    }
	
    public String getPlanCode(){
    	return this.planCode;
    }
    public void setPlanCode(String planCode){
    	this.planCode = planCode;
    }
    
    public String getOldPlanCode(){
    	return this.oldPlanCode;
    }
    public void setOldPlanCode(String oldPlanCode){
    	this.oldPlanCode = oldPlanCode;
    }
    
    public String getPlanType(){
    	return this.planType;
    }
    public void setPlanType(String planType){
    	this.planType = planType;
    }
    
    public String getPricePlanStatus(){
    	return this.pricePlanStatus;
    }
    public void setPricePlanStatus(String pricePlanStatus){
    	this.pricePlanStatus = pricePlanStatus;
    }
    
    public String getPlanName(){
    	return this.planName;
    }
    public void setPlanName(String planName){
    	this.planName = planName;
    }
    
    public String getPlanDescription(){
    	return this.planDescription;
    }
    public void setPlanDescription(String planDescription){
    	this.planDescription = planDescription;
    }
    
    public BigDecimal getRecurringCharge(){
    	return this.recurringCharge;
    }
    public void setRecurringCharge(BigDecimal recurringCharge){
    	this.recurringCharge = recurringCharge;
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
    
    public BundledOfferingBean[] getBundledOfferings(){
    	return this.bundledOfferings;
    }
    public void setBundledOfferings(BundledOfferingBean[] bundledOffering){
    	this.bundledOfferings = bundledOffering;
    }
    /*
    public ActivationFeeBean[] getActivationFees(){
    	return this.activationFee;
    }
    public void setActivationFees(ActivationFeeBean[] activationFee){
    	this.activationFee = activationFee;
    }
    
    public EarlyTerminationFeeBean[] getEarlyTerminationFees(){
    	return this.earlyTerminationFee;
    }
    public void setEarlyTerminationFees(EarlyTerminationFeeBean[] earlyTermination){
    	this.earlyTerminationFee = earlyTermination;
    }
    
    public ContractTermBean[] getContractTerms(){
    	return this.contractTerm;
    }
    public void setContractTerms(ContractTermBean[] contractTerm){
    	this.contractTerm = contractTerm;
    }
    
    public NameValuePairBean[] getPricePlanProperties(){
    	return this.pricePlanProperties;
    }
    public void setPricePlanProperties(NameValuePairBean[] pricePlanProperties){
    	this.pricePlanProperties = pricePlanProperties;
    }
    */
}