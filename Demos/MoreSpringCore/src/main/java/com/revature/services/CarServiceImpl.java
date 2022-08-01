package com.revature.services;


import com.revature.daos.CarDAO;
import com.revature.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //this is where we could add 'extra functionality' separate from data management
public class CarServiceImpl implements CarService{

    CarDAO carDAO;

    //here we are using dependency injection
    //as a form of inversion of control

    //IoC - what is IOC - inversion of Control
    // responsibilities of object creation and injection of
    // the dependencies is given t the framework (ie Spring)
    //instead of the class creating the dependency objects by itself

    @Autowired //we have @Autowired here to let the IOC container know that this bean
    //is depending on the CarDAO 'bean'
    public CarServiceImpl(CarDAO carDAO){
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> getCars() {
        return carDAO.getAllCars();
    }
}
