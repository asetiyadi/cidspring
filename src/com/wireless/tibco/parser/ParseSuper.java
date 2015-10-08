/**
 * This class contains ESP returned object parsing
 *   - INPUT:  ESP object types
 *   - OUTPUT:  Custom object that are useful for Front End clients
 */
package com.wireless.tibco.parser;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import org.apache.axis.types.PositiveInteger;

import com.cricket.esp.ESP.Namespaces.Container.Public.InquireAccountResponse_xsd.InquireAccountResponseInfoAccountBillingOrderAndQuoteIdentifiers;
import com.cricket.esp.ESP.Namespaces.Container.Public.InquireAccountResponse_xsd.InquireAccountResponseInfoAccountCustomer;
import com.cricket.esp.ESP.Namespaces.Container.Public.InquireAccountResponse_xsd.InquireAccountResponseInfoAccountSubscriber;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AccountBalanceDetailsInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AccountPaymentArrangementTypeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AccountProfileStatusInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AccountStatusInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AccountTypeIndicatorInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.ActionInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressStateInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressStreetInfoStreetDirection;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressStreetInfoStreetTrailingDirection;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressStreetInfoStreetType;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AddressTypeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AdjustmentInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.AdjustmentInfoPriceAdjustment;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillReportingInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingMarketInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingPreferencesInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingPreferencesInfoElectronicBillReporting;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingPreferencesInfoPrintBillReporting;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BillingSourceSystemIdInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BundledOfferingsInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.CreditRiskCodesInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.CustomerTypeInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.DeviceInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.EffectiveDatesInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.EmailInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.LanguagePreferenceInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.NameBusinessInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.OfferingFeaturesInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.PricePlanInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.SolicitationContactPreferenceInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.UnitInfo;
import com.wireless.bean.AdjustmentBean;
import com.wireless.bean.BillingBean;
import com.wireless.bean.BundledOfferingBean;
import com.wireless.bean.EffectiveDatesBean;
import com.wireless.bean.FeatureBean;
import com.wireless.bean.PricePlanBean;
import com.wireless.domain.Address;
import com.wireless.domain.Customer;
import com.wireless.domain.Device;
import com.wireless.domain.Subscriber;


public class ParseSuper {
	
	/**
	 * This method is to check if object being passed is type of boolean
	 * By default the value is "false"
	 * 
	 * @param obj Object
	 * @return boolean
	 */
	protected static boolean isBoolean( Object obj )	{
		boolean returnBoolean = false;
		
		if( obj instanceof Boolean )
			returnBoolean = ((Boolean) obj).booleanValue();
		
		return returnBoolean;
	}
	
	/**
	 * This method is to check if object being passed is not null
	 * 
	 * @param obj Object
	 * @return String
	 */
	protected static String convertNullToString( Object obj )	{
		String returnStr = "";
		
		if( obj != null ) 	
			returnStr = obj.toString();
		
		return returnStr;
	}
	
