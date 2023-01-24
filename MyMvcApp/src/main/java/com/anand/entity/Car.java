package com.anand.entity;

public class Car {
    private int carId; 
	private String model;
	private float price;
	private String color;
	private String image;
	private String regDate;
	public Car() {
		
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getCarId() {
		return carId;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPrice() {
		return price;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRegDate() {
		return regDate;
	}
}
