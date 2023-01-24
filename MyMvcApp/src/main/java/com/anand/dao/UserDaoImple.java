package com.anand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.anand.conn.MyConn;
import com.anand.entity.User;
import com.mysql.jdbc.ResultSet;

public class UserDaoImple  implements UserDao{
    private MyConn myConn;
	
	public UserDaoImple() {
	myConn=new MyConn();
	}

	@Override
	public boolean login(User user) {
		boolean flag=false;
		try {
			Connection con=myConn.getMyConn();
			PreparedStatement p=con.prepareStatement("select * from user where name=? and password=?");
			p.setString(1, user.getName());
			p.setString(2, user.getPassword());
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

}
