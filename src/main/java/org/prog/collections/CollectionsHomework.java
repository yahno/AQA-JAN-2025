package org.prog.collections;

//TODO: write collection of cars (MAP/SET/LIST)
//TODO: WHERE: CAR CAN HAVE NO OWNER
//TODO: WHERE: CAR CAN HAVE 1 OR MORE OWNERS
//TODO: Write method that will print all owners sharing car

import org.prog.parent.Car;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Car1 -> John
 * Car2 -> John, Jane
 * Car3 -> Jane
 * Car4 ->
 * Car5 -> Sarah, Peter
 * Car6 -> Peter
 * Car7 -> Bob
 * Car8 -> Ivy
 * expected result: Peter, Sarah, John, Jane
 */

public class CollectionsHomework {

    public static void main(String[] args) {
        String car1 = "Car1";
        String car2 = "Car2";
        String car3 = "Car3";
        String car4 = "Car4";
        String car5 = "Car5";
        String car6 = "Car6";
        String car7 = "Car7";
        String car8 = "Car8";

        Map<String, List<Car>> ownedCars = new HashMap<>();
        ownedCars.put(car1, new ArrayList<>());
        ownedCars.put(car2, new ArrayList<>());
        ownedCars.put(car3, new ArrayList<>());
        ownedCars.put(car4, new ArrayList<>());
        ownedCars.put(car5, new ArrayList<>());
        ownedCars.put(car6, new ArrayList<>());
        ownedCars.put(car7, new ArrayList<>());
        ownedCars.put(car8, new ArrayList<>());

        ownedCars.get(car1).add(new Car("John"));

        ownedCars.get(car2).add(new Car("John"));
        ownedCars.get(car2).add(new Car("Jane"));

        ownedCars.get(car3).add(new Car("Jane"));

        ownedCars.get(car4).add(new Car(" "));

        ownedCars.get(car5).add(new Car("Sarah"));
        ownedCars.get(car5).add(new Car("Peter"));

        ownedCars.get(car6).add(new Car("Peter"));

        ownedCars.get(car7).add(new Car("Bob"));

        ownedCars.get(car8).add(new Car("Ivy"));

        printCarAndDrivers(car1, ownedCars);
        printCarAndDrivers(car2, ownedCars);
        printCarAndDrivers(car3, ownedCars);
        printCarAndDrivers(car4, ownedCars);
        printCarAndDrivers(car5, ownedCars);
        printCarAndDrivers(car6, ownedCars);
        printCarAndDrivers(car7, ownedCars);
        printCarAndDrivers(car8, ownedCars);

        countDriversForCar(car1, ownedCars);
        countDriversForCar(car2, ownedCars);
        countDriversForCar(car3, ownedCars);
        countDriversForCar(car4, ownedCars);
        countDriversForCar(car5, ownedCars);
        countDriversForCar(car6, ownedCars);
        countDriversForCar(car7, ownedCars);
        countDriversForCar(car8, ownedCars);

    }

    public static void printCarAndDrivers(String carName, Map<String, List<Car>> cars) {
        List<Car> carsOfOwner = cars.get(carName);
        for (int i = 0; i < carsOfOwner.size(); i++) {
            System.out.println(carName + " has " + carsOfOwner.get(i).color);
        }
    }
    public static void countDriversForCar(String carName, Map<String, List<Car>> cars) {
        List<Car> carsOfOwner = cars.get(carName);
        System.out.println(carName + " has " + carsOfOwner.size() + " drivers");
    }
}
