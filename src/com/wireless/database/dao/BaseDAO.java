package com.wireless.database.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class BaseDAO 
{
	public Connection getSQLConnection(String dbName) throws SQLException
	{
		DataSource dataSource = DataSourceCache.getInstance().getSQLDataSource(dbName);
		Connection conn = null;
		
		try
		{
			conn = dataSource.getConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void closeDBObjects(ResultSet rs, Statement st, Connection conn)
	{
		try 
		{
			if(rs != null)
			{
				rs.close();
			}
			
			if(st != null)
			{
				st.close();
			}
			
			if(conn != null)
			{
				conn.close();
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
