package org.prog.collections;

import org.prog.parent.Car;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, Car> cars = new HashMap<>();
        cars.put("John", new Car("red"));
        cars.put("Jane", new Car("blue"));
        cars.put("Joe", new Car("green"));
        cars.put(null, new Car("black"));

        Car johnCars = cars.get("John");
        Car notOwnedCar = cars.getOrDefault(null, new Car("purple"));
        Car unknown = cars.getOrDefault("unknown", new Car("white"));
        System.out.println(johnCars.color);
        System.out.println(notOwnedCar.color);
        System.out.println(unknown.color);
    }
}
