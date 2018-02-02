package com.trnet.spring.service;

import com.trnet.spring.model.Car;

import java.util.List;

public interface ICarService {

    public void addCar(Car car);
    public void updateCar(Car car);
    public List<Car> listCars();
    public void removeCar(int id);
}
