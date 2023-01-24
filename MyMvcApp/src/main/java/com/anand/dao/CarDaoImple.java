package com.anand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anand.conn.MyConn;
import com.anand.entity.Car;
import com.mysql.jdbc.ResultSet;

public class CarDaoImple implements CarDao {
    private MyConn myConn;
	public CarDaoImple() {
     myConn =new MyConn(); 
	}

	@Override
	public void save(Car car) {
     try {
		Connection con=myConn.getMyConn();
		PreparedStatement s=con.prepareStatement("insert into car(car_model,car_price,car_color,car_reg_year) values(?,?,?,?)");
		s.setString(1,car.getModel());
		s.setFloat(2,car.getPrice());
		s.setString(3,car.getColor());
		s.setString(4,car.getRegDate());
		int i=s.executeUpdate();
		con.close();
	} catch (SQLException | ClassNotFoundException e) {
	      e.printStackTrace();
	}		
	}

	@Override
	public List<Car> selectAll() {
		List<Car> cars=new ArrayList<>();
		 try {
				Connection con=myConn.getMyConn();
				PreparedStatement s=con.prepareStatement("select * from car");
			ResultSet rs=(ResultSet) s.executeQuery();
			while (rs.next()) {
				Car car=new Car();
				car.setCarId(rs.getInt(1));
				car.setModel(rs.getString(2));
				car.setPrice(rs.getFloat(3));
				car.setColor(rs.getString(4));
				car.setImage(rs.getString(5));
				car.setRegDate(rs.getString(6));
				cars.add(car);
			}
				con.close();
			} catch (SQLException | ClassNotFoundException e) {
			      e.printStackTrace();
			}	
		return cars;
	}

	@Override
	public void delete(int carId) {
		 try {
				Connection con=myConn.getMyConn();
				PreparedStatement s=con.prepareStatement("delete from car where car_id=?");
				s.setInt(1, carId);
			int i=s.executeUpdate();
			con.close();
			} catch (SQLException | ClassNotFoundException e) {
			      e.printStackTrace();
			}	
			
	}

	@Override
	public Car select(int carId) {
		Car car=new Car();
		
		try {
			Connection con=myConn.getMyConn();
			PreparedStatement s=con.prepareStatement("select * from car where car_id = ?");
			s.setInt(1, carId);
		ResultSet rs=(ResultSet) s.executeQuery();
		while (rs.next()) {
			car.setCarId(rs.getInt(1));
			car.setModel(rs.getString(2));
			car.setPrice(rs.getFloat(3));
			car.setColor(rs.getString(4));
			car.setImage(rs.getString(5));
			car.setRegDate(rs.getString(6));
			
		}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
		      e.printStackTrace();
		}	
		return car;
	}

	@Override
	public void update(Car car) {
		try {
			Connection con = myConn.getMyConn();
			PreparedStatement s = con.prepareStatement("update car set car_model=?, car_price=?, car_color=?, car_reg_year=? where car_id = ?");
			s.setString(1, car.getModel());
			s.setFloat(2, car.getPrice());
			s.setString(3, car.getColor());
			s.setString(4, car.getRegDate());
			s.setInt(5, car.getCarId());
		    s.executeUpdate();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addImage(int carId, String image) {
    try {
	Connection con=myConn.getMyConn();
	PreparedStatement s=con.prepareStatement("update car set image=? where car_id=?");
	s.setString(1, image);
	s.setInt(2, carId);
	int i=s.executeUpdate();
	con.close();
      }  catch (Exception e) {
	  e.printStackTrace();
      }		
	}	
}
