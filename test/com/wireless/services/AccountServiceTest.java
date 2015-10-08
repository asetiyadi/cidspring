package com.wireless.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wireless.domain.Account;

public class AccountServiceTest {

	private AccountService accountService;
	
	@Before
	public void setUp() throws Exception {
		accountService = new AccountService();
	}

	@Test
	public void testGetAccount() {
		Account account = accountService.getAccount("90976432689");
		
		System.out.println(account.toString());
		
		assertNotNull(account);
	}
}
