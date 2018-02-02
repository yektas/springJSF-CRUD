package com.trnet.managedBean;


import com.trnet.spring.model.Car;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;

@ManagedBean(name = "carMB")
@SessionScoped
public class CarMB {


    @Autowired
    FacesContext context;

    private String model;
    private String manufacturer;
    private int yearModel;
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearModel() {
        return yearModel;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    public void addCar(){

        Car car = new Car();
        car.setManufacturer(getManufacturer());
        car.setModel(getModel());
        car.setYearModel(getYearModel());

        try {
            InputStream input = getFile().getInputstream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/img");

    }
}
