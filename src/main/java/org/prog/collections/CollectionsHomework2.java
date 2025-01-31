package org.prog.collections;
import org.prog.parent.Car;
import java.util.*;

public class CollectionsHomework2 {
    public static void main(String[] args) {
        printDriversSharingCars();
    }

    private static void printDriversSharingCars() {
//      Car1 -> John
//      Car2 -> John, Jane
//      Car3 -> Jane
//      Car4 ->
//      Car5 -> Sarah, Peter
//      Car6 -> Peter
//      Car7 -> Bob
//      Car8 -> Ivy
//      expected result: Peter, Sarah, John, Jane

        Car car1 = new Car("Red");
        Car car2 = new Car("Blue");
        Car car3 = new Car("Black");
        Car car4 = new Car("Purple");
        Car car5 = new Car("Yellow");
        Car car6 = new Car("Green");
        Car car7 = new Car("Magenta");
        Car car8 = new Car("Grey");

        String john = "John";
        String jane = "Jane";
        String sarah = "Sarah";
        String peter = "Peter";
        String bob = "Bob";
        String ivy = "Ivy";
        Map<Car, List<String>> carToDriversMap = new HashMap<>();

        carToDriversMap.put(car1, List.of(john));
        carToDriversMap.put(car2, List.of(john, jane));
        carToDriversMap.put(car3, List.of(jane, sarah));
        carToDriversMap.put(car4, Collections.emptyList());
        carToDriversMap.put(car5, List.of(sarah, peter));
        carToDriversMap.put(car6, List.of(peter, john));
        carToDriversMap.put(car7, List.of(bob));
        carToDriversMap.put(car8, List.of(ivy));

        printListOfDriversSharingCars(carToDriversMap);
    }

    private static void printListOfDriversSharingCars(Map<Car, List<String>> carToDriversMap) {
        System.out.println("\nDrivers sharing cars:");
        Set<String> driversSharingCars = getListOfDriversSharingCars(carToDriversMap);
        for (String driver : driversSharingCars) {
            System.out.println(driver);
        }
        System.out.println("**********************");
    }

    private static Set<String> getListOfDriversSharingCars(Map<Car, List<String>> carToDriversMap) {
        Set driversSharingCars = new HashSet();
        for (Car car : carToDriversMap.keySet()) {
            List<String> drivers = carToDriversMap.get(car);
            if (drivers.size() > 1) {
                for (String driver : drivers) {
                    driversSharingCars.add(driver);
                }
            }
        }
        return driversSharingCars;
    }

}
