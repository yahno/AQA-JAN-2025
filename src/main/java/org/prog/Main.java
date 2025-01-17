package org.prog;

import org.prog.cars.BigCar;
import org.prog.cars.BigTruck;
import org.prog.cars.Truck;
import org.prog.parent.Car;

public class Main {

    /*
    ##########################################
    #####[carOne.color]#######################
    ##########################################
    ##########[carTwo.color]##################
    ##########################################
    ##########################################
    ##########################################
    ##########################################
    ##1############10#########################
     */
    public static void main(String[] args) {
        Car carOne = new Car();
        BigCar bigCar = new BigCar();
        Truck truck = new Truck();
        BigTruck bigTruck = new BigTruck();
        carOne.color = "white";
        bigCar.color = "black";
        truck.color = "yellow";
        bigTruck.color = "blue";

//        carOne.turnSomewhere();
//        bigCar.turnSomewhere();
//        truck.turnSomewhere();
//        bigTruck.turnSomewhere();

        carOne.goTo();
        carOne.goTo("Odessa");
        carOne.goTo("Odessa", "Lviv");
        carOne.goTo("Odessa", "Lviv", "Dnipro");


//
//        carOne.goTo();
//        truck.goTo();
//        bigTruck.goTo();
//
//        bigCar.dragAnotherCar();
//        truck.dragAnotherCar();
//        bigTruck.dragAnotherCar();
//
//        truck.transportCargo();
//        bigTruck.transportCargo();
//        carOne.color = "red";
//        carTwo.color = "blue";
//        thatCar.color = "black";
//
//        carOne.goTo();
//        carTwo.goTo();
//
//        paintCar(carOne, "white");
//        paintCar(carTwo, "Purple");
//
//        thatCar.goTo();
//        aliceCar.goTo();
//
//        int i = 10;
//        increaseI(i);
//        System.out.println(i);

//        System.out.println("Car 1 color " + carOne.color);
//        System.out.println("Car 2 color " + carTwo.color);
    }

    public static void increaseI(int i) {
        i += 100;
        System.out.println(i);
    }

    public static void paintCar(Car carToPaint, String color) {
        if (color.equals("white")) {
            System.out.println("we're out of white paint!");
        } else {
            carToPaint.color = color;
        }
    }
}
