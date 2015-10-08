package com.wireless.database.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDataServicesDAOTest {
	
	private CustomerDataServicesDAO cdsDao;
	private JdbcTemplate jdbc;
	private ApplicationContext context;
	//private DataSource dataSource;
	
	@Before
	public void setUp() throws Exception {
		//context = new ClassPathXmlApplicationContext("com/wireless/web/config/beans_standalone.xml");
		context = new FileSystemXmlApplicationContext("/WebContent/WEB-INF/wireless-servlet.xml");
	}

	/*
	@Test
	public void testGetCityStateByZip() {
		CDSDAO cdsDao = (CDSDAO) context.getBean("cdsDao");
		List<ProductBean> products = cdsDao.getProducts();
		
		for(ProductBean product: products)
		{
			System.out.println(product);
		}
	}
	*/
	
	@Test
	public void testGetProducts() {
		CustomerDataServicesDAO cdsDao = (CustomerDataServicesDAO) context.getBean("cdsDao");
		/*List<ProductBean> products = cdsDao.getProducts();
		
		for(ProductBean product: products)
		{
			System.out.println(product);
		}*/
		Map<String, String> result = new HashMap<String, String>();
		result = cdsDao.getCityStateByZip("80023");
		System.out.println("city: " + result.get("city"));
		System.out.println("state: " + result.get("state"));
	}
	
	/*
	@Autowired
	private void setDataSource(DataSource dataSource)
	{
		this.jdbc = new JdbcTemplate(dataSource);
	}
	*/
}
