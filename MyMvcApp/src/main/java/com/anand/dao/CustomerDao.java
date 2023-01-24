package com.anand.dao;

import java.util.List;

import com.anand.entity.Customer;


public interface CustomerDao {
	boolean Clogin(Customer customer);
   void Cdetail(Customer customer);
   List<Customer> getCdetails();
   public void Clikes(Customer customer);
}
