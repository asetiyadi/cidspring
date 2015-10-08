package com.wireless.tibco.parser;

import com.cricket.esp.ESP.Namespaces.Container.Public.ValidateDeviceResponse_xsd.ValidateDeviceResponseInfoDeviceInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.DeviceHistoryInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.NetworkProviderInfo;
import com.wireless.bean.DeviceHistoryBean;
import com.wireless.bean.NetworkProviderBean;
import com.wireless.domain.Device;

public class ParseValidateDevice {//extends ParseSuper {

	public static Device parseValidateDevice( ValidateDeviceResponseInfoDeviceInfo deviceInfo, NetworkProviderInfo[] networks )		{
		Device device = new Device();
		
		if( deviceInfo.getDeviceHistory() != null )	{
			device.setHasEsnHistory( true );
			device.setDeviceHistory( parseDeviceHistory( deviceInfo.getDeviceHistory() ));
		}
		
		if(deviceInfo.getDeviceStatus().getBillingAccountNumber() != null){
			device.setAccountNumber(deviceInfo.getDeviceStatus().getBillingAccountNumber());
		}
		
		if(deviceInfo.getDeviceStatus().getMdn() != null){
			device.setMdn(deviceInfo.getDeviceStatus().getMdn());
		}
		
		/**
		 * V - Available 
		 * L - Locked/Stolen 
		 * I - In inventory 
		 * O - Other 
		 * A - Active 
		 * D - Disconnected 
		 * S - Suspended 
		 * P - Pending 
		 */
		device.setDeviceStatus( deviceInfo.getDeviceStatus().getStatus().getValue() );
		
		if( deviceInfo.getCardStatus() != null )		{
			device.setICCID( deviceInfo.getDeviceSpecs().getCard().getIccid() );
			device.setSf_eumid( deviceInfo.getDeviceSpecs().getCard().getSf_euimid() );
			device.setImsi( deviceInfo.getDeviceSpecs().getCard().getImsi() );
			device.setEncryptionKey( deviceInfo.getDeviceSpecs().getCard().getEncryptionKey() );
			device.setPuk1( deviceInfo.getDeviceSpecs().getCard().getPuk1() );
			device.setImeisv( deviceInfo.getDeviceSpecs().getImeisv() );
		}
		
		if( deviceInfo.getDeviceSpecs() !=  null )		{
			device.setMake( deviceInfo.getDeviceSpecs().getManufacturer().getMake() );
			device.setModel( deviceInfo.getDeviceSpecs().getManufacturer().getModel() );
			device.setDeviceCode( deviceInfo.getDeviceSpecs().getManufacturer().getPhoneCode() );
			device.setDeviceType( deviceInfo.getDeviceSpecs().getManufacturer().getPhoneType() );
			
			if( deviceInfo.getDeviceSpecs().getIsBbmm() != null )	{
				device.setBBMM(deviceInfo.getDeviceSpecs().getIsBbmm());
			}
			
			if( deviceInfo.getDeviceSpecs().getIsPayGo() != null )	{
				device.setPaygo(deviceInfo.getDeviceSpecs().getIsPayGo());
			}
			
			device.setCricketPhone(deviceInfo.getDeviceSpecs().isIsCricketPhone());
			device.setRefurbished(deviceInfo.getDeviceSpecs().getIsRefurbishedDevice());
		}
		
		if( deviceInfo.getExternalRetailer() != null )	{
			device.setExternalRetailerId( deviceInfo.getExternalRetailer().getId() );
			device.setExternalRetailerName( deviceInfo.getExternalRetailer().getName() );
		}
		/*
		if( deviceInfo.getDeviceHistory() != null && deviceInfo.getDeviceSpecs().isIsCricketPhone() == true )	{
			device.setDeviceType( "NEW" );
		}
		else if( deviceInfo.getDeviceHistory() == null && deviceInfo.getDeviceSpecs().isIsCricketPhone() == true )	{
			device.setDeviceType( "PWH" );
		}
		else	{
			device.setDeviceType( "NBC" );
		}
		*/
		// Network Provider
		NetworkProviderBean[] arrNetworkProvider = new NetworkProviderBean[networks.length];
		for(int x=0; x < networks.length; x++)
		{
			NetworkProviderBean networkProvider = new NetworkProviderBean();
			networkProvider.setId(networks[x].getId());
			networkProvider.setName(networks[x].getName().toString());
			
			arrNetworkProvider[x] = networkProvider;
		}
		device.setNetworkProvider(arrNetworkProvider);
		
		return device;
	}
	
	private static DeviceHistoryBean[] parseDeviceHistory( DeviceHistoryInfo[] deviceHistoryInfo )	{
		DeviceHistoryBean[] deviceHistoryBean = null;
		
		if( deviceHistoryInfo != null )	{
			deviceHistoryBean = new DeviceHistoryBean[ deviceHistoryInfo.length ];
			
			for( int x=0; x<deviceHistoryInfo.length; x++ )	{
				DeviceHistoryBean temp = new DeviceHistoryBean();
				
				temp.setBillingAccountNumber( deviceHistoryInfo[x].getBillingAccountNumber() );
				temp.setBillingSourceSystemId( deviceHistoryInfo[x].getBillingSourceSystemId().getValue() );
				temp.setCustomerServiceRep( deviceHistoryInfo[x].getCustomerServiceRep() );
				temp.setDeviceStatus( deviceHistoryInfo[x].getStatus().getValue() );
				temp.setEffectiveDate( deviceHistoryInfo[x].getEffectiveDate() );
				temp.setMdn( deviceHistoryInfo[x].getMdn() );
				temp.setProcessedDate( deviceHistoryInfo[x].getProcessedDate() );
				temp.setWorkOrderNumber( deviceHistoryInfo[x].getWorkOrderNumber() );
				
				deviceHistoryBean[x] = temp;
			}
		}
		
		return deviceHistoryBean;
	}
}