	/**
	 * This method is to convert a positive integer to an integer 
	 * 
	 * @param pi PositiveInteger
	 * @return Integer
	 */
	protected static Integer convertPositiveIntegerToInteger( PositiveInteger pi )	{
		if( pi != null ){
			return Integer.parseInt( pi.toString() );
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param effectiveDatesInfo Array of ESP EffectiveDatesInfo
	 * @return Array of {@link com.cricket.cid.bean.info.EffectiveDatesBean}
	 */
	protected static EffectiveDatesBean[] parseEffectiveDates( EffectiveDatesInfo[] effectiveDatesInfo )		{
		EffectiveDatesBean[] effectiveDates = null;
		
		if( effectiveDatesInfo != null )	{
			int cntEffectiveDatesInfo = effectiveDatesInfo.length;
			
			effectiveDates =  new EffectiveDatesBean[ cntEffectiveDatesInfo ];
			
			for( int i=0; i<cntEffectiveDatesInfo; i++ )	{
				effectiveDates[i] = new EffectiveDatesBean();
				effectiveDates[ i ].setEffectiveDate( effectiveDatesInfo[ i ].getEffectiveDate() );
				effectiveDates[ i ].setExpirationDate( effectiveDatesInfo[ i ].getExpirationDate() );
			}
		}
		
		return effectiveDates;
	}
	
	/**
	 * 
	 * @param effectiveDatesInfo ESP EffectiveDatesInfo
	 * @return {@link com.cricket.cid.bean.info.EffectiveDatesBean}
	 */
	protected static EffectiveDatesBean parseEffectiveDates( EffectiveDatesInfo effectiveDatesInfo )		{
		EffectiveDatesBean effectiveDates = null;
		
		if( effectiveDatesInfo != null )	{
			effectiveDates =  new EffectiveDatesBean();
			
			effectiveDates.setEffectiveDate( effectiveDatesInfo.getEffectiveDate() );
			effectiveDates.setExpirationDate( effectiveDatesInfo.getExpirationDate() );
		}
		
		return effectiveDates;
	}
	
	/**
	 * 
	 * @param accountPaymentArrangementTypeInfo ESP AccountPaymentArrangementTypeInfo
	 * @return String
	 */
	protected static String parseAccountPaymentArrangementType( AccountPaymentArrangementTypeInfo accountPaymentArrangementTypeInfo )		{
		String arrangementType = "";
		
		if( accountPaymentArrangementTypeInfo != null )	
			arrangementType = accountPaymentArrangementTypeInfo.toString();
		
		return arrangementType;
	}
	
	/**
	 * 
	 * @param accountProfileStatusInfo ESP AccountProfileStatusInfo
	 * @return String
	 */
	protected static String parseAccountProfileStatus( AccountProfileStatusInfo accountProfileStatusInfo )	{
		String accountProfileStatus = "";
		
		if( accountProfileStatusInfo != null )	{
			accountProfileStatus = accountProfileStatusInfo.toString();
		}
		return accountProfileStatus;
	}
	
	/**
	 * 
	 * @param accountStatusInfo ESP AccountStatusInfo
	 * @return String
	 */
	protected static String parseAccountStatus( AccountStatusInfo accountStatusInfo )		{
		String accountStatus = "";
		
		if( accountStatusInfo != null )	
			accountStatus = accountStatusInfo.toString();
		
		return accountStatus;
	}
	
	/**
	 * 
	 * @param accountTypeIndicatorInfo ESP AccountTypeIndicatorInfo
	 * @return String
	 */
	protected static String parseAccountType( AccountTypeIndicatorInfo accountTypeIndicatorInfo )	{
		String accountTypeIndicator = "";
		
		if( accountTypeIndicatorInfo != null )
			accountTypeIndicator = accountTypeIndicatorInfo.toString();
		
		return accountTypeIndicator;
	}
	
	/**
	 * 
	 * @param adjustmentInfo ESP AdjustmentInfo
	 * @return Array of {@link com.cricket.cid.bean.info.AdjustmentBean}
	 */
	protected static AdjustmentBean[] parseAdjustment(AdjustmentInfo[] adjustmentInfo )	{
		AdjustmentBean[] adjustmentBean = null;
		
		if( adjustmentInfo != null )		{
			int cntAdjustmentInfo = adjustmentInfo.length;
			
			adjustmentBean = new AdjustmentBean[ cntAdjustmentInfo ];
			
			for( int i=0; i<cntAdjustmentInfo; i++ )	{
				adjustmentBean[ i ].setAction( parseAction( adjustmentInfo[ i ].getAction() ) );
				adjustmentBean[ i ].setCode( adjustmentInfo[ i ].getCode() );
				adjustmentBean[ i ].setDescription( adjustmentInfo[ i ].getDescription() );
				/*
				adjustmentBean[ i ].setEffectiveDates( parseEffectiveDates( adjustmentInfo[ i ].getEffectiveDates() ) );
				adjustmentBean[ i ].setDollarAdjustmentInfo( parseDollarAdjustment( adjustmentInfo[ i ].getPriceAdjustment() ) );
				adjustmentBean[ i ].setPercentAdjustmentInfo( parsePercentAdjustment( adjustmentInfo[ i ].getPriceAdjustment() ) );
				*/
			}
		}
		
		return adjustmentBean;
	}
	
	/**
	 * 
	 * @param actionInfo ESP ActionInfo
	 * @return String
	 */
	protected static String parseAction( ActionInfo actionInfo )		{
		String action = "";
		
		if( actionInfo != null )	
			action = actionInfo.toString() ;
		
		return action;
	}
	
	/**
	 * 
	 * @param adjustmentInfoPriceAdjustment ESP AdjustmentInfoPriceAdjustment
	 * @return BigDecimal
	 */
	protected static BigDecimal parseDollarAdjustment( AdjustmentInfoPriceAdjustment adjustmentInfoPriceAdjustment )	{
		BigDecimal dollarAdjustment = null;
		
		if( adjustmentInfoPriceAdjustment != null )	
			dollarAdjustment = adjustmentInfoPriceAdjustment.getDollarAdjustment();
		
		return dollarAdjustment;
	}
	
	/**
	 * 
	 * @param adjustmentInfoPriceAdjustment ESP AdjustmentInfoPriceAdjustment
	 * @return BigDecimal
	 */
	protected static BigDecimal parsePercentAdjustment( AdjustmentInfoPriceAdjustment adjustmentInfoPriceAdjustment )	{
		BigDecimal percentAdjusment = null;
		
		if( adjustmentInfoPriceAdjustment != null )	
			percentAdjusment = adjustmentInfoPriceAdjustment.getPercentAdjustment();

		return percentAdjusment;
	}
	
	/**
	 * 
	 * @param billingCycle BigInteger
	 * @param billingCycleDate Calendar
	 * @param accountBalanceDetailsInfo ESP AccountBalanceDetailsInfo
	 * @param billingMarketInfo ESP BillingMarketInfo
	 * @param inquireAccountResponseInfoAccountBillingOrderAndQuoteIdentifiers ESP InquireAccountResponseInfoAccountBillingOrderAndQuoteIdentifiers
	 * @param billingPreferencesInfo ESP BillingPreferencesInfo
	 * @param billingSourceSystemIdInfo ESP BillingSourceSystemIdInfo
	 * @return {@link com.cricket.cid.bean.BillingBean}
	 */
	protected static BillingBean parseBillingInfo( 
			BigInteger billingCycle,
			Calendar billingCycleDate,
			AccountBalanceDetailsInfo accountBalanceDetailsInfo,
			BillingMarketInfo billingMarketInfo,
			InquireAccountResponseInfoAccountBillingOrderAndQuoteIdentifiers  inquireAccountResponseInfoAccountBillingOrderAndQuoteIdentifiers,
			BillingPreferencesInfo  billingPreferencesInfo,
			BillingSourceSystemIdInfo billingSourceSystemIdInfo )		{
		
		BillingBean billingBean = null;
		
		if( accountBalanceDetailsInfo != null )	{
			billingBean =  new BillingBean();
			
			billingBean.setBillingCycle( billingCycle );
			billingBean.setBillingCycleDate( billingCycleDate );
			billingBean.setAmountOver120Days( accountBalanceDetailsInfo.getAmountOver120Days() );
			billingBean.setAmountOver30Days( accountBalanceDetailsInfo.getAmountOver30Days() );
			billingBean.setAmountOver60Days( accountBalanceDetailsInfo.getAmountOver60Days() );
			billingBean.setAmountOver90Days( accountBalanceDetailsInfo.getAmountOver90Days() );
			billingBean.setCurrentAmountDue( accountBalanceDetailsInfo.getCurrentAmountDue() );
			billingBean.setNextMonthBalanceDue( accountBalanceDetailsInfo.getNextMonthBalanceDue() );
			billingBean.setRealTimeBalanceDue( accountBalanceDetailsInfo.getRealTimeBalanceDue() );
			billingBean.setBillingSystem( parseBillingSystem( billingSourceSystemIdInfo ) );

			if( accountBalanceDetailsInfo.getLastPayment() != null )	{
				billingBean.setLastPaymentAmount( accountBalanceDetailsInfo.getLastPayment().getLastPaymentAmount() );
				billingBean.setLastPaymentDate( accountBalanceDetailsInfo.getLastPayment().getLastPaymentDate() );
			}
			
			if( billingMarketInfo != null )	{
				billingBean.setAreaCode( billingMarketInfo.getAreaCode() );
				billingBean.setJointVentureCode(  billingMarketInfo.getJointVentureCode() );
				billingBean.setMarketId( billingMarketInfo.getMarketId() );
				billingBean.setRateCenterId( convertPositiveIntegerToInteger( billingMarketInfo.getRateCenterId() ) ) ;
				billingBean.setSubMarketId(  billingMarketInfo.getSubMarketId() );
			}

			if( inquireAccountResponseInfoAccountBillingOrderAndQuoteIdentifiers != null )	{
				billingBean.setBillingOrderIdentifiers( inquireAccountResponseInfoAccountBillingOrderAndQuoteIdentifiers.getBillingOrderIdentifiers() );
				billingBean.setBillingQuoteIdentifiers( inquireAccountResponseInfoAccountBillingOrderAndQuoteIdentifiers.getBillingQuoteIdentifiers() );
			}
			
			if( billingPreferencesInfo != null )	{
				billingBean.setAutoBillPayment(  isBoolean( billingPreferencesInfo.getAutoBillPayment() ) );
				billingBean.setBillEmailDelivery(  isBoolean( billingPreferencesInfo.getBillEmailDelivery() ) ); 
				billingBean.setBillReminderFlag( billingPreferencesInfo.getBillReminderFlag() );
				billingBean.setNumberOfBillsToPrint( billingPreferencesInfo.getNumberOfBillsToPrint() );
				billingBean.setBillReporting( parseBillReporting( billingPreferencesInfo.getBillReporting() ));
				billingBean.setElectronicBillReporting( parseElectronicBillReporting( billingPreferencesInfo.getElectronicBillReporting() ) );
				billingBean.setLanguage( parseLanguage( billingPreferencesInfo.getLanguage() ) );
				billingBean.setPrintBillReporting( parsePrintBillReporting( billingPreferencesInfo.getPrintBillReporting() ) );
				
				//** Currently not used by Front End client **//
				//billingPreferencesInfo.setBillMailingAddress( parseAddressInfo( accountBillingPreferencesInfo.getBillMailingAddress() ));
			}
		}
		
		return billingBean;
	}
	
	/**
	 * 
	 * @param billReportingInfo ESP BillReportingInfo
	 * @return String
	 */
	protected static String parseBillReporting( BillReportingInfo billReportingInfo )	{
		String billReporting = "";
		
		if( billReportingInfo != null )	
			billReporting = billReportingInfo.toString();
		
		return billReporting;
	}
	
	/**
	 * 
	 * @param billingPreferencesInfoElectronicBillReporting ESP BillingPreferencesInfoElectronicBillReporting
	 * @return String
	 */
	protected static String parseElectronicBillReporting( BillingPreferencesInfoElectronicBillReporting billingPreferencesInfoElectronicBillReporting )	{
		String eBillReporting = "";
		
		if( billingPreferencesInfoElectronicBillReporting!= null && 
				billingPreferencesInfoElectronicBillReporting.getAction() != null )	
			eBillReporting = parseAction( billingPreferencesInfoElectronicBillReporting.getAction() );
		
		return eBillReporting;
	}
	
	/**
	 * 
	 * @param languagePreferenceInfo ESP LanguagePreferenceInfo
	 * @return String
	 */
	protected static String parseLanguage( LanguagePreferenceInfo languagePreferenceInfo )	{
		String language = "";
		
		if( languagePreferenceInfo != null )
			language = languagePreferenceInfo.toString();
		
		return language;
	}
	
	/**
	 * 
	 * @param billingPreferencesInfoPrintBillReporting ESP BillingPreferencesInfoPrintBillReporting
	 * @return String
	 */
	protected static String parsePrintBillReporting( BillingPreferencesInfoPrintBillReporting billingPreferencesInfoPrintBillReporting )	{
		String printBillReporting = "";
		
		if( billingPreferencesInfoPrintBillReporting != null )		
			printBillReporting = parseAction( billingPreferencesInfoPrintBillReporting.getAction() );
		
		return printBillReporting;
	}
	
	/**
	 * 
	 * @param billingSourceSystemIdInfo ESP BillingSourceSystemIdInfo
	 * @return String
	 */
	protected static String parseBillingSystem( BillingSourceSystemIdInfo billingSourceSystemIdInfo )	{
		String billingSystem = "";
		
		if( billingSourceSystemIdInfo != null )
			billingSystem = billingSourceSystemIdInfo.toString();
		
		return billingSystem;
	}
	
	/**
	 * 
	 * @param accountCreditRiskCodesInfo ESP AccountCreditRiskCodesInfo
	 * @return Array of String
	 */
	protected static String[] parseCreditRiskCodes( CreditRiskCodesInfo accountCreditRiskCodesInfo )	{
		String[] riskCodes = new String[ 3 ];
		
		if( accountCreditRiskCodesInfo != null )		{
			riskCodes[ 0 ] = convertNullToString( accountCreditRiskCodesInfo.getRiskCode1() );
			riskCodes[ 1 ] = convertNullToString( accountCreditRiskCodesInfo.getRiskCode2() );
			riskCodes[ 2 ] = convertNullToString( accountCreditRiskCodesInfo.getRiskCode3() );
		}
		
		return riskCodes;
	}
	
	/**
	 * 
	 * @param inquireAccountResponseInfoAccountCustomer ESP InquireAccountResponseInfoAccountCustomer
	 * @return {@link com.cricket.cid.bean.CustomerBean}
	 */
	protected static Customer parseCustomer( InquireAccountResponseInfoAccountCustomer inquireAccountResponseInfoAccountCustomer )	{
		Customer customer = null;
		
		if( inquireAccountResponseInfoAccountCustomer != null )		{
			customer = new Customer();
			
			customer.setAddress( parseAddressInfo( inquireAccountResponseInfoAccountCustomer.getBillingAddress() ) );
			customer.setId( inquireAccountResponseInfoAccountCustomer.getCustomerId() );
			//customer.setName( parseNameInfo( inquireAccountResponseInfoAccountCustomer.getName() ) );
			customer.setFirstName(inquireAccountResponseInfoAccountCustomer.getName().getFirstName());
			customer.setLastName(inquireAccountResponseInfoAccountCustomer.getName().getLastName());
			
			if(inquireAccountResponseInfoAccountCustomer.getPhone() != null)
			{
				customer.setHomePhone(inquireAccountResponseInfoAccountCustomer.getPhone().getHomePhone());
				customer.setWorkPhone(inquireAccountResponseInfoAccountCustomer.getPhone().getWorkPhone());
			}
			
			if(inquireAccountResponseInfoAccountCustomer.getBusinessName() != null)
			{
				customer.setBusinessName(parseBusinessName(inquireAccountResponseInfoAccountCustomer.getBusinessName()));
			}
			
			customer.setCustomerType(parseCustomerType(inquireAccountResponseInfoAccountCustomer.getCustomerType()).charAt(0));
			
			if(inquireAccountResponseInfoAccountCustomer.getEmail() != null)
			{
				customer.setEmail( parseEmail(inquireAccountResponseInfoAccountCustomer.getEmail()));
			}
			
			customer.setDob(inquireAccountResponseInfoAccountCustomer.getIdentity().getBirth().getDateOfBirth());
			
			if(inquireAccountResponseInfoAccountCustomer.getIdentity().getSocialSecurityNumber() != null)
			{
				customer.setSsn(inquireAccountResponseInfoAccountCustomer.getIdentity().getSocialSecurityNumber());
			}
		}

		return customer;
	}
	
	/**
	 * 
	 * @param addressInfo ESP AddressInfo
	 * @return {@link com.cricket.cid.bean.info.AddressBean}
	 */
	protected static Address parseAddressInfo( AddressInfo addressInfo )	{
		Address addressBean = null;
		
		if( addressInfo != null )	{
			addressBean = new Address();
			
			addressBean.setAddress1( addressInfo.getAddressLine1() );
			//addressBean.setAddressLine2( addressInfo.getAddressLine2() );
			//addressBean.setAddressType( parseAddressType( addressInfo.getAddressType() ) );
			addressBean.setCity( addressInfo.getCity() );
			//addressBean.setCountry( addressInfo.getCountry() );
			addressBean.setState( parseState( addressInfo.getState() ) );
			
			if( addressInfo.getZip() != null )		{
				addressBean.setZip( addressInfo.getZip().getZipCode() );
			}
			
		}
		
		return addressBean;
	}
	
	/**
	 * 
	 * @param addressTypeInfo ESP AddressTypeInfo
	 * @return String
	 */
	protected static String parseAddressType( AddressTypeInfo addressTypeInfo )	{
		String addressType = "";
		
		if( addressTypeInfo != null )	
			addressType = addressTypeInfo.toString();
		
		return addressType;
	}
	
	/**
	 * 
	 * @param addressStateInfo ESP AddressStateInfo
	 * @return String
	 */
	protected static String parseState( AddressStateInfo addressStateInfo )	{
		String state = "";
		
		if( addressStateInfo != null )	
			state = addressStateInfo.toString();
		
		return state;
	}
	
	/**
	 * 
	 * @param addressStreetInfoStreetDirection ESP AddressStreetInfoStreetDirection
	 * @return String
	 */
	protected static String parseStreetDirection( AddressStreetInfoStreetDirection addressStreetInfoStreetDirection)	{
		String streetDirection = null;
		
		if( addressStreetInfoStreetDirection != null )	
			streetDirection = addressStreetInfoStreetDirection.toString();
		
		return streetDirection;
	}
	
	/**
	 * 
	 * @param addressStreetInfoStreetTrailingDirection ESP AddressStreetInfoStreetTrailingDirection
	 * @return String
	 */
	protected static String parseStreetTrailingDirection( AddressStreetInfoStreetTrailingDirection addressStreetInfoStreetTrailingDirection )	{
		String streetTrailingDirection = "";
		
		if( addressStreetInfoStreetTrailingDirection != null )
			streetTrailingDirection = addressStreetInfoStreetTrailingDirection.getValue();
		
		return streetTrailingDirection;
	}
	
	/**
	 * 
	 * @param addressStreetInfoStreetType ESP AddressStreetInfoStreetType
	 * @return String
	 */
	protected static String parseStreetType( AddressStreetInfoStreetType addressStreetInfoStreetType )	{
		String streetType = "";
		
		if( addressStreetInfoStreetType != null )	
			streetType = addressStreetInfoStreetType.toString();
		
		return streetType;
	}
	
	/**
	 * 
	 * @param unitInfo ESP UnitInfo
	 * @return String
	 */
	protected static String parseUnitDesignator( UnitInfo unitInfo )		{
		String unitDesignator = "";
		
		if( unitInfo != null )	{
			if( unitInfo.getUnitDesignator() != null )		{
				unitDesignator = unitInfo.getUnitDesignator().toString();
			}
		}
		
		return unitDesignator;
	}
	
	/**
	 * 
	 * @param unitInfo ESP UnitInfo
	 * @return String
	 */
	protected static String parseUnitNumber( UnitInfo unitInfo )		{
		String unitNumber = null;
		
		if( unitInfo != null )
			unitNumber = unitInfo.getUnitNumber();
		
		return unitNumber;
	}
	
	/**
	 * 
	 * @param nameBusinessInfo ESP NameBusinessInfo
	 * @return String
	 */
	protected static String parseBusinessName( NameBusinessInfo nameBusinessInfo )	{
		String businessName = "";
		
		if( nameBusinessInfo != null )
			businessName = nameBusinessInfo.getBusinessName();
		
		return businessName;
	}
	
	/**
	 * 
	 * @param customerTypeInfo ESP CustomerTypeInfo
	 * @return String
	 */
	protected static String parseCustomerType( CustomerTypeInfo customerTypeInfo )	{
		String customerType = "";
		
		if( customerTypeInfo != null )	
			customerType = customerTypeInfo.toString();
		
		return customerType;
	}
	
	/**
	 * 
	 * @param emailInfo ESP EmailInfo
	 * @return String
	 */
	protected static String parseEmail( EmailInfo emailInfo )	{
		String email = "";
		
		if( emailInfo != null )	
			email =  emailInfo.getEmailAddress();
		
		return email;
	}
	
	/**
	 * 
	 * @param inquireAccountResponseInfoAccountCustomerIdentity ESP InquireAccountResponseInfoAccountCustomerIdentity
	 * @return Date
	 */
	/*protected static IdentityBean parseIdentity( InquireAccountResponseInfoAccountCustomerIdentity inquireAccountResponseInfoAccountCustomerIdentity )	{
		IdentityBean identityBean = null;
		
		if( inquireAccountResponseInfoAccountCustomerIdentity != null )	{
			identityBean = new IdentityBean();
			
			if( inquireAccountResponseInfoAccountCustomerIdentity.getBirth() != null )		{
				identityBean.setDateOfBirth( inquireAccountResponseInfoAccountCustomerIdentity.getBirth().getDateOfBirth() );
			}
			
			identityBean.setSocialSecurityNumber( convertNullToString( inquireAccountResponseInfoAccountCustomerIdentity.getSocialSecurityNumber() ));
		}
		
		return identityBean;
	}*/
	
	/**
	 * 
	 * @param nameInfo ESP NameInfo
	 * @return {@link com.cricket.cid.bean.info.NameBean}
	 */
	/*protected static NameBean parseNameInfo( NameInfo nameInfo )	{
		NameBean name = null;
		
		if( nameInfo != null )		{
			name = new NameBean();
			
			name.setFirstName( nameInfo.getFirstName() );
			name.setLastName( nameInfo.getLastName() );
			name.setAdditionalTitle( nameInfo.getAdditionalTitle() );
			name.setMiddleName( nameInfo.getMiddleName() );
			name.setNamePrefix( nameInfo.getNamePrefix() );
			name.setNameSuffix( nameInfo.getNameSuffix() );
		}
		
		return name;
	}*/
	
	/**
	 * 
	 * @param phoneInfo ESP PhoneInfo
	 * @return {@link com.cricket.cid.bean.info.PhoneBean}
	 */
	/*protected static PhoneBean parsePhoneInfo( PhoneInfo phoneInfo )	{
		PhoneBean phone = null;
		
		if( phoneInfo != null )		{
			phone = new PhoneBean();
			
			phone.setCanBeReachedPhone( phoneInfo.getCanBeReachedPhone() );
			phone.setHomePhone( phoneInfo.getHomePhone() );
			phone.setWorkPhone( phoneInfo.getWorkPhone() );
			phone.setWorkPhoneExtension( phoneInfo.getWorkPhoneExtension() );
		}
		
		return phone;
	}*/
	
	/**
	 * 
	 * @param solicitationContactPreferenceInfo ESP SolicitationContactPreferenceInfo
	 * @return String
	 */
	protected static String parseSolicitationContactPreference( SolicitationContactPreferenceInfo solicitationContactPreferenceInfo )	{
		String contactPreference = "";
		
		if( solicitationContactPreferenceInfo != null )
			contactPreference = solicitationContactPreferenceInfo.toString();
		
		return contactPreference;
	}
	
	/**
	 * 
	 * @param inquireAccountResponseInfoAccountSubscriber ESP InquireAccountResponseInfoAccountSubscriber
	 * @return Array of {@link com.cricket.cid.bean.Subscriber}
	 */
	protected static Subscriber[] parseSubscriber( InquireAccountResponseInfoAccountSubscriber[] inquireAccountResponseInfoAccountSubscriber )	{
		Subscriber subscribers[] = null;
		
		if( inquireAccountResponseInfoAccountSubscriber != null )	{
			int cntSubscriber = inquireAccountResponseInfoAccountSubscriber.length;
			
			subscribers = new Subscriber[ cntSubscriber ];
			
			for( int i=0; i<cntSubscriber; i++ )	{
				Subscriber temp = new Subscriber();
				
				temp.setBundledOfferings(parseBundledOfferingInfo(inquireAccountResponseInfoAccountSubscriber[ i ].getAdditionalOfferings()));
				temp.setBillingResponsibleParty(inquireAccountResponseInfoAccountSubscriber[ i ].getBillingResponsibility());
				temp.setPricePlan( parsePricePlanBean( inquireAccountResponseInfoAccountSubscriber[ i ].getPricePlan() ) );
				temp.setMdn( inquireAccountResponseInfoAccountSubscriber[ i ].getMdn() );
				
				if(inquireAccountResponseInfoAccountSubscriber[ i ].getNotes() != null)
				{
					temp.setNotes( inquireAccountResponseInfoAccountSubscriber[ i ].getNotes() );
				}
				
				if(inquireAccountResponseInfoAccountSubscriber[ i ].getRateCenterId() != null)
				{
					temp.setRateCenterId( convertPositiveIntegerToInteger( inquireAccountResponseInfoAccountSubscriber[ i ].getRateCenterId() ) );
				}
				
				
				//if( inquireAccountResponseInfoAccountSubscriber[ i ].getBucketBalance() != null )
				//	temp.setFlexBucket( parseBucketBalanceInfo( inquireAccountResponseInfoAccountSubscriber[ i ].getBucketBalance() ) );
				
				//if( inquireAccountResponseInfoAccountSubscriber[ i ].getContactInformation() != null )
				//	temp.setContactInformation( parseAddressInfo( inquireAccountResponseInfoAccountSubscriber[ i ].getContactInformation().getAddress() ) );
				
				temp.setDevice( parseDeviceBean( inquireAccountResponseInfoAccountSubscriber[ i ].getDevice() ) );
				
				//if( inquireAccountResponseInfoAccountSubscriber[ i ].getEffectiveDate() != null )
				//	temp.setEffectiveDate( inquireAccountResponseInfoAccountSubscriber[ i ].getEffectiveDate().getEffectiveDate() );
				
				if( inquireAccountResponseInfoAccountSubscriber[ i ].getSubscriberStatus() != null )
					temp.setStatus( inquireAccountResponseInfoAccountSubscriber[ i ].getSubscriberStatus().getValue() );
				
				if( inquireAccountResponseInfoAccountSubscriber[ i ].getSubscriptionLifeCycleType() != null )
					temp.setSubscriptionLifeCycleType( inquireAccountResponseInfoAccountSubscriber[ i ].getSubscriptionLifeCycleType().getValue() );
				
				if( inquireAccountResponseInfoAccountSubscriber[ i ].getSubscriptionType() != null )
					temp.setSubscriptionType( inquireAccountResponseInfoAccountSubscriber[ i ].getSubscriptionType().getValue() );
				
				if( inquireAccountResponseInfoAccountSubscriber[ i ].getPortStatus() != null )
					temp.setPortStatus( inquireAccountResponseInfoAccountSubscriber[ i ].getPortStatus().getValue() );
				 
				//** Currently not used by Front End client **//
				/*
				temp.setAdjustments( parseAdjustment( inquireAccountResponseInfoAccountSubscriber[ i ].getAdjustments() ) );
				temp.setBillingOrderNumber( inquireAccountResponseInfoAccountSubscriber[ i ].getBillingOrderNumber() );
				temp.setCacheDateIndicator( inquireAccountResponseInfoAccountSubscriber[ i ].getCacheDateIndicator() );
				temp.setContract( parseContract( inquireAccountResponseInfoAccountSubscriber[ i ].getContract() ) );
				temp.setPrepaidPayment( parsePayments( inquireAccountResponseInfoAccountSubscriber[ i ].getPrepaidPayment() ) );
				temp.setSubscriberOptions( parseSubscriberOptions( inquireAccountResponseInfoAccountSubscriber[ i ].getSubscriberOptions() ) );
				temp.setTaxInformation( parseOfferingTaxInfo( inquireAccountResponseInfoAccountSubscriber[ i ].getTaxInformation() ) );
				*/
				
				subscribers[ i ] = temp;
			}
		}
		
		return subscribers;
	}
	
	/**
	 * 
	 * @param bundledOfferingsInfo ESP BundledOfferingsInfo
	 * @return Array of {@link com.cricket.cid.bean.info.BundledOfferingBean}
	 */
	protected static BundledOfferingBean[] parseBundledOfferingInfo( BundledOfferingsInfo[] bundledOfferingsInfo )	{
		BundledOfferingBean[] bundledOfferingBeans = null;
		
		if( bundledOfferingsInfo != null )	{
			int cntBundledOfferings = bundledOfferingsInfo.length;
			
			bundledOfferingBeans = new BundledOfferingBean[ cntBundledOfferings ];
			
			for( int i=0; i<cntBundledOfferings; i++ )	{
				BundledOfferingBean temp = new BundledOfferingBean();
				
				temp.setAction( parseAction( bundledOfferingsInfo[ i ].getAction() ) );
				temp.setOfferingCode( bundledOfferingsInfo[ i ].getOfferingCode() );
				
				if( bundledOfferingsInfo[ i ].getEffectiveDate() != null){
					temp.setEffectiveDate( bundledOfferingsInfo[ i ].getEffectiveDate().getEffectiveDate());
				}
				if( bundledOfferingsInfo[ i ].getEffectiveDate() != null){
					temp.setExpirationDate( bundledOfferingsInfo[ i ].getEffectiveDate().getExpirationDate());
				}

				temp.setOfferingDescription( bundledOfferingsInfo[ i ].getOfferingDescription() );
				
				FeatureBean[] featureBeans = null;
				if( bundledOfferingsInfo[ i ].getOfferingFeatures() != null )	{
					OfferingFeaturesInfo[] offeringFeaturesInfo = bundledOfferingsInfo[ i ].getOfferingFeatures();
					
					int cntOfferingFeatures = offeringFeaturesInfo.length;
					featureBeans = new FeatureBean[ cntOfferingFeatures ];
					
					for( int x=0; x<cntOfferingFeatures; x++)	{
						FeatureBean tempBean = new FeatureBean();
						
						tempBean.setFeatureCode( offeringFeaturesInfo[ x ].getFeatureCode() );
						tempBean.setFeatureDescription( offeringFeaturesInfo[ x ].getFeatureDescription() );
						
						featureBeans[ x ] = tempBean;
					}
				}
				temp.setFeatures( featureBeans );

				temp.setOfferingName(bundledOfferingsInfo[ i ].getOfferingName());
				temp.setOfferingValue(bundledOfferingsInfo[ i ].getOfferingValue());
				temp.setOfferTypeId(bundledOfferingsInfo[ i ].getOfferTypeId());

				bundledOfferingBeans[ i ] = temp;
			}
		}
		
		return bundledOfferingBeans;
	}
	
	/**
	 * 
	 * @param bucketBalanceResponse ESP BucketBalanceInfo
	 * @return {@link com.cricket.cid.bean.info.BucketBalanceBean}
	 */
	/*protected static BucketBalanceBean parseBucketBalanceInfo(BucketBalanceInfo bucketBalanceResponse){
		
		BucketBalanceBean bucketBalanceBean = new BucketBalanceBean();
		
		if( bucketBalanceResponse != null )		{
			BucketDetailsInfo[] bucketDetailsArray = bucketBalanceResponse.getBucketDetails(); 
			
			if(bucketDetailsArray != null){
				BucketDetailBean[] flexDetailArray = new BucketDetailBean[bucketDetailsArray.length];
				for(int i=0; i<bucketDetailsArray.length; i++){
					BucketDetailsInfo bucketDetailResponse = bucketDetailsArray[i];
					BucketDetailBean bucketDetailInfo = new BucketDetailBean();
					
					BucketUsageBean usageBean = new BucketUsageBean();
					usageBean.setBucketName( convertNullToString(bucketDetailResponse.getBucketName() ));
					usageBean.setBucketUnit( convertNullToString(bucketDetailResponse.getBucketUnits() ));
					
					bucketDetailInfo.setUsageBean( usageBean );
					
					if(bucketDetailResponse.getBucketType() != null){
						bucketDetailInfo.setBucketType(bucketDetailResponse.getBucketType().getValue());
					}
					bucketDetailInfo.setBucketBalance(bucketDetailResponse.getBucketBalance());
					bucketDetailInfo.setBucketIdentifier(convertNullToString(bucketDetailResponse.getBucketIdentifier()));
					flexDetailArray[i] = bucketDetailInfo;
				}
				bucketBalanceBean.setBucketDetailsInfo(flexDetailArray);	
			}
			bucketBalanceBean.setTotalBucketBalance(bucketBalanceResponse.getTotalBucketBalance());
			bucketBalanceBean.setMainBucketBalance(bucketBalanceResponse.getMainBucketBalance());
			bucketBalanceBean.setExpirationDate(bucketBalanceResponse.getExpirationDate());
		}
		
		return bucketBalanceBean;
	}*/
	
	/**
	 * 
	 * @param deviceResponse ESP DeviceInfo
	 * @return {@link com.cricket.cid.bean.info.DeviceBean}
	 */
	protected static Device parseDeviceBean( DeviceInfo deviceResponse){
		Device device = null;
		
		if( deviceResponse != null )	{
			device = new Device();
			
			device.setCpe(isBoolean( deviceResponse.getCustomerProvidedEquipment() ));
			device.setEsn(deviceResponse.getEquipmentIdentifier().getEsn());
			device.setMeid(deviceResponse.getEquipmentIdentifier().getMeid());
			device.setHasEsnHistory( isBoolean(deviceResponse.getHasEsnHistory() ));
			device.setImsi(deviceResponse.getImsi());
			device.setCricketPhone(isBoolean( deviceResponse.getIsCricketPhone() ));
			device.setMake(deviceResponse.getManufacturer().getMake());
			device.setModel(deviceResponse.getManufacturer().getModel());
			device.setDeviceCode(deviceResponse.getManufacturer().getPhoneCode());
			device.setDeviceType(deviceResponse.getManufacturer().getPhoneType());
			device.setMin(deviceResponse.getMin());
			device.setTradeInHandset( isBoolean( deviceResponse.getTradeInHandset() ));
			
			if( deviceResponse.getEquipmentIdentifier().getEsn() != null && deviceResponse.getEquipmentIdentifier().getEsn().length() != 0 )	{
				device.setDeviceId(deviceResponse.getEquipmentIdentifier().getEsn() );
			}
			else if( deviceResponse.getEquipmentIdentifier().getMeid() != null & deviceResponse.getEquipmentIdentifier().getMeid().length() != 0 )	{
				device.setDeviceId( deviceResponse.getEquipmentIdentifier().getMeid() );
			}
		}
		
		return device;
	}
	
	/**
	 * 
	 * @param planResponse ESP PricePlanInfo
	 * @return {@link com.cricket.cid.bean.info.PricePlanBean}
	 */
	protected static PricePlanBean parsePricePlanBean( PricePlanInfo planResponse){
		PricePlanBean planBean = new PricePlanBean();
		planBean.setPlanCode(planResponse.getPlanCode());
		planBean.setOldPlanCode(planResponse.getOldPlanCode());
		planBean.setPlanType(planResponse.getPlanType().getValue());
		planBean.setPricePlanStatus(planResponse.getPricePlanStatus().getValue());
		if(planResponse.getPrimaryPricePlan() != null){
			planBean.setPlanName(planResponse.getPrimaryPricePlan().getPlanName());
			planBean.setPlanDescription(planResponse.getPrimaryPricePlan().getPlanDescription());
			planBean.setRecurringCharge(planResponse.getPrimaryPricePlan().getRecurringCharge());
		}
		// Dates --------------------------------------------------------------
		if(planResponse.getEffectiveDate().getEffectiveDate() != null){
			planBean.setEffectiveDate(planResponse.getEffectiveDate().getEffectiveDate());
		}
		if(planResponse.getEffectiveDate().getExpirationDate() != null){
			planBean.setExpirationDate(planResponse.getEffectiveDate().getExpirationDate());
		}
		/*
		// Activation Fee -----------------------------------------------------
		if(planResponse.getPrimaryPricePlan().getActivationFee() != null){
			planBean.setActivationFees(parseActivationFeeInfo(planResponse.getPrimaryPricePlan().getActivationFee()));
		}
		// Early Termination Fee ----------------------------------------------
		if(planResponse.getPrimaryPricePlan().getEarlyTerminationFee() != null){
			planBean.setEarlyTerminationFees(parseEarlyTerminationFeeInfo(planResponse.getPrimaryPricePlan().getEarlyTerminationFee()));
		}
		// Contract Terms -----------------------------------------------------
		if(planResponse.getContractTerm() != null){
			planBean.setContractTerms(parseContractTermInfo(planResponse.getContractTerm()));
		}
		*/
		// Bundled Offerings --------------------------------------------------
		if(planResponse.getBundledOfferings() != null){
			planBean.setBundledOfferings(parseBundledOfferingInfo(planResponse.getBundledOfferings()));
		}
				
		return planBean;
	}

	/*
	protected static ActivationFeeBean[] parseActivationFeeInfo( ActivationFeeInfo[] activationFeesResponse){
		ActivationFeeBean[] activationFees = null;
		
		if( activationFeesResponse != null )		{
			activationFees = new ActivationFeeBean[activationFeesResponse.length];
			for(int i=0; i < activationFees.length; i++){
				ActivationFeeBean temp = new ActivationFeeBean();
				
				temp.setActivationFeeCharge(activationFeesResponse[i].getActivationFeeCharge());
				temp.setActivationFeeCode(activationFeesResponse[i].getActivationFeeCode());
				temp.setActivationFeeDescription(activationFeesResponse[i].getActivationFeeDescription());
				
				activationFees[ i ] = temp;
			}
		}
		return activationFees;
	}
	
	protected static EarlyTerminationFeeBean[] parseEarlyTerminationFeeInfo( EarlyTerminationFeeInfo[] earlyTerminationFeesResponse){
		EarlyTerminationFeeBean[] earlyTerminationFees = null;
		
		if( earlyTerminationFeesResponse != null )	{
			earlyTerminationFees = new EarlyTerminationFeeBean[earlyTerminationFeesResponse.length];
			
			for(int i=0; i < earlyTerminationFees.length; i++){
				EarlyTerminationFeeBean temp = new EarlyTerminationFeeBean();
				
				temp.setAmount(earlyTerminationFeesResponse[i].getAmount());
				temp.setCommitmentLength(earlyTerminationFeesResponse[i].getCommitmentLength());
				temp.setType(earlyTerminationFeesResponse[i].getType().getValue());
				
				earlyTerminationFees[ i ] = temp;
			}
		}
		return earlyTerminationFees;
	}
	
	protected static ContractTermBean[] parseContractTermInfo( ContractTermInfo[] contractTermRepsonse){
		ContractTermBean[] contractTerms = new ContractTermBean[contractTermRepsonse.length];
		for(int i=0; i < contractTerms.length; i++){
			if(contractTermRepsonse[i].getCommission() != null){
				if(contractTermRepsonse[i].getCommission().getDrawerId() != null){
					contractTerms[i].setDrawerId(contractTermRepsonse[i].getCommission().getDrawerId());
				}
				if(contractTermRepsonse[i].getCommission().getLocationId() != null){
					contractTerms[i].setLocationId(contractTermRepsonse[i].getCommission().getLocationId());
				}
				if(contractTermRepsonse[i].getCommission().getSalesChannel() != null){
					contractTerms[i].setSalesChannel(contractTermRepsonse[i].getCommission().getSalesChannel());
				}
				if(contractTermRepsonse[i].getCommission().getSalesRepresentative() != null){
					contractTerms[i].setSalesRepresentative(contractTermRepsonse[i].getCommission().getSalesRepresentative());
				}
				if(contractTermRepsonse[i].getCommission().getTerminalId() != null){
					contractTerms[i].setTerminalId(contractTermRepsonse[i].getCommission().getTerminalId());
				}
				if(contractTermRepsonse[i].getCommission().getDealer() != null){
					if(contractTermRepsonse[i].getCommission().getDealer().getCode() != null){
						contractTerms[i].setDealerCode(contractTermRepsonse[i].getCommission().getDealer().getCode());
					}
					if(contractTermRepsonse[i].getCommission().getDealer().getSecondaryCode() != null){
						contractTerms[i].setDealerSecondaryCode(contractTermRepsonse[i].getCommission().getDealer().getSecondaryCode());
					}
				}
			}
		}
		return contractTerms;
	}
	
	protected static TaxExemptionBean[] parseTaxExemption( TaxExemptionInfo[] taxExemptionInfo )	{
		TaxExemptionBean[] taxExemptionBeans = null;
		
		if( taxExemptionInfo != null )	{
			int cntTaxExemption = taxExemptionInfo.length;
			
			taxExemptionBeans = new TaxExemptionBean[ cntTaxExemption ];
			
			for( int i=0; i<cntTaxExemption; i++ )	{
				TaxExemptionBean temp = new TaxExemptionBean();
				
				temp.setAction( parseAction( taxExemptionInfo[ i ].getAction() ) );
				temp.setEffectiveDate( parseEffectiveDates( taxExemptionInfo[ i ].getEffectiveDate() ) );
				temp.setTaxAuthority( parseTaxAuthority( taxExemptionInfo[ i ].getTaxAuthority() ) );
				temp.setTaxExemptId( taxExemptionInfo[ i ].getTaxExemptId() );
				
				taxExemptionBeans[ i ] = temp;
			}
		}
		
		return taxExemptionBeans;
	}
	
	protected static String parseTaxAuthority( TaxExemptionAuthorityInfo taxExemptionAuthorityInfo )	{
		String taxAuthority = "";
		
		if( taxExemptionAuthorityInfo != null )	
			taxAuthority = taxExemptionAuthorityInfo.toString();
		
		return taxAuthority;
	}
	
	
	protected static BundledOfferingBean[] parseBundledOfferingsInfo(com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.BundledOfferingsInfo[] offeringsResponse){
		BundledOfferingBean[] bundledOfferings = new BundledOfferingBean[offeringsResponse.length];
		for(int i=0; i < bundledOfferings.length; i++){
			if(offeringsResponse[i].getAction() != null){
				bundledOfferings[i].setAction(offeringsResponse[i].getAction().getValue());
			}
			if(offeringsResponse[i].getOfferingCode() != null){
				bundledOfferings[i].setOfferingCode(offeringsResponse[i].getOfferingCode());
			}
			if(offeringsResponse[i].getOfferingName() != null){
				bundledOfferings[i].setOfferingName(offeringsResponse[i].getOfferingName());
			}
			if(offeringsResponse[i].getOfferingDescription() != null){
				bundledOfferings[i].setOfferingDescription(offeringsResponse[i].getOfferingDescription());
			}
			if(offeringsResponse[i].getOfferingValue() != null){
				bundledOfferings[i].setOfferingValue(offeringsResponse[i].getOfferingValue());
			}
			if(offeringsResponse[i].getOfferTypeId() != null){
				bundledOfferings[i].setOfferTypeId( convertPositiveIntegerToInteger( offeringsResponse[i].getOfferTypeId() ));
			}
			// Dates
			if(offeringsResponse[i].getEffectiveDate() != null){
				if(offeringsResponse[i].getEffectiveDate().getEffectiveDate() != null){
					bundledOfferings[i].setEffectiveDate(offeringsResponse[i].getEffectiveDate().getEffectiveDate());
				}
				if(offeringsResponse[i].getEffectiveDate().getExpirationDate() != null){
					bundledOfferings[i].setExpirationDate(offeringsResponse[i].getEffectiveDate().getExpirationDate());
				}
			}
			// Features
			if(offeringsResponse[i].getOfferingFeatures() != null){
				FeatureBean[] features = new FeatureBean[offeringsResponse[i].getOfferingFeatures().length];
				for(int ii=0; ii < bundledOfferings.length; ii++){
					features[ii].setFeatureCode(offeringsResponse[i].getOfferingFeatures(ii).getFeatureCode());
					features[ii].setFeatureDescription(offeringsResponse[i].getOfferingFeatures(ii).getFeatureDescription());
				}
				bundledOfferings[i].setFeatures(features);
			}
			// Tax
			if(offeringsResponse[i].getOfferingTaxInfo() != null){
				OfferingTaxBean tax = new OfferingTaxBean();
				if(offeringsResponse[i].getOfferingTaxInfo().getIsTaxRemitted() != null){
					tax.setIsTaxRemitted(offeringsResponse[i].getOfferingTaxInfo().getIsTaxRemitted());
				}
				if(offeringsResponse[i].getOfferingTaxInfo().getGeoCode() != null){
					tax.setGeoCode(offeringsResponse[i].getOfferingTaxInfo().getGeoCode());
				}
				if(offeringsResponse[i].getOfferingTaxInfo().getNotes() != null){
					tax.setNotes(offeringsResponse[i].getOfferingTaxInfo().getNotes());
				}
				if(offeringsResponse[i].getOfferingTaxInfo().getSourceTransactionId() != null){
					tax.setSourceTransactionId(offeringsResponse[i].getOfferingTaxInfo().getSourceTransactionId());
				}
				if(offeringsResponse[i].getOfferingTaxInfo().getTaxAmount() != null){
					tax.setTaxAmount(offeringsResponse[i].getOfferingTaxInfo().getTaxAmount());
				}
				if(offeringsResponse[i].getOfferingTaxInfo().getTaxCategory() != null){
					tax.setTaxCategory(offeringsResponse[i].getOfferingTaxInfo().getTaxCategory());
				}
				if(offeringsResponse[i].getOfferingTaxInfo().getTaxRate() != null){
					tax.setTaxRate(offeringsResponse[i].getOfferingTaxInfo().getTaxRate());
				}
				if(offeringsResponse[i].getOfferingTaxInfo().getTaxType() != null){
					tax.setTaxType(offeringsResponse[i].getOfferingTaxInfo().getTaxType());
				}
				if(offeringsResponse[i].getOfferingTaxInfo().getTransactionID() != null){
					tax.setTransactionId(offeringsResponse[i].getOfferingTaxInfo().getTransactionID());
				}
				if(offeringsResponse[i].getOfferingTaxInfo().getVendorSerialNumber() != null){
					tax.setVendorSerialNumber(offeringsResponse[i].getOfferingTaxInfo().getVendorSerialNumber());
				}
				bundledOfferings[i].setOfferingTax(tax);
			}
			
		}
		return bundledOfferings;
	}
	

	public static Date parseStringToDate(String dateString) {
		SimpleDateFormat timeZoneDateFormat = null;
    	SimpleDateFormat simpleDateFormat = null;
    	Date date = null;
    	
    	if(dateString != null && !dateString.equalsIgnoreCase("")){
			timeZoneDateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			try {
	    		if(dateString.contains("T") && dateString.contains("Z")){
	    			date =timeZoneDateFormat.parse(dateString);
	    		}else{
	    			date =simpleDateFormat.parse(dateString);
	    		}
			} catch (ParseException e) {			
				e.printStackTrace();
			}
		}
		return date;
	}
	*/
}
