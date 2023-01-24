package com.anand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.anand.conn.MyConn;
import com.anand.entity.Car;
import com.anand.entity.Customer;
import com.anand.entity.User;
import com.mysql.jdbc.ResultSet;

public class CustomerDaoImple implements CustomerDao{

	private MyConn myConn;
	public CustomerDaoImple() {
		myConn=new MyConn();
	}

	@Override
	public boolean Clogin(Customer customer) {
		boolean flag=false;
		try {
			Connection con=myConn.getMyConn();
			PreparedStatement p=con.prepareStatement("select * from customer where cname=? and cpass=?");
			p.setString(1, customer.getCustomerName());
			p.setString(2, customer.getCustomerPass());
			ResultSet rs=(ResultSet) p.executeQuery();
			if(rs.next()) {
			flag=true;
			}
			con.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public void Cdetail(Customer customer) {
		
		try {
			Connection con=myConn.getMyConn();
			PreparedStatement s=con.prepareStatement("insert into customer(cname,cpass,cgmail) values(?,?,?)");
			s.setString(1,customer.getCustomerName());
			s.setString(2,customer.getCustomerPass());
			s.setString(3,customer.getCustomerEmail());
			int i=s.executeUpdate();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
		      e.printStackTrace();
		}		

		
	}

	@Override
	public List<Customer> getCdetails() {

		List<Customer> csms=new ArrayList<>();
		 try {
				Connection con=myConn.getMyConn();
				PreparedStatement s=con.prepareStatement("select * from interest");
			ResultSet rs=(ResultSet) s.executeQuery();
			while (rs.next()) {
				Customer customer=new Customer();
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerLike(rs.getInt(2));
				customer.setCustomerName(rs.getString(3));
				csms.add(customer);
			}
				con.close();
			} catch (SQLException | ClassNotFoundException e) {
			      e.printStackTrace();
			}	
		return csms;
	
	}

	@Override
	public void Clikes(Customer customer) {
		try {
			Connection con=myConn.getMyConn();
			PreparedStatement s=con.prepareStatement("insert into interest(liked_car_id,customer_name) values(?,?)");
			s.setInt(1,customer.getCustomerLike());
			s.setString(2,customer.getCustomerName());
			//s.setInt(3,customer.getCustomerId());
			s.executeUpdate();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
		      e.printStackTrace();
		}		
	}



}
