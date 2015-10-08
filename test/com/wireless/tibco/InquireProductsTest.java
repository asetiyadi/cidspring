package com.wireless.tibco;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wireless.bean.ProductBean;

public class InquireProductsTest {

	private InquireProducts inquireProducts;
	
	@Before
	public void setUp() throws Exception {
		String salesChannel = "CID-CSR";
		String customerType = "S";
		String marketId = "330";
		String transactionType = "ACT";
		String deviceType = "VOICE";
		String[] accountTypes = {"P","O"};
		
		inquireProducts = new InquireProducts(salesChannel,customerType,marketId,transactionType,deviceType,accountTypes);
	}

	@Test
	public void testInquireProducts() {
		
	}

	@Test
	public void testGetServiceName() {
		System.out.println("ServiceName: " + inquireProducts.getServiceName());
	}

	@Test
	public void testInvokeService() throws Exception {
		HashMap<String, Object> response = inquireProducts.invokeService();
		
		@SuppressWarnings("unchecked")
		List<ProductBean> products = (List<ProductBean>) response.get("espResponseObject");
		for(int x=0; x < products.size(); x++)
		{
			System.out.println("ProductId: " + products.get(x).getProductId());
			System.out.println("ProductId: " + products.get(x).getProductName());
		}
	}
}
