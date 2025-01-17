package org.prog.poly;

public class BMW implements ICar {
    @Override
    public void turnRight() {
        System.out.println("BMW is turning right");
    }

    @Override
    public void turnLeft() {
        System.out.println("BMW is turning left");
    }

    @Override
    public void accelerate() {
        System.out.println("BMW is accelerating");
    }

    @Override
    public void slowDown() {
        System.out.println("BMW is slowing down");
    }
}
