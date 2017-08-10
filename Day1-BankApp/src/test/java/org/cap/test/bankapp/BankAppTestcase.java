package org.cap.test.bankapp;

import static org.junit.Assert.*;

import org.cap.dto.Customer;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class BankAppTestcase {
	private AcccountService accountService;
	
	@Before
	public void setUp()
	{
		accountService = new AccountServiceImpl();
	}
	

	@Test
	public void test_add_numbers_method() {
		//fail("Not yet implemented");
		
		assertEquals(50, accountService.addNumbers(20, 30));		
	}
	
	@Test(expected=InvalidInitialAmountException.class)
	public void test_add_Acount_with_null_customer() throws InvalidInitialAmountException{
		//accountService =new AccountServiceImpl();
		Customer customer = new Customer();
		customer.setCustName("ABC");
		accountService.addAccount(customer,50);
	}

}
