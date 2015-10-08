package com.wireless.tibco;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.wireless.bean.OfferFeaturesBean;
import com.wireless.bean.OfferRatePlanBean;
import com.wireless.bean.OffersBean;

public class InquireOffersTest {

	private InquireOffers inquireOffers;
	
	@Before
	public void setUp() throws Exception {
		String salesChannel = "CID-CSR";
		String accountType = "P";
		String customerType = "S";
		String marketId = "330";
		String transactionName = "ACT";
		String deviceId = "429496729500048141";
		//String deviceId = "23516500329";
		String phoneCode = "APL 5";
		String phoneType = "Voice";
		boolean isCricketPhone = true;
		boolean hasEsnHistory = false;
		boolean customerProvidedEquipment = true;
		String productCode = "1";
		
		inquireOffers = new InquireOffers(salesChannel,accountType,customerType,marketId,transactionName,deviceId,phoneCode,phoneType,isCricketPhone,hasEsnHistory,customerProvidedEquipment,productCode);
	}

	@Test
	public void testInvokeService() throws Exception {
		
		
		OffersBean[] ratePlanOffersBean = null;

		HashMap<String, Object> response = inquireOffers.invokeService();
		
		if( response.get( "espResponseObject" ) == null )	{	
			System.out.println( "No Account object is returned" );
		}
		else	{
			if( response.get( "espResponseObject" ) instanceof OffersBean[] )	{
				ratePlanOffersBean = (OffersBean[]) response.get( "espResponseObject" );
				
				for( int z=0; z<ratePlanOffersBean.length; z++ )	{
					OfferRatePlanBean ratePlan = ratePlanOffersBean[z].getOfferRatePlanBean();
					ArrayList< OfferFeaturesBean > features = (ArrayList< OfferFeaturesBean >) ratePlanOffersBean[z].getOfferFeaturesBean();
					
					System.out.println( "=================" );
					System.out.println( "RATEPLAN " );
					System.out.println( "ratePlan id = " + ratePlan.getPlanId() );
					System.out.println( "ratePlan name = " + ratePlan.getPlanName() );
					System.out.println( "ratePlan price = " + ratePlan.getPrice() );
					
					System.out.println( "=================" );
					System.out.println( "FEATURES" );
					
					for( int x=0; x<features.size(); x++ )	{
						
						System.out.println( "rp - feature = " + features.get(x).getOfferName() );
						System.out.println( "rp - arrayIndex = " + features.get(x).getArrayIndex() );
						System.out.println( "rp - price = " + features.get(x).getFeaturePrice() );
						if(!features.get(x).getFeaturePrice().equalsIgnoreCase("X") && features.get(x).getIsSelectable() == false)// && Double.compare(Double.parseDouble(features.get(x).getFeaturePrice()), Double.parseDouble("0.00")) >= 0 && features.get(x).getIsSelectable() == false)
						{
							System.out.println( "price compare: " + Double.compare(Double.parseDouble(features.get(x).getFeaturePrice()), Double.parseDouble("0.00")));
						}
						
						System.out.println( "rp - selectable = " + features.get(x).getIsSelectable() );
						System.out.println( "rp - selected = " + features.get(x).getIsSelected() );
						System.out.println( " " );
						
						
						//System.out.println(features.get(x).toString());
					}
				}
			}
			else	{
				System.out.println( "Offers = " + (String) response.get( "espResponseObject" ) );
			}
		}
	}

}
