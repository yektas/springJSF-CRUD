package com.trnet.spring.dao;

import com.trnet.spring.model.Car;

import java.util.List;

public interface ICarDao {

    public void createCar(Car car);
    public List<Car> getCars();
    public void deleteCar(int id);
    public void updateCar(Car car);

}
