package com.wireless.tibco.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.ProductInfo;
import com.wireless.bean.ProductBean;

public class ParseInquireProducts 
{
	public static List<ProductBean> parseInquireProducts(ProductInfo[] data)
	{
		List<ProductBean> products = new ArrayList<ProductBean>();
		Set<String> productSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		List<String> productList = new ArrayList<String>();
		
		for(int x=0; x < data.length; x++)
		{
			if(!productSet.contains((String) data[x].getParentProductName()))
			{
				ProductBean productBean = new ProductBean();
				productBean.setProductId(data[x].getParentProductId());
				productBean.setProductName(data[x].getParentProductName());
				
				products.add(productBean);
				productSet.add(data[x].getParentProductName());
				productList.add(data[x].getParentProductName());
			}
		}
		
		return products;
	}
}
