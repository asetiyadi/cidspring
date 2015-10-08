package com.wireless.database.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

import com.wireless.database.dao.BaseDAO;
import com.wireless.database.dao.ICustomerDataServicesDAO;

@Service
public class CustomerDataServicesImpl extends BaseDAO implements ICustomerDataServicesDAO
{
	private JdbcTemplate jdbcTemplate;
	private CityStateSP sproc;
	
	public CustomerDataServicesImpl()
	{
		System.out.println("CustomerDataServicesImpl created");
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.sproc = new CityStateSP(this.jdbcTemplate.getDataSource());
	}
	
	@Override
	public Map<String, String> getCityStateByZip(String zipcode)	
	{
		Map<String, Object> response = (Map<String, Object>) this.sproc.execute(zipcode);
		Map<String, String> result = new HashMap<String, String>();
		
		List<?> arrList = (ArrayList<?>) response.get("#result-set-1");

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) arrList.get(0);
		
		result.put("city", ((String) map.get("city_state_name")).trim());
		result.put("state", ((String) map.get("state_abbrev")).trim());
		
		return result;
	}
	
	private class CityStateSP extends StoredProcedure
	{
		private static final String CITYSTATE_SP_NAME = "usp_get_cityStateInfo";
		
		public CityStateSP(DataSource dataSource)
		{
			super(dataSource, CITYSTATE_SP_NAME);
			
			declareParameter(new SqlParameter("zipcode", Types.VARCHAR));
			declareParameter(new SqlParameter("cityStateMailingNameIndicator", Types.CHAR));
			//declareParameter(new SqlOutParameter("result", Types.INTEGER));
			//declareParameter(new SqlOutParameter("state_abbrev", Types.VARCHAR));
			
			compile();
		}
		
		public Map<String, Object> execute(String zipcode)
		{
			Map<String, String> inParams = new HashMap<String, String>();
			inParams.put("zipcode", zipcode);
			inParams.put("cityStateMailingNameIndicator", "Y");
			
			Map<String, Object> result = super.execute(inParams);
			return result;
		}
	}
}
