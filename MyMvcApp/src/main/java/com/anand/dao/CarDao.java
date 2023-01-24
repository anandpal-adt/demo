package com.anand.dao;

import java.util.List;

import com.anand.entity.Car;

public interface CarDao {
void save(Car car);
List<Car> selectAll();
void delete(int carId);
Car select(int carId);
void update(Car car);
void addImage(int carId,String image);
}
