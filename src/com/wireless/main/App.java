package com.wireless.main;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wireless.database.dao.CustomerDataServicesDAO;

public class App {

	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("com/wireless/web/config/beans_standalone.xml");
		
		CustomerDataServicesDAO cdsDao = (CustomerDataServicesDAO) context.getBean("cdsDao");
		
		/*
		List<ProductBean> products = cdsDao.getProducts();
		
		for(ProductBean product: products)
		{
			System.out.println(product);
		}
		*/
		
		Map<String, String> result = cdsDao.getCityStateByZip("80023");
		System.out.println("city: " + result.get("city"));
		System.out.println("state: " + result.get("state"));
	}

}
