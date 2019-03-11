package com.cg.mvc.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mvc.beans.Customer;
import com.cg.mvc.service.ICustomerService;

@RestController
public class MyRestController {
	
	@Autowired
	ICustomerService service;
	
	public ICustomerService getService() {
		return service;
	}

	public void setService(ICustomerService service) {
		this.service = service;
	}
	@RequestMapping(value="/createAccount",consumes="application/json",
			produces="application/json",method=RequestMethod.POST)
	public Customer createAccount(@RequestBody Customer customer )
	{
		customer=service.createAccount(customer);
		return customer;

	}
	@RequestMapping(value="/showBalance/{mobileNo}",produces="application/json")
	public Customer showBalance(@PathVariable String mobileNo)
	{
		Customer customer=service.showBalance(mobileNo);
		return customer;
	}
	@RequestMapping(value="/depositAmount/{mobileNo}/{balance}",produces="application/json")
	public Customer depositAmount(@PathVariable BigDecimal balance ,@PathVariable String mobileNo)
	{
		Customer customer=service.depositAmount(mobileNo, balance);
		return customer;
	}
	@RequestMapping(value="/withdrawAmount/{mobileNo}/{balance}",produces="application/json")
	public Customer withdrawAmount(@PathVariable BigDecimal balance ,@PathVariable String mobileNo)
	{
		Customer customer=service.withdrawAmount(mobileNo, balance);
		return customer;
	}
	@RequestMapping(value="/fundTransfer/{sourcemobileno}/{targetmobileno}/{balance}",produces="application/json")
	public Customer fundTransfer(@PathVariable BigDecimal balance ,@PathVariable String sourcemobileno,@PathVariable String targetmobileno)
	{
		Customer customer=service.fundTransfer(sourcemobileno, targetmobileno, balance);
		return customer;
	}
}