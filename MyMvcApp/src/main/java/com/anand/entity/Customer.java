package com.anand.entity;

public class Customer {
      private int customerId;
      private   String customerName;
      private String customerPass;
      private String customerEmail;
      private int customerLike;
       

	public Customer() {
		}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPass() {
		return customerPass;
	}

	public void setCustomerPass(String customerPass) {
		this.customerPass = customerPass;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getCustomerLike() {
		return customerLike;
	}

	public void setCustomerLike(int customerLike) {
		this.customerLike = customerLike;
	}
}
