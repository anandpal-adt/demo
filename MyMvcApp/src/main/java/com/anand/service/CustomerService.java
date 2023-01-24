package com.anand.service;

import java.util.List;

import com.anand.entity.Customer;

public interface CustomerService {
	
		public  boolean Clogin(Customer customer);
        public void Cdetail(Customer customer);		
        List<Customer> getCdetails();
        public void Clikes(Customer customer);

}



