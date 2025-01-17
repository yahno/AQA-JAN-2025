package org.prog.cars;

import org.prog.parent.Car;

public class BigCar extends Car {

    public void dragAnotherCar() {
        System.out.println("Dragging another car..");
        thisIsOnlyForChildren();
    }

}
