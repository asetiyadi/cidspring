package com.wireless.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.wireless.domain.Device;
import com.wireless.tibco.ValidateDevice;

@Service
public class DeviceService 
{
	public Device validateDevice(String deviceId, String marketId)
	{
		HashMap<String, String> deviceInfo = new HashMap<String, String>();
		deviceInfo.put("deviceId", deviceId);
		 
		
		ValidateDevice validateDevice = new ValidateDevice(deviceInfo, marketId);
		HashMap< String, Object> result = validateDevice.invokeService();
		
		Device device = (Device) result.get("espResponseObject");
		device.setDeviceId(deviceInfo.get("deviceId"));
		
		return device;
	}
}
