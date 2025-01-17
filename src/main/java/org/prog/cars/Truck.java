package org.prog.cars;

public class Truck extends BigCar {

    public void transportCargo() {
        System.out.println("Transporting cargo...");
        thisIsOnlyForChildren();
    }

    @Override
    public void turnSomewhere() {
        System.out.println("Long Car is turning somewhere");
    }
}
