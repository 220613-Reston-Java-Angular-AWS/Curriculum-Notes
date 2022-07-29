package com.revature.daos;

import com.revature.models.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // this annotation tell the IOC container that this class is
//a Persistence bean
public class CarDAOImpl implements CarDAO{

    /**
     @Component
     The @Component annotation is a generic Stereotype used to declare an object as a bean.
     This bean can be injected into other classes/beans at some point in the application.
     Spring also provides more specific use cases for @Component beans when the class serves a specific purpose
     For example:
     - a persistence class or a class that will be responsible for persisting data = @Repository
     - a service class = @Service
     - and a presentation class (i.e our servlets) = @Controller
     */



    @Override
    public List<Car> getAllCars() {

        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("Jetta","Volkswagen",2021,6);
        Car car2 = new Car("Elantra","Hyndai",2016,4);
        Car car3 = new Car("Camero","Chevy",2011,8);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        return cars;
    }
}
