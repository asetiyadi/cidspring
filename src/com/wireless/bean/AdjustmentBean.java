package com.wireless.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class AdjustmentBean implements Serializable 
{
	private static final long serialVersionUID = 3696211494684712985L;

	private String action;
	private String code;
	private String description;
	private BigDecimal dollarAdjustment;
	private BigDecimal percentAdjustment;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDollarAdjustment() {
		return dollarAdjustment;
	}

	public void setDollarAdjustment(BigDecimal dollarAdjustment) {
		this.dollarAdjustment = dollarAdjustment;
	}

	public BigDecimal getPercentAdjustment() {
		return percentAdjustment;
	}

	public void setPercentAdjustment(BigDecimal percentAdjustment) {
		this.percentAdjustment = percentAdjustment;
	}

	@Override
	public String toString() {
		return "AdjustmentBean [action=" + action + ", code=" + code
				+ ", description=" + description + ", dollarAdjustment="
				+ dollarAdjustment + ", percentAdjustment=" + percentAdjustment
				+ "]";
	}
	
}
