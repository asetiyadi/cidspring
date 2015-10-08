package com.wireless.tibco;

import org.junit.Before;
import org.junit.Test;

import com.wireless.bean.ResponseBean;
import com.wireless.domain.Account;

public class InquireAccountTest {

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@Test
	public void test() {
		InquireAccount inquireAccount = new InquireAccount("90976432689");
		
		ResponseBean response = inquireAccount.invokeService();
		Account account = (Account) response.getObject();
		
		System.out.println(account.toString());
	}

}
