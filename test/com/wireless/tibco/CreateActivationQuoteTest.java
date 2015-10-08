package com.wireless.tibco;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wireless.bean.BillingQuoteBean;
import com.wireless.domain.Account;
import com.wireless.domain.Address;
import com.wireless.domain.Contract;
import com.wireless.domain.Customer;
import com.wireless.domain.Device;
import com.wireless.domain.Subscriber;

public class CreateActivationQuoteTest {

	private CreateActivationQuote quote;
	private BillingQuoteBean billingQuote;
	
	@Before
	public void setUp() throws Exception {
		//TRANSACTION TYPE
		String transactionType = "ACT";
		
		
		//CUSTOMER
		Customer customer = new Customer();
		customer.setCustomerType( 'S' );
		
		customer.setFirstName( "Yellow" );
		customer.setLastName( "Bird" );
		
		customer.setDob(new SimpleDateFormat("yyyy/mm/dd").parse("12/01/1999"));
		customer.setSsn( "111223333" );
		
		Address marketAddress = new Address();
		marketAddress.setAddress1( "14792 Eagle River Loop" );
		marketAddress.setCity( "Broomfield" );
		marketAddress.setState( "CO" );
		marketAddress.setZip( "80023" );
		marketAddress.setZipExtension("8748");
		customer.setAddress(marketAddress);
		
				
		//ACCOUNT
		Account account = new Account();
		account.setAccountType( "P" );
		
		account.setEffectiveDate( new Date() );
		
		account.setMarketId( "330" );
		account.setRateCenterId( 32 );
		account.setJointVentureCode(401);
		account.setLanguage('E');
		account.setElectronicBillReporting('A');
		//account.setBillReminderFlag( "true" );
		
		
		Subscriber subscriber = new Subscriber();
		
		subscriber.setBillingResponsibleParty(true);
		
		Device device = new Device();
		device.setDeviceId("23516603114");
		device.setDeviceCode( "AUD8910" );
		device.setCricketPhone(false);
		device.setHasEsnHistory(false);
		device.setCpe( true );
		subscriber.setDevice( device );
		
		//subscriber.setEffectiveDate( new Date() );
		//subscriber.setContractTerm( new BigInteger( "1" ) );
		
		Contract contract = new Contract();
		contract.setTerm(BigInteger.valueOf(1));
		contract.setLocationId( "7197" );
		contract.setSalesRepresentative( "csrint" );
		contract.setSalesChannel( "CID-CSR" );
		subscriber.setContract(contract);
		
		//AddressBean contact = new AddressBean();
		String[] offeringCodes = { "-422", "719", "150", "473", "246", "576", "721", "626", "36", "828", "829", "861", "851", "833", "2038", "2037", "830", "831", "832" };
		subscriber.setOfferingCodes( offeringCodes );
		
		Subscriber[] subscribers = new Subscriber[ 1 ];
		subscribers[ 0 ] = subscriber;
		
		account.setSubscribers( subscribers );
		account.setCustomer(customer);
		
		quote = new CreateActivationQuote(transactionType, account);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetServiceName() {
		System.out.println( quote.getServiceName() );
	}

	@Test
	public void testCreateRequest() {
		quote.createRequest();
	}

	@Test
	public void testCreateStub() throws Exception {
		quote.createStub();
	}
	
	@Test
	public void testInvokeService() throws Exception {
		HashMap< String, Object> response = new HashMap<String, Object>();
		
		response = quote.invokeService();
		
		if( response.get( "espResponseObject" ) == null )	{	
			System.out.println( "No Account object is returned" );
		}
		else	{
			if( response.get( "espResponseObject" ) instanceof BillingQuoteBean )	{
				billingQuote = (BillingQuoteBean) response.get( "espResponseObject" );
				/*
				System.out.println( "ESP Call Result => " + response.get( "isSuccessful" ) + "\n");
				
				System.out.println( "QuoteID = " +  billingQuote.getBillingQuoteId() );
				System.out.println( "AccountNumber = " +  billingQuote.getBillingAccountNumber() );
				*/
				System.out.println(billingQuote.toString());
			}
			else	{
				System.out.println( "Account Info = " + (String) response.get( "espResponseObject" ) );
			}
		}
	}
}
