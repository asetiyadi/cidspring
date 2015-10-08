package com.wireless.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

public class SubscriberQuoteChargesBean implements Serializable 
{
	private static final long serialVersionUID = 4388651280299839351L;

	private BigDecimal chargeTotal;
	private BigDecimal taxTotal;
	private String mdn;
	private String min;
	private String deviceId;
	private ChargeBean[] subscriberCharges;

	public BigDecimal getChargeTotal() {
		return chargeTotal;
	}

	public void setChargeTotal(BigDecimal chargeTotal) {
		this.chargeTotal = chargeTotal;
	}

	public BigDecimal getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(BigDecimal taxTotal) {
		this.taxTotal = taxTotal;
	}

	public String getMdn() {
		return mdn;
	}

	public void setMdn(String mdn) {
		this.mdn = mdn;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public ChargeBean[] getSubscriberCharges() {
		return subscriberCharges;
	}

	public void setSubscriberCharges(ChargeBean[] subscriberCharges) {
		this.subscriberCharges = subscriberCharges;
	}

	@Override
	public String toString() {
		return "SubscriberQuoteChargesBean [chargeTotal=" + chargeTotal
				+ ", taxTotal=" + taxTotal + ", mdn=" + mdn + ", min=" + min
				+ ", deviceId=" + deviceId + ", subscriberCharges="
				+ Arrays.toString(subscriberCharges) + "]";
	}
	
}
