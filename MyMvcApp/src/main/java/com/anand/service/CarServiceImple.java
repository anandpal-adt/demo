package com.anand.service;

import java.util.List;
import com.anand.dao.CarDao;
import com.anand.dao.CarDaoImple;
import com.anand.entity.Car;

public class CarServiceImple implements CarService{

	private CarDao carDao;
	
	public CarServiceImple() {
		carDao =new CarDaoImple();
	}

	@Override
	public void add(Car car) {
		carDao.save(car);
		
	}

	@Override
	public List<Car> getAll() {
			return carDao.selectAll();
	}

	@Override
	public void remove(int carId) {
		carDao.delete(carId);
	}

	@Override
	public Car get(int carId) {
			return carDao.select(carId);
	}

	@Override
	public void modify(Car car) {
		carDao.update(car);
	}

	@Override
	public void addImage(int carId, String image) {
		carDao.addImage(carId,image);
	}

}
