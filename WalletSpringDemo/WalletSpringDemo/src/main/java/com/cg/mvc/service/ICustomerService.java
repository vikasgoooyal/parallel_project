package com.cg.mvc.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.mvc.beans.Customer;

	public interface ICustomerService {
		public Customer showBalance(String mobileNo);
		public Customer fundTransfer(String sourceMobileNo,String targetMobileNo,BigDecimal amount);
		public Customer depositAmount(String mobileNo,BigDecimal amount);
		public Customer withdrawAmount(String mobileNo,BigDecimal amount);
		public Customer createAccount(Customer customer);
		
	}