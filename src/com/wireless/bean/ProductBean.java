package com.wireless.bean;

import java.io.Serializable;

public class ProductBean implements Serializable
{
	private static final long serialVersionUID = -728745158284902567L;
	
	int productId;
	String productName;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", productName="
				+ productName + "]";
	}
	
}
