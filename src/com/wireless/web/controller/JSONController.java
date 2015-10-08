package com.wireless.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wireless.database.impl.CustomerDataServicesImpl;
import com.wireless.domain.Account;
import com.wireless.domain.Device;
import com.wireless.services.AccountService;
import com.wireless.services.DeviceService;

@Controller
@RequestMapping("/json")
public class JSONController 
{
	@Autowired
	private CustomerDataServicesImpl cdsImpl;
	
	@Autowired
	DeviceService deviceService;
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/citystate/{zip}", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getCityStateByZipcode(@PathVariable("zip") String zipcode)	//@ResponseBody will tell Spring to convert result as JSON
	{	
		Map<String, String> result = new HashMap<String, String>();
		result = cdsImpl.getCityStateByZip(zipcode);

		return result;
	}
	
	@RequestMapping(value="/device/{marketId}/{deviceId}", method = RequestMethod.GET)
	public @ResponseBody Device validateDevice(@PathVariable("marketId") String marketId, @PathVariable("deviceId") String deviceId)
	{
		Device device = deviceService.validateDevice(deviceId, marketId);
		return device;
	}
	
	@RequestMapping(value="/account/{accountNumber}", method = RequestMethod.GET)
	public @ResponseBody Account getAccount(@PathVariable("accountNumber") String accountNumber)
	{
		Account account = accountService.getAccount(accountNumber); 
		
		return account;
	}
}
