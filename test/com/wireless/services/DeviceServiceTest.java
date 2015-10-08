package com.wireless.services;

import java.util.HashMap;

import org.junit.Test;

import com.wireless.domain.Device;
import com.wireless.services.DeviceService;

public class DeviceServiceTest {

	@Test
	public void test() {
		DeviceService deviceSvc = new DeviceService();
		
		//HashMap<String, String> deviceInfo = new HashMap<String, String>();
		//deviceInfo.put("deviceId", "429496729500048141");
				
		Device device = deviceSvc.validateDevice("429496729500048141", "330");
		
		System.out.println(device.toString());
	}

}
