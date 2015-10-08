package com.wireless.database.dao;

public abstract class DAOFactory 
{
	public static final int DBTYPE_SQLSERVER = 1;
	public static final int DBTYPE_ORACLE = 2;
	
	public static DAOFactory getDAOFactory(int dbFactoryType)
	{
		switch(dbFactoryType)
		{
			case DBTYPE_SQLSERVER:
				return new SqlServerDAOFactory();
			case DBTYPE_ORACLE:
				return null;		// this will be used for IPMDB
			default:
				return null;
		}
	}
}
