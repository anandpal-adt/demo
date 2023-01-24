package com.anand.service;

import java.util.List;

import com.anand.entity.Car;

public interface CarService {
	 void add(Car car);
     List<Car> getAll();
     void remove(int carId);
     Car get(int carId);
     void modify(Car car);
     void addImage(int carId,String image);
}
