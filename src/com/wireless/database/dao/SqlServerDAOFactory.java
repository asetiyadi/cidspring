package com.wireless.database.dao;


public class SqlServerDAOFactory extends DAOFactory 
{
	CustomerDataServicesDAO cdsDao;
	
	public static String DATABASE_NAME_CUSTOMERDATASERVICES = "CustomerDataServices";
	
	/*
	public CustomerDataServicesSVC getCustomerDataServicesDAO()// throws NamingException
	{
		return new CustomerDataServicesSVC();
	}
	*/
	/*
	public CustomerDataServicesDAO getCustomerDataServicesDAO()// throws NamingException
	{
		return new CustomerDataServicesDAO();
	}
	*/
	public CustomerDataServicesDAO getCustomerDataServicesDAO()// throws NamingException
	{
		return cdsDao;
	}
}
