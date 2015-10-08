package com.wireless.tibco.parser;

import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AccountQuoteChargesInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AdjustmentInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AdjustmentInfoPriceAdjustment;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingQuoteDetailsInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingQuoteResponseInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.ChargeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.EffectiveDatesInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.HotBillChargesInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.MobileDeviceIdentifierInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.RecurringChargeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.SubscriberQuoteChargesInfo;
import com.wireless.bean.AccountQuoteChargesBean;
import com.wireless.bean.AdjustmentBean;
import com.wireless.bean.BillingQuoteBean;
import com.wireless.bean.BillingQuoteDetailsBean;
import com.wireless.bean.ChargeBean;
import com.wireless.bean.HotBillChargesBean;
import com.wireless.bean.SubscriberQuoteChargesBean;

public class ParseCreateActivationQuote	{// extends ParseSuper {

	public static BillingQuoteBean parseCreateActivationQuote( BillingQuoteResponseInfo billingQuote )	{
		BillingQuoteBean billingQuoteBean = new BillingQuoteBean();
		
		billingQuoteBean.setBillingQuoteId( billingQuote.getBillingQuoteId() );
		billingQuoteBean.setCustomerId(billingQuote.getCustomerId());
		billingQuoteBean.setBillingAccountNumber(billingQuote.getBillingAccountNumber());
		
		
		//billingQuoteBean.setBillingQuoteDetailsBean( parseBillingQuoteDetails( billingQuote.getBillingQuoteDetails() ));
		billingQuoteBean.setHotBillCharges(parseHotBillCharges(billingQuote.getHotBillCharges()));
		
		return billingQuoteBean;
	}
	/*
	private static BillingQuoteDetailsBean parseBillingQuoteDetails( BillingQuoteDetailsInfo billingQuoteDetailsInfo )	{
		BillingQuoteDetailsBean quoteDetails = null;
		
		if( billingQuoteDetailsInfo != null )	{
			quoteDetails = new BillingQuoteDetailsBean();
			
			RecurringChargeInfo chargeInfo = billingQuoteDetailsInfo.getTotalRecurringCharges();
			quoteDetails.setRecurringChargeAmount( chargeInfo.getAmount().floatValue() );
			quoteDetails.setTotalRecurringChargePeriod(chargeInfo.getChargePeriod() );
			quoteDetails.setTotalRecurringChargePeriodUom(chargeInfo.getChargePeriodUom().getValue() );
			
			RecurringChargeInfo savingInfo = billingQuoteDetailsInfo.getTotalRecurringSavings();
			quoteDetails.setRecurringSavingPeriod( savingInfo.getChargePeriod() );
			quoteDetails.setRecurringSavingPeriodUom( savingInfo.getChargePeriodUom().getValue() );
			
			quoteDetails.setOneTimeCharge( billingQuoteDetailsInfo.getOneTimeCharge().intValue() );
			quoteDetails.setNextBillDate( billingQuoteDetailsInfo.getNextBillDate().getTime() );
		}
		
		return quoteDetails;
	}
	*/
	private static HotBillChargesBean[] parseHotBillCharges(HotBillChargesInfo[] hotBillChargesInfo)
	{
		HotBillChargesBean[] arrHotBillCharges = new HotBillChargesBean[hotBillChargesInfo.length];
		
		for(int x=0; x < hotBillChargesInfo.length; x++)
		{
			HotBillChargesInfo temp = hotBillChargesInfo[x];
			HotBillChargesBean hbc = new HotBillChargesBean();
			
			hbc.setFuturePeriodBoo(temp.isFuturePeriodBoo());
			
			EffectiveDatesInfo effDate = temp.getEffectiveDate();
			hbc.setEffectiveDate(effDate.getEffectiveDate());
			hbc.setExpirationDate(effDate.getExpirationDate());
			
			hbc.setChargeTotal(temp.getChargeTotal());
			hbc.setTaxTotal(temp.getTaxTotal());
			
			hbc.setAccountQuoteChargesBean(parseAccountQuoteCharges(temp.getAccountQuoteCharges()));
			hbc.setSubscriberQuoteCharges(parseSubscriberQuoteCharges(temp.getSubscriberQuoteCharges()));
			
			arrHotBillCharges[x] = hbc;
		}
		
		return arrHotBillCharges;
	}
	
