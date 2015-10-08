package com.wireless.database.dao;

import java.util.Map;

public interface ICustomerDataServicesDAO 
{
	public Map<String, String> getCityStateByZip(String zipcode);
}
