package com.revature.driver;

import com.revature.models.Car;
import com.revature.services.CarService;
import com.revature.services.CarServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    static ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

    public static void main(String[] args) {

        CarService carService = appContext.getBean(CarServiceImpl.class);

        List<Car> cars = carService.getCars();

        for (Car car: cars){
//            log.debug();
            log.info(car.toString());
//            log.warn();
//            log.error(e.getMessage());
//            log.fatal();
        }
    }

}
