package com.trnet.managedBean;


import com.trnet.spring.model.Car;
import com.trnet.spring.model.Logo;
import com.trnet.spring.service.ICarService;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "carMB")
@SessionScoped
public class CarMB implements Serializable{


    @ManagedProperty(value = "#{carService}")
    ICarService carService;

    private String model;
    private int yearModel;
    private List<Logo> logos;
    private Logo selectedLogo;
    private Car selectedCar;

    private List<Car> carList;

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(CarMB.class);

    @PostConstruct
    public void init() {
        this.logos = new ArrayList<Logo>();
        logos.add(new Logo(1, "Aston Martin", "Aston-Martin.jpg"));
        logos.add(new Logo(2, "Bentley", "Bentley.jpg"));
        logos.add(new Logo(3, "BMW", "BMW.jpg"));
        logos.add(new Logo(4, "Bugatti", "Bugatti.jpg"));
        logos.add(new Logo(5, "Cadillac", "Cadillac.jpg"));
        logos.add(new Logo(6, "Chevrolet", "Chevrolet.jpg"));
        logos.add(new Logo(7, "Ferrari", "Ferrari.jpg"));
        logos.add(new Logo(8, "Ford", "Ford.jpg"));
        logos.add(new Logo(9, "Honda", "Honda.jpg"));
        logos.add(new Logo(10, "Hyundai", "Hyundai.jpg"));
        logos.add(new Logo(11, "Jaguar", "Jaguar.jpg"));
        logos.add(new Logo(12, "Lamborghini", "Lamborghini.jpg"));
        logos.add(new Logo(13, "Maserati", "Maserati.jpg"));
        logos.add(new Logo(14, "Mercedes-Benz", "Mercedes-Benz.jpg"));
        logos.add(new Logo(15, "Nissan", "Nissan.jpg"));
        logos.add(new Logo(16, "Porsche", "Porsche.jpg"));
        logos.add(new Logo(17, "Rolls-Royce", "Rolls-Royce.jpg"));
        logos.add(new Logo(18, "Toyota", "Toyota.jpg"));
        logos.add(new Logo(19, "Volkswagen", "Volkswagen.jpg"));
    }

    public void addCar() {
        Car car = new Car();
        car.setModel(getModel());
        car.setYearModel(getYearModel());
        car.setLogo(getSelectedLogo().getPath());
        car.setManufacturer(getSelectedLogo().getName());

        carService.addCar(car);

        // logs debug
        if (logger.isDebugEnabled()) {
            logger.debug("CarMB.process()");
        }

        // logs exception
        logger.error("This is Error message for CarMB", new Exception("CarMB Logs"));

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", getModel() + " is added!"));
    }

    public void retrieveCarList() {
        setCarList(carService.listCars());
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("carList.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateCar() {
        Car updatedCar = new Car();
        updatedCar.setId(getSelectedCar().getId());
        updatedCar.setManufacturer(getSelectedCar().getManufacturer());
        updatedCar.setLogo(getSelectedCar().getLogo());
        updatedCar.setModel(getSelectedCar().getModel());
        updatedCar.setYearModel(getSelectedCar().getYearModel());
        carService.updateCar(updatedCar);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", "Car with id" + updatedCar.getId() + "is updated!"));
    }

    public void deleteCar() {
        int carId = getSelectedCar().getId();
        carService.removeCar(carId);

        //Update car list
        setCarList(carService.listCars());

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", "Car with id " + carId + " is deleted!"));

    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    public Logo getSelectedLogo() {
        return selectedLogo;
    }

    public void setSelectedLogo(Logo selectedLogo) {
        this.selectedLogo = selectedLogo;
    }

    public List<Logo> getLogos() {
        return logos;
    }

    public void setLogos(List<Logo> logos) {
        this.logos = logos;
    }

    public ICarService getCarService() {
        return carService;
    }

    public void setCarService(ICarService carService) {
        this.carService = carService;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearModel() {
        return yearModel;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }


}