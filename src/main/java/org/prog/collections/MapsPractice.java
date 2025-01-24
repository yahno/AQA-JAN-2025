package org.prog.collections;

import org.prog.parent.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1. bind one person to a single car
// 2. bind one person to multiple cars
// 3. add logic to count cars for specific person

//TODO: Make cars unique for each drive

public class MapsPractice {

    public static void main(String[] args) {
        String driver1 = "John";
        String driver2 = "Jane";
        String driver3 = "Joe";

        Map<String, List<Car>> ownedCars = new HashMap<>();
        ownedCars.put(driver1, new ArrayList<>());
        ownedCars.put(driver2, new ArrayList<>());
        ownedCars.put(driver3, new ArrayList<>());

        ownedCars.get(driver1).add(new Car("Red"));
        ownedCars.get(driver1).add(new Car("Blue"));
        ownedCars.get(driver1).add(new Car("Black"));
        ownedCars.get(driver1).add(new Car("Purple"));

        ownedCars.get(driver2).add(new Car("Blue"));
        ownedCars.get(driver2).add(new Car("Yellow"));

        ownedCars.get(driver3).add(new Car("White"));

        countCarsForDriver(driver1, ownedCars);
        countCarsForDriver(driver2, ownedCars);
        countCarsForDriver(driver3, ownedCars);
    }

    public static void countCarsForDriver(String driverName, Map<String, List<Car>> cars) {
        List<Car> carsOfOwner = cars.get(driverName);
        System.out.println(driverName + " has access to " + carsOfOwner.size() + " cars");
    }
}
