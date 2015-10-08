package com.wireless.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import com.wireless.domain.Address;

public class BillingBean implements Serializable 
{
	private static final long serialVersionUID = -8827465953162278204L;
	
	private BigInteger billingCycle;
	private Calendar billingCycleDate;
	private BigDecimal amountOver120Days;
	private BigDecimal amountOver30Days;
	private BigDecimal amountOver60Days;
	private BigDecimal amountOver90Days;
	private BigDecimal currentAmountDue;
	private BigDecimal  lastPaymentAmount;
	private Date lastPaymentDate;
	private BigDecimal nextMonthBalanceDue;
	private BigDecimal realTimeBalanceDue;
	private String areaCode;
	private String jointVentureCode;
	private String marketId;
	private Integer rateCenterId;
	private String subMarketId;
	private String[] billingOrderIdentifiers;
	private String[] billingQuoteIdentifiers;
	private boolean autoBillPayment;
	private String abp;
	private boolean billEmailDelivery;
	private Address billMailingAddress;
	private String billReminderFlag;
	private String billReportingInfo;
	private String electronicBillReporting;
	private String language;
	private BigInteger numberOfBillsToPrint;
	private String printBillReporting;
	private String billingSystem;
	
	public BillingBean()	{}
	
	public void setBillingCycle( BigInteger bigInteger )	{
		this.billingCycle = bigInteger;
	}
	
	public BigInteger getBillingCycle()	{
		return this.billingCycle;
	}
	
	public void setBillingCycleDate( Calendar billingCycleDate )	{
		this.billingCycleDate = billingCycleDate;
	}
	
	public Calendar getBillingCycleDate()	{
		return this.billingCycleDate;
	}
	
	public void setAmountOver120Days( BigDecimal amountOver120Days )	{
		this.amountOver120Days = amountOver120Days;
	}
	
	public BigDecimal getAmountOver120Days()	{
		return this.amountOver120Days;
	}
	
	public void setAmountOver30Days( BigDecimal amountOver30Days )		{
		this.amountOver30Days = amountOver30Days;
	}
	
	public BigDecimal getAmountOver30Days()	{
		return this.amountOver30Days;
	}
	
	public void setAmountOver60Days( BigDecimal amountOver60Days )		{
		this.amountOver60Days = amountOver60Days;
	}
	
	public BigDecimal getAmountOver60Days()	{
		return this.amountOver60Days;
	}
	
	public void setAmountOver90Days( BigDecimal amountOver90Days )		{
		this.amountOver90Days = amountOver90Days;
	}
	
	public BigDecimal getAmountOver90Days()	{
		return this.amountOver90Days;
	}
	
	public void setCurrentAmountDue( BigDecimal currentAmountDue )		{
		this.currentAmountDue = currentAmountDue;
	}
	
	public BigDecimal getCurrentAmountDue()		{
		return this.currentAmountDue;
	}
	
	public void setLastPaymentAmount( BigDecimal lastPaymentAmount )	{
		this.lastPaymentAmount = lastPaymentAmount;
	}
	
	public BigDecimal getLastPaymentAmount()	{
		return this.lastPaymentAmount;
	}
	
	public void setLastPaymentDate( Date lastPaymentDate )	{
		this.lastPaymentDate = lastPaymentDate;
	}
	
	public Date getLastPaymentDate()	{
		return this.lastPaymentDate;
	}
	
	public void setNextMonthBalanceDue( BigDecimal nextMonthBalanceDue )	{
		this.nextMonthBalanceDue = nextMonthBalanceDue;
	}
	
	public BigDecimal getNextMonthBalanceDue()		{
		return this.nextMonthBalanceDue;
	}
	
	public void setRealTimeBalanceDue( BigDecimal realTimeBalanceDue )		{
		this.realTimeBalanceDue = realTimeBalanceDue;
	}
	
	public BigDecimal getRealTimeBalanceDue()	{
		return this.realTimeBalanceDue;
	}
	
	public void setAreaCode( String areaCode )		{
		this.areaCode = areaCode;
	}
	
	public String getAreaCode()	{
		return this.areaCode;
	}
	
	public void setJointVentureCode( String jointVentureCode )	{
		this.jointVentureCode = jointVentureCode;
	}
	
	public String getJointVentureCode()	{
		return this.jointVentureCode;
	}
	
	public void setMarketId( String marketId )	{
		this.marketId = marketId;
	}
	
	public String getMarketId()	{
		return this.marketId;
	}
	
	public void setRateCenterId( Integer rateCenterId )	{
		this.rateCenterId = rateCenterId;
	}
	
	public Integer getRateCenterId()	{
		return this.rateCenterId;
	}
	
	public void setSubMarketId( String subMarketId )	{
		this.subMarketId = subMarketId;
	}
	
