package com.wireless.database.dao;

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
import org.springframework.stereotype.Component;

@Component("customerDataServicesDAO")
public class CustomerDataServicesDAO 
{
	private JdbcTemplate jdbcTemplate;
	//private NamedParameterJdbcTemplate jdbcTemplate;
	private CityStateSP sproc;
	
	public CustomerDataServicesDAO()
	{
		System.out.println("CustomerDataServicesDAO created");
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.sproc = new CityStateSP(this.jdbcTemplate.getDataSource());
		//this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	/*
	public List<ProductBean> getProducts()
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("productId", 6);
		
		String sql = "select top 10 productId, productDescription from dbo.product where productId = :productId";
		
		return this.jdbcTemplate.query(sql, params, new RowMapper<ProductBean>()	{
			
			public ProductBean mapRow(ResultSet rs, int rowNum) throws SQLException	{
				ProductBean product = new ProductBean();
				
				product.setId(rs.getInt("productId"));
				product.setDescription(rs.getString("productDescription"));
				
				return product;
			}
		});
	}
	*/
	
	public Map<String, String> getCityStateByZip(String zipcode)	
	{
		Map<String, Object> response = (Map<String, Object>) this.sproc.execute(zipcode);
		Map<String, String> result = new HashMap<String, String>();
		
		List<?> arrList = (ArrayList<?>) response.get("#result-set-1");

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) arrList.get(0);
		
		result.put("city", (String) map.get("city_state_name"));
		result.put("state", (String) map.get("state_abbrev"));
		
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
	
	/*
	public Map<String, String> getCityStateByZip(String zipcode)
	{
		String city = "";
		String state = "";
		
		Connection conn = null;
		CallableStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			//conn = getSQLConnection(SqlServerDAOFactory.DATABASE_NAME_CUSTOMERDATASERVICES);
			
			conn = this.dataSource.getConnection();
			st = conn.prepareCall("{call usp_get_cityStateInfo(?, ?)}");
			st.setString(1, zipcode);
			st.setString(2, "y");
			st.execute();
			
			rs = st.getResultSet();
			
			if(rs.next())	
			{
				city = rs.getString("city_state_name").trim();
				state = rs.getString("state_abbrev").trim();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("city", city);
		result.put("state", state);
		
		System.out.println("city = " + city);
		System.out.println("state = " + state);
		return result;
	}*/
}
