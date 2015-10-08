package com.wireless.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class HotBillChargesBean implements Serializable 
{
	private static final long serialVersionUID = 6847942272961411369L;

	private boolean futurePeriodBoo;
	private Date effectiveDate;
	private Date expirationDate;
	private BigDecimal chargeTotal;
	private BigDecimal taxTotal;
	private AccountQuoteChargesBean[] accountQuoteChargesBean;
	private SubscriberQuoteChargesBean[] subscriberQuoteCharges;

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

	public AccountQuoteChargesBean[] getAccountQuoteChargesBean() {
		return accountQuoteChargesBean;
	}

	public void setAccountQuoteChargesBean(
			AccountQuoteChargesBean[] accountQuoteChargesBean) {
		this.accountQuoteChargesBean = accountQuoteChargesBean;
	}

	public SubscriberQuoteChargesBean[] getSubscriberQuoteCharges() {
		return subscriberQuoteCharges;
	}

	public void setSubscriberQuoteCharges(
			SubscriberQuoteChargesBean[] subscriberQuoteCharges) {
		this.subscriberQuoteCharges = subscriberQuoteCharges;
	}

	@Override
	public String toString() {
		return "HotBillChargesBean [futurePeriodBoo=" + futurePeriodBoo
				+ ", effectiveDate=" + effectiveDate + ", expirationDate="
				+ expirationDate + ", chargeTotal=" + chargeTotal
				+ ", taxTotal=" + taxTotal + ", accountQuoteChargesBean="
				+ Arrays.toString(accountQuoteChargesBean)
				+ ", subscriberQuoteCharges="
				+ Arrays.toString(subscriberQuoteCharges) + "]";
	}
}
