package com.cg.mvc.repo;

import java.math.BigDecimal;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.mvc.beans.Customer;
import com.cg.mvc.beans.Wallet;
@Transactional
@Repository("repo")
public class CustomerRepositoryImpl implements ICustomerRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Customer showBalance(String mobileNo) {
		Customer customer= entityManager.find(Customer.class, mobileNo);
			customer.setMobileNumber(mobileNo);
		return customer;
	}
	
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		withdrawAmount(sourceMobileNo,amount);
		depositAmount(targetMobileNo, amount);
		return entityManager.find(Customer.class, sourceMobileNo);
	}
	
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		Customer customer= entityManager.find(Customer.class, mobileNo);
		Wallet bal= customer.getWallet();
		bal.setBalance(bal.getBalance().add(amount));
		return customer;
	}
	
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		Customer customer= entityManager.find(Customer.class, mobileNo);
		Wallet bal= customer.getWallet();
		bal.setBalance(bal.getBalance().subtract(amount));
		return customer;
	}
	
	public Customer createAccount(Customer customer) {
		if(customer.getWallet().getBalance().equals(0))
		{
			
		}
		entityManager.persist(customer);
		entityManager.flush();
		return customer;
	}
	
	
}