	private static AccountQuoteChargesBean[] parseAccountQuoteCharges(AccountQuoteChargesInfo[] accountQuoteChargesInfo)
	{
		AccountQuoteChargesBean[] arrAccountQuoteCharges = new AccountQuoteChargesBean[accountQuoteChargesInfo.length];
		
		for(int x=0; x < accountQuoteChargesInfo.length; x++)
		{
			AccountQuoteChargesInfo temp = accountQuoteChargesInfo[x];
			AccountQuoteChargesBean qcb = new AccountQuoteChargesBean();
			
			qcb.setFuturePeriodBoo(temp.isFuturePeriodBoo());
			
			EffectiveDatesInfo effDate = temp.getEffectiveDate();
			qcb.setEffectiveDate(effDate.getEffectiveDate());
			qcb.setExpirationDate(effDate.getExpirationDate());
			
			qcb.setChargeTotal(temp.getChargeTotal());
			qcb.setTaxTotal(temp.getTaxTotal());
			
			arrAccountQuoteCharges[x] = qcb;
		}
		
		return arrAccountQuoteCharges;
	}
	
	private static SubscriberQuoteChargesBean[] parseSubscriberQuoteCharges(SubscriberQuoteChargesInfo[] subscriberQuoteChargesInfo)
	{
		SubscriberQuoteChargesBean[] arrSubscriberQuoteCharges = new SubscriberQuoteChargesBean[subscriberQuoteChargesInfo.length];
		
		for(int x=0; x < subscriberQuoteChargesInfo.length; x++)
		{
			SubscriberQuoteChargesInfo temp = subscriberQuoteChargesInfo[x];
			SubscriberQuoteChargesBean qcb = new SubscriberQuoteChargesBean();
			
			qcb.setChargeTotal(temp.getChargeTotal());
			qcb.setTaxTotal(temp.getTaxTotal());
			qcb.setMdn(temp.getMdn());
			qcb.setMin(temp.getMin());
			
			MobileDeviceIdentifierInfo device = temp.getEquipmentIdentifier();
			if(device.getEsn() != null && device.getEsn().length() > 0 )
			{
				qcb.setDeviceId(device.getEsn());
			}
			else if(device.getMeid() != null && device.getMeid().length() > 0 )
			{
				qcb.setDeviceId(device.getMeid());
			}
			else if(device.getImei() != null && device.getImei().length() > 0 )
			{
				qcb.setDeviceId(device.getImei());
			}
			
			qcb.setSubscriberCharges(parseSubscriberCharges(temp.getSubscriberCharges()));
			
			arrSubscriberQuoteCharges[x] = qcb;
		}
		
		return arrSubscriberQuoteCharges;
	}
	
	private static ChargeBean[] parseSubscriberCharges(ChargeInfo[] chargeInfo)
	{
		ChargeBean[] arrChargeBean = new ChargeBean[chargeInfo.length];
		
		for(int x=0; x < chargeInfo.length; x++)
		{
			ChargeInfo temp = chargeInfo[x];
			ChargeBean cb = new ChargeBean();
			
			cb.setChargeItemName(temp.getChargeItemName());
			cb.setChargeItemTypeId(temp.getChargeItemTypeId());
			cb.setChargeAmount(temp.getChargeAmount());
			cb.setTaxAmount(temp.getTaxAmount());
			cb.setRecurringCharge(temp.isRecurringCharge());
			
			if(temp.getAdjustmentInfo() != null)
			{
				cb.setAdjustmentBean(parseAdjustment(temp.getAdjustmentInfo()));
			}
			
			arrChargeBean[x] = cb;
		}
		
		return arrChargeBean;
	}
	
	private static AdjustmentBean[] parseAdjustment(AdjustmentInfo[] adjustmentInfo)
	{
		AdjustmentBean[] arrAdjustment = new AdjustmentBean[adjustmentInfo.length];
		
		for(int x=0; x < adjustmentInfo.length; x++)
		{
			AdjustmentInfo temp = adjustmentInfo[x];
			AdjustmentBean ab = new AdjustmentBean();
			
			ab.setAction(temp.getAction().toString());
			ab.setCode(temp.getCode());
			ab.setDescription(temp.getDescription());
			
			AdjustmentInfoPriceAdjustment price = temp.getPriceAdjustment();
			if(price.getDollarAdjustment() != null)
			{
				ab.setDollarAdjustment(price.getDollarAdjustment());
			}
			
			if(price.getPercentAdjustment() != null)
			{
				ab.setPercentAdjustment(price.getPercentAdjustment());
			}
			
			arrAdjustment[x] = ab;
		}
		
		return arrAdjustment;
	}
}
