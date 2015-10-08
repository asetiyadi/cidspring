package com.wireless.database.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceCache 
{
	private static DataSourceCache instance;
	private DataSource dataSource;
	//private Properties properties = new Properties();
	//private String environment;
	private Context initContext;
	private Context webContext;
	
	static
	{
		instance = new DataSourceCache();
	}
	
	private DataSourceCache()
	{
		try 
		{
			/*InputStream inputStream = getClass().getClassLoader().getResourceAsStream("com/wireless/resources/id.properties");
			properties.load(inputStream);
			
			this.environment = properties.getProperty("app_environment");
			inputStream = getClass().getClassLoader().getResourceAsStream("com/wireless/resources/" + this.environment + ".properties");
			properties.load(inputStream);*/
			
			this.initContext = new InitialContext();
		    this.webContext = (Context)initContext.lookup("java:/comp/env");
		} 
		/*catch (IOException e) 
		{
			e.printStackTrace();
		}*/ 
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static DataSourceCache getInstance()
	{
		return instance;
	}
	
	public DataSource getSQLDataSource(String dbName)
	{
		
		try 
		{
		    dataSource = (DataSource) this.webContext.lookup ("jdbc/sqlserv_" + dbName);
			//dataSource = (DataSource) this.initContext.lookup ("jdbc/sqlserv_" + dbName);
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
		
		return dataSource;
	}
}
