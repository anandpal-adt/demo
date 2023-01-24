package com.anand.service;

import java.util.List;

import com.anand.dao.CustomerDao;
import com.anand.dao.CustomerDaoImple;
import com.anand.entity.Customer;

public class CustomerServiceImple implements CustomerService{

	CustomerDao customerDao;
	public CustomerServiceImple() {
      customerDao=new CustomerDaoImple();
	}
	
	@Override
	public boolean Clogin(Customer customer) {		
		return customerDao.Clogin(customer);
	}

	@Override
	public void Cdetail(Customer customer) {
     customerDao.Cdetail(customer);		
	}

	@Override
	public List<Customer> getCdetails() {
		return customerDao.getCdetails();
	}

	@Override
	public void Clikes(Customer customer) {
	customerDao.Clikes(customer); 
	}

	
}


