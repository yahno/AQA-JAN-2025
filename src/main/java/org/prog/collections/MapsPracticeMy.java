package org.prog.collections;
import org.prog.parent.Car;
import org.prog.parent.Owner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1. bind one person to a single car
// 2. bind one person to multiple cars
// 3. add logic to count cars for specific person

//TODO: Make cars unique for each drive

public class MapsPracticeMy {
    public static void main(String[] args) {
        String car1 = "Red";
        String car2 = "Blue";
        String car3 = "Black";
        String car4 = "Purple";

        Map<String, List<Car>> ownedCars = new HashMap<>();
        ownedCars.put(car1, new ArrayList<>());
        ownedCars.put(car2, new ArrayList<>());
        ownedCars.put(car3, new ArrayList<>());
        ownedCars.put(car4, new ArrayList<>());

        ownedCars.get(car1).add(new Car("John"));
        ownedCars.get(car1).add(new Car("Jane"));
        ownedCars.get(car1).add(new Car("Joe"));


        ownedCars.get(car2).add(new Car("John"));
        ownedCars.get(car2).add(new Car("Jane"));

        ownedCars.get(car3).add(new Car("Joe"));

        ownedCars.get(car4).add(new Car("Alex"));

        countDriversForCar(car1, ownedCars);
        countDriversForCar(car2, ownedCars);
        countDriversForCar(car3, ownedCars);
        countDriversForCar(car4, ownedCars);
    }

    public static void countDriversForCar(String carColor, Map<String, List<Car>> cars) {
        List<Car> carsOfOwner = cars.get(carColor);
        System.out.println(carColor + " has " + carsOfOwner.size() + " owners");
    }
}