	public String getSubMarketId()		{
		return this.subMarketId;
	}
	
	public void setBillingOrderIdentifiers( String[] billingOrderIdentifiers )		{
		this.billingOrderIdentifiers = billingOrderIdentifiers;
	}
	
	public String[] getBillingOrderIdentifiers()	{
		return this.billingOrderIdentifiers;
	}
	
	public void setBillingQuoteIdentifiers( String[] billingQuoteIdentifiers )		{
		this.billingQuoteIdentifiers = billingQuoteIdentifiers;
	}
	
	public String[] getBillingQuoteIdentifiers()	{
		return this.billingQuoteIdentifiers;
	}
	
	public void setAutoBillPayment( boolean autoBillPayment )		{
		this.autoBillPayment = autoBillPayment;
		setABP( autoBillPayment );
	}
	
	public boolean getAutoBillPayment()	{
		return this.autoBillPayment;
	}
	
	public void setABP( boolean autoBillPayment )		{
		this.abp = ( autoBillPayment == false )? "N" : "Y";
	}
	
	public String getABP()	{
		return this.abp;
	}
	
	public void setBillEmailDelivery( boolean billEmailDelivery )		{
		this.billEmailDelivery = billEmailDelivery;
	}
	
	public boolean getBillEmailDelivery()	{
		return this.billEmailDelivery;
	}
	
	public void setBillMailingAddress( Address billMailingAddress )		{
		this.billMailingAddress = billMailingAddress;
	}
	
	public Address getBillMailingAddress()		{
		return this.billMailingAddress;
	}
	
	public void setBillReminderFlag( String billReminderFlag )	{
		this.billReminderFlag = billReminderFlag;
	}
	
	public String getBillReminderFlag()	{
		return this.billReminderFlag;
	}
	
	public void setBillReporting( String billReportingInfo )	{
		this.billReportingInfo = billReportingInfo;
	}
	
	public String getBillReporting()	{
		return this.billReportingInfo;
	}
	
	public void setElectronicBillReporting( String electronicBillReporting )		{
		this.electronicBillReporting = electronicBillReporting;
	}
	
	public String getElectronicBillReporting()		{
		return this.electronicBillReporting;
	}
	
	public void setLanguage( String language )		{
		this.language = language;
	}
	
	public String getLanguage()		{
		return this.language;
	}
	
	public void setNumberOfBillsToPrint( BigInteger numberOfBillsToPrint )	{
		this.numberOfBillsToPrint = numberOfBillsToPrint;
	}
	
	public BigInteger getNumberOfBillsToPrint()	{
		return this.numberOfBillsToPrint;
	}
	
	public void setPrintBillReporting( String printBillReporting )	{
		this.printBillReporting = printBillReporting;
	}
	
	public String getPrintBillReporting()		{
		return this.printBillReporting;
	}
	
	public void setBillingSystem( String billingSystem )	{
		this.billingSystem = billingSystem;
	}
	
	public String getBillingSystem()	{
		return this.billingSystem;
	}

	@Override
	public String toString() {
		return "BillingBean [billingCycle=" + billingCycle
				+ ", billingCycleDate=" + billingCycleDate
				+ ", amountOver120Days=" + amountOver120Days
				+ ", amountOver30Days=" + amountOver30Days
				+ ", amountOver60Days=" + amountOver60Days
				+ ", amountOver90Days=" + amountOver90Days
				+ ", currentAmountDue=" + currentAmountDue
				+ ", lastPaymentAmount=" + lastPaymentAmount
				+ ", lastPaymentDate=" + lastPaymentDate
				+ ", nextMonthBalanceDue=" + nextMonthBalanceDue
				+ ", realTimeBalanceDue=" + realTimeBalanceDue + ", areaCode="
				+ areaCode + ", jointVentureCode=" + jointVentureCode
				+ ", marketId=" + marketId + ", rateCenterId=" + rateCenterId
				+ ", subMarketId=" + subMarketId + ", billingOrderIdentifiers="
				+ Arrays.toString(billingOrderIdentifiers)
				+ ", billingQuoteIdentifiers="
				+ Arrays.toString(billingQuoteIdentifiers)
				+ ", autoBillPayment=" + autoBillPayment + ", abp=" + abp
				+ ", billEmailDelivery=" + billEmailDelivery
				+ ", billMailingAddress=" + billMailingAddress
				+ ", billReminderFlag=" + billReminderFlag
				+ ", billReportingInfo=" + billReportingInfo
				+ ", electronicBillReporting=" + electronicBillReporting
				+ ", language=" + language + ", numberOfBillsToPrint="
				+ numberOfBillsToPrint + ", printBillReporting="
				+ printBillReporting + ", billingSystem=" + billingSystem + "]";
	}
}
