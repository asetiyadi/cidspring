package com.wireless.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccountQuoteChargesBean implements Serializable 
{
	private static final long serialVersionUID = 5729825824242150325L;

	private boolean futurePeriodBoo;
	private Date effectiveDate;
	private Date expirationDate;
	private BigDecimal chargeTotal;
	private BigDecimal taxTotal;

	public boolean isFuturePeriodBoo() {
		return futurePeriodBoo;
	}

	public void setFuturePeriodBoo(boolean futurePeriodBoo) {
		this.futurePeriodBoo = futurePeriodBoo;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

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

	@Override
	public String toString() {
		return "AccountQuoteChargesBean [futurePeriodBoo=" + futurePeriodBoo
				+ ", effectiveDate=" + effectiveDate + ", expirationDate="
				+ expirationDate + ", chargeTotal=" + chargeTotal
				+ ", taxTotal=" + taxTotal + "]";
	}
}