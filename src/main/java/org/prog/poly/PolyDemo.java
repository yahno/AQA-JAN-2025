package org.prog.poly;

public class PolyDemo {

    public static void main(String[] args) {
        Ford ford = new Ford();
        BMW bmw = new BMW();
        Mazda mazda = new Mazda();
        Mazda6 mazda6 = new Mazda6();

        driveCar(ford);
        driveCar(bmw);
        driveCar(mazda);
        driveCar(mazda6);
    }

    public static void driveCar(ICar iCar) {
        iCar.accelerate();
        iCar.turnLeft();
        iCar.turnLeft();
        iCar.accelerate();
        iCar.turnRight();
        iCar.turnRight();
        iCar.slowDown();
        iCar.slowDown();
    }

    //accelerate
    //turn left
    //turn left
    //accelerate
    //turn right
    //turn right
    //slow down
    //slow down
}
