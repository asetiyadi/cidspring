package com.wireless.tibco.parser;

import java.util.ArrayList;

import com.cricket.esp.ESP.Namespaces.Container.Public.InquireOffersResponse_xsd.InquireOffersResponseInfoInquireOffersResponse;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.OfferInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.OfferInfoOfferSpecs;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.OfferInfoSuperOfferGroupInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.OfferRatePlanInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.RatePlanInfo;
import com.wireless.bean.OfferFeaturesBean;
import com.wireless.bean.OfferRatePlanBean;
import com.wireless.bean.OffersBean;


public class ParseInquireOffers {// extends ParseSuper {
	
	/**
	 * 
	 * @param offers InquireOffersResponseInfoInquireOffersResponse
	 * @return {@link com.cricket.cid.bean.OffersBean}
	 */
	public static OffersBean[] parseInquireOffers( InquireOffersResponseInfoInquireOffersResponse offers )		{
		OffersBean[] ratePlanOffersBean = new OffersBean[ offers.getRatePlan().length ];
	
		//ESP Response objects;
		RatePlanInfo[] ratePlanInfo = offers.getRatePlan();
		OfferRatePlanInfo[] offerRatePlanInfo = offers.getOfferRatePlan();
		OfferInfo[] offerInfo = offers.getOffer();
		
		for( int i=0; i<ratePlanInfo.length; i++ )	{
			OfferRatePlanBean offerRatePlanBean = new OfferRatePlanBean();
			OffersBean rpOfferBean = new OffersBean();
			
			offerRatePlanBean.setArrayIndex( ratePlanInfo[ i ].getArrayIndex() );
			offerRatePlanBean.setDisplayMessageId( ratePlanInfo[ i ].getDisplayMessageId() );
			offerRatePlanBean.setGroupId( ratePlanInfo[ i ].getGroupId() );
			offerRatePlanBean.setGroupName( ratePlanInfo[ i ].getGroupName() );
			offerRatePlanBean.setOrderNo( ratePlanInfo[ i ].getOrderNo() );
			offerRatePlanBean.setPlanId( ratePlanInfo[ i ].getPlanId() );
			offerRatePlanBean.setPlanName( ratePlanInfo[ i ].getPlanName() );
			offerRatePlanBean.setPrice( ratePlanInfo[ i ].getPrice() );
		
			ArrayList< OfferFeaturesBean > offerFeaturesBean = new ArrayList< OfferFeaturesBean >();
			offerFeaturesBean = parseOfferFeatures( ratePlanInfo[ i ].getArrayIndex(), offerRatePlanInfo, offerInfo );
			
			rpOfferBean.setOfferRatePlanBean( offerRatePlanBean );
			rpOfferBean.setOfferFeaturesBean( offerFeaturesBean );
			
			ratePlanOffersBean[ i ] = rpOfferBean;
		}
		
		return ratePlanOffersBean;
	}
	
	/**
	 * This will return all of the included, mandatory and bolt-on features for a particular rate plan
	 * 
	 * @param rpIndex RatePlan arrayIndex
	 * @param offerRatePlanInfo Array of OfferRatePlanInfo
	 * @param offerInfo Array of OfferInfo
	 * @return {@link com.cricket.cid.bean.info.OfferFeaturesBean}
	 */
	private static ArrayList< OfferFeaturesBean > parseOfferFeatures( int rpIndex, OfferRatePlanInfo[] offerRatePlanInfo, OfferInfo[] offerInfo )	{
		int offerIndex;
		ArrayList< OfferFeaturesBean > features = new ArrayList< OfferFeaturesBean >();
		
		for( int x=0; x<offerRatePlanInfo.length; x++ )	{
			OfferFeaturesBean temp = new OfferFeaturesBean();
			
			if( offerRatePlanInfo[x].getRatePlanArrayIndex() == rpIndex )	{
				OfferRatePlanInfo orp = offerRatePlanInfo[x];
				
				offerIndex = offerRatePlanInfo[x].getOfferArrayIndex();		
				
				temp.setAdd( orp.getAdd() );
				temp.setIsAvailable( orp.isAvailable() );
				temp.setIsDisablePositiveTrigger( orp.isDisablePositiveTrigger() );
				temp.setDisableTriggerIndex( orp.getDisableTriggerIndex() );
				temp.setDisableTriggerOfferId( orp.getDisableTriggerOfferId() );
				temp.setFeaturePrice( orp.getDisplay() );
				temp.setDisplayMessageId( orp.getDisplayMessageId() );
				temp.setIsDisplayOffer( orp.isDisplayOffer() );
				temp.setDisplayTypeId( orp.getDisplayTypeId() );
				temp.setFcOfferIndex( orp.getFcOfferIndex() );
				temp.setFixedCostParentOfferId( orp.getFixedCostParentOfferId() );
				temp.setGroupId( orp.getGroupId() );
				temp.setId( orp.getId() );
				temp.setIsPreSelect( orp.getIsPreSelect() );
				temp.setOfferArrayIndex( orp.getOfferArrayIndex() );
				temp.setIsPositiveTrigger( orp.isPositiveTrigger() );
				temp.setRatePlanArrayIndex( orp.getRatePlanArrayIndex() );
				temp.setIsSelectable( orp.isSelectable() );
				temp.setIsSelected( orp.isSelected() );
				temp.setIsStandAloneComboComponent( orp.isStandAloneComboComponent() );
				temp.setTriggeringOfferId( orp.getTriggeringOfferId() );
				temp.setTriggeringOfferIndex( orp.getTriggeringOfferIndex() );
				temp.setType( orp.getType() );
				
				for( int y=0; y<offerInfo.length; y++ )	{
					if( offerInfo[y].getArrayIndex() == offerIndex )	{
						temp.setArrayIndex( offerInfo[y].getArrayIndex() );
						temp.setGroupId( offerInfo[y].getGroupId() );
						temp.setOfferName( offerInfo[y].getOfferName() );
						temp.setOfferType( offerInfo[y].getOfferType() );
						temp.setOrderNo( offerInfo[y].getOrderNo() );
						
						OfferInfoOfferSpecs offerInfoSpec = offerInfo[y].getOfferSpecs();
						temp.setIsGroupExpand( offerInfoSpec.getIsGroupExpand() );
						temp.setIsTopFeature( offerInfoSpec.getIsTopFeature() );
						temp.setTopFeaturePrecedence( offerInfoSpec.getTopFeaturePrecedence() );
						
						OfferInfoSuperOfferGroupInfo superGroup = offerInfo[y].getSuperOfferGroupInfo();
						temp.setSuperOfferGroupId( superGroup.getSuperOfferGroupId() );
						temp.setSuperOfferGroupLocationId( superGroup.getSuperOfferGroupLocationId() );
						temp.setSuperOfferGroupName( superGroup.getSuperOfferGroupName() );
						
						break;
					}
				}

				features.add( temp );
			}
		}
		
		return features;
	}
}
