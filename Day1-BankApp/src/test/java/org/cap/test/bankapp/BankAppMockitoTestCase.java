package org.cap.test.bankapp;

import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dao.AccountDaoImpl;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InsufficientBalanceException;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BankAppMockitoTestCase {

	@Mock
	private AccountDao acccountDao;
	private AcccountService accountService;
	
	@Before
	public void setUp(){
	MockitoAnnotations.initMocks(this);	
	accountService =new AccountServiceImpl(acccountDao);
	}
	
	@Test
	public void test_findAccById() {
		Account account = new Account();
		account.setAccountNo(1101);
		Customer customer = new Customer();
		customer.setCustName("Mohin");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		account.setAmount(30000);
		
		//Declaration
		Mockito.when(acccountDao.findAccountById(1101)).thenReturn(account);
		
		
		//Actual
		accountService.findAccountById(1101);
		
		//Verification
		Mockito.verify(acccountDao).findAccountById(1101);
	}
	
	@Ignore
	@Test
	public void test_withdraw() throws InsufficientBalanceException{
		Account account = new Account();
		account.setAccountNo(1101);
		Customer customer = new Customer();
		customer.setCustName("Mohin");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		account.setAmount(30000);
		
		Mockito.when(acccountDao.findAccountById(1101)).thenReturn(account);
		
		Account result = accountService.withdraw(1101, 3000);
		
		System.out.println(result);
		System.out.println(result.getAmount());
		
		Mockito.verify(acccountDao).findAccountById(1101);
		
	}
	
	@Test
	public void test_Accountno() throws InvalidInitialAmountException{
		
		Account account = new Account();
		//account.setAccountNo(1101);
		Customer customer = new Customer();
		customer.setCustName("Mohinuddinsha");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		account.setAmount(30000);
		
		//declaration
		Mockito.when(acccountDao.createAccount(account)).thenReturn(true);
		
		Account new_acc=accountService.addAccount(customer, 500);
		
		Mockito.verify(acccountDao).createAccount(account);
	}

}
