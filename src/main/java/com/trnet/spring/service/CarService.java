package com.trnet.spring.service;

import com.trnet.spring.dao.ICarDao;
import com.trnet.spring.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class CarService implements ICarService {

    @Autowired
    ICarDao carDao;

    public void addCar(Car car) {
        carDao.createCar(car);
    }

    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

    public List<Car> listCars() {
        return carDao.getCars();
    }

    public void removeCar(int id) {
        carDao.deleteCar(id);
    }
}
