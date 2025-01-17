package org.prog.poly;

public class Mazda implements ICar {
    @Override
    public void turnRight() {
        System.out.println("Mazda is turning right");
    }

    @Override
    public void turnLeft() {
        System.out.println("Mazda is turning left");
    }

    @Override
    public void accelerate() {
        System.out.println("Mazda is accelerating");
    }

    @Override
    public void slowDown() {
        System.out.println("Mazda is slowing down");
    }
}
