package com.wireless.tibco.parser;

import com.cricket.esp.ESP.Namespaces.Container.Public.InquireAccountResponse_xsd.InquireAccountResponseInfoAccount;
import com.wireless.domain.Account;

public class ParseInquireAccount extends ParseSuper 
{
	public static Account parseInquireAccount( InquireAccountResponseInfoAccount response )		{
		Account account = new Account();
		
		account.setAccountNumber(response.getBillingAccountNumber());
		account.setAccountType(parseAccountType(response.getAccountType()));
		account.setAccountStatus(parseAccountStatus(response.getAccountStatus()));
		account.setBilling(parseBillingInfo(response.getBillingCycle(), response.getBillingCycleDate(), response.getBillingBalance(), response.getBillingMarket(), response.getBillingOrderAndQuoteIdentifiers(), response.getBillingPreferences(), response.getBillingSystem())) ;
		account.setSolicitationContactPreference( parseSolicitationContactPreference( response.getSolicitationContactPreference() ) );
		account.setCustomer( parseCustomer(response.getCustomer()));
		account.getCustomer().setAddress( parseAddressInfo( response.getMarketAddress() ) );
		account.setSubscribers(parseSubscriber( response.getSubscriber()));
		
		//device.setAccessFeeInfo( parseEffectiveDates( response.getAccessFeeInfo() ) );
		//account.setAcountPaymentArrangementType( parseAccountPaymentArrangementType( response.getAccountPaymentArrangementType() ) );
		//account.setAccountProfileStatus( parseAccountProfileStatus( response.getAccountProfileStatus() ) );
		
		//account.setAccountStatusReasonCode( response.getAccountStatusReasonCode() );
		
		//account.setAdjustments( parseAdjustment( response.getAdjustments() ) );
		//account.setAuthorizedBillingAccountUsers( response.getAuthorizedBillingAccountUsers() );
		
		if(response.getCreditRiskCodes() != null)
		{
			account.setCreditRiskCodes( parseCreditRiskCodes(response.getCreditRiskCodes()));
		}
		
		
		//account.setExternalWholesaleAccountNumber( response.getExternalWholesaleAccountNumber() );
		
		//account.setNotes( response.getNotes() );
		
		
		//account.setTaxExemption( parseTaxExemption( response.getTaxExemption() ) );
		
		return account;
	}
}
