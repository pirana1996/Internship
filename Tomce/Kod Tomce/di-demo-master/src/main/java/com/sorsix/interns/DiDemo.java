package com.sorsix.interns;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class DiDemo {
    public static void main(String[] args) {
        // Car car = CarFactory.createCar(CarFactory.EngineType.OTO, 100);
        /**
         * ApplicationContext==SpringContext
         * ApplicationContext is a container of object also referred as graph of objects.
         * Now we are creating context which is configured whit a class (AnnotationConfigApplicationContext).
         *
         */
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfiguration.class);

        Car car = context.getBean(Car.class);
        Bike bike = context.getBean(Bike.class);
        Parking parking = context.getBean(Parking.class);
        System.out.println(car);
        System.out.println(bike.getTransmission());
        System.out.println(parking);
    }
}
