package com.cg.mvc.repo;

import java.math.BigDecimal;

import com.cg.mvc.beans.Customer;

public interface ICustomerRepository {
	public Customer showBalance(String mobileNo);
	public Customer fundTransfer(String sourceMobileNo,String targetMobileNo,BigDecimal amount);
	public Customer depositAmount(String mobileNo,BigDecimal amount);
	public Customer withdrawAmount(String mobileNo,BigDecimal amount);
	public Customer createAccount(Customer customer);
	}
