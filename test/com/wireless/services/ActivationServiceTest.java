package com.wireless.services;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.wireless.bean.RateCenterBean;
import com.wireless.domain.Account;
import com.wireless.domain.Address;
import com.wireless.domain.Cart;
import com.wireless.domain.Contract;
import com.wireless.domain.Customer;
import com.wireless.domain.Device;
import com.wireless.domain.Subscriber;
import com.wireless.services.ActivationService;
import com.wireless.utilities.Utility;

public class ActivationServiceTest 
{
	ActivationService activationService;

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testGetRateCenter() {
		RateCenterBean[] rcBeans = Utility.getRateCenterInfo("330");

		for (int x = 0; x < rcBeans.length; x++) {
			System.out.println(rcBeans[x].getId());
			System.out.println(rcBeans[x].getName());
			System.out.println(rcBeans[x].getDescription());
		}
	}

	@Test
	public void testGetNetworkCoverage() {
		String address1 = "14792 Eagle River Loop";
		String city = "Broomfield";
		String state = "CO";
		String zip = "80023";

		Address address = new Address();
		address.setAddress1(address1);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);

		HashMap<String, String> networkCoverage = Utility.getNetworkCoverage(address);

		System.out.println("id = " + networkCoverage.get("providerId")
				+ " | name = " + networkCoverage.get("providerName")
				+ " | marketId = " + networkCoverage.get("marketId"));
	}
	
	@Test
	public void testCreateQuote() throws Exception 
	{
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
		
		Cart cart = new Cart();
		cart.setAccount(account);
		cart.setTransactionType(Cart.TRANSACTION_TYPE_NEW);
		
		activationService = new ActivationService();
		activationService.createQuote(cart);
		System.out.println(cart.toString());
	}
}
