package com.wireless.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

public class ChargeBean implements Serializable 
{
	private static final long serialVersionUID = 6635975609677717236L;

	private String chargeItemName;
	private int chargeItemTypeId;
	private BigDecimal chargeAmount;
	private BigDecimal taxAmount;
	private boolean recurringCharge;
	private AdjustmentBean[] adjustmentBean;

	public String getChargeItemName() {
		return chargeItemName;
	}

	public void setChargeItemName(String chargeItemName) {
		this.chargeItemName = chargeItemName;
	}

	public int getChargeItemTypeId() {
		return chargeItemTypeId;
	}

	public void setChargeItemTypeId(int chargeItemTypeId) {
		this.chargeItemTypeId = chargeItemTypeId;
	}

	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public boolean isRecurringCharge() {
		return recurringCharge;
	}

	public void setRecurringCharge(boolean recurringCharge) {
		this.recurringCharge = recurringCharge;
	}

	public AdjustmentBean[] getAdjustmentBean() {
		return adjustmentBean;
	}

	public void setAdjustmentBean(AdjustmentBean[] adjustmentBean) {
		this.adjustmentBean = adjustmentBean;
	}

	@Override
	public String toString() {
		return "ChargeBean [chargeItemName=" + chargeItemName
				+ ", chargeItemTypeId=" + chargeItemTypeId + ", chargeAmount="
				+ chargeAmount + ", taxAmount=" + taxAmount
				+ ", recurringCharge=" + recurringCharge + ", adjustmentBean="
				+ Arrays.toString(adjustmentBean) + "]";
	}
	
}
