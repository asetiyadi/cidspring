package com.wireless.bean;

public class FeatureBean {

	private String featureCode;
	private String featureDescription;
	
	public FeatureBean(){
	}
	
	/**
     * Gets the featureCode value for this OfferingFeaturesInfo.
     * 
     * @return featureCode   * The Feature Code as defined in the billing
     * 						system
     */
    public java.lang.String getFeatureCode() {
        return featureCode;
    }


    /**
     * Sets the featureCode value for this OfferingFeaturesInfo.
     * 
     * @param featureCode   * The Feature Code as defined in the billing
     * 						system
     */
    public void setFeatureCode(java.lang.String featureCode) {
        this.featureCode = featureCode;
    }


    /**
     * Gets the featureDescription value for this OfferingFeaturesInfo.
     * 
     * @return featureDescription   * The Feature Description.
     */
    public java.lang.String getFeatureDescription() {
        return featureDescription;
    }


    /**
     * Sets the featureDescription value for this OfferingFeaturesInfo.
     * 
     * @param featureDescription   * The Feature Description.
     */
    public void setFeatureDescription(java.lang.String featureDescription) {
        this.featureDescription = featureDescription;
    }
	
}
