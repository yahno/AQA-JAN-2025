package org.prog;

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
    ###############10#########################
     */
    public static void main(String[] args) {
        Car carOne = new Car();
        Car carTwo = new Car();
        Car thatCar = carOne;
        Car aliceCar = carTwo;

        carOne.color = "red";
        carTwo.color = "blue";
        thatCar.color = "black";

        carOne.goTo();
        carTwo.goTo();

        paintCar(carOne, "white");
        paintCar(carTwo, "Purple");

        thatCar.goTo();
        aliceCar.goTo();

        int i = 10;
        increaseI(i);
        System.out.println(i);

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
