package com.cg.mvc.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mvc.beans.Customer;
import com.cg.mvc.beans.Wallet;
import com.cg.mvc.repo.CustomerRepositoryImpl;
import com.cg.mvc.repo.ICustomerRepository;


@Transactional
@Service("service")
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	ICustomerRepository repo;
	
	public ICustomerRepository getRepo() {
		return repo;
	}

	public void setRepo(ICustomerRepository repo) {
		this.repo = repo;
	}

	@Override
	public Customer showBalance(String mobileNo) {
		return repo.showBalance(mobileNo);
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		return repo.fundTransfer(sourceMobileNo, targetMobileNo, amount);
	}

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		return repo.depositAmount(mobileNo, amount);
	}

	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		return repo.withdrawAmount(mobileNo, amount);
	}

	@Override
	public Customer createAccount(Customer customer) {
		return repo.createAccount(customer);
	}

	}