package org.prog.poly;

public class Ford implements ICar {
    @Override
    public void turnRight() {
        System.out.println("Ford is turning right");
    }

    @Override
    public void turnLeft() {
        System.out.println("Ford is turning left");
    }

    @Override
    public void accelerate() {
        System.out.println("Ford is accelerating");
    }

    @Override
    public void slowDown() {
        System.out.println("Ford is slowing down");
    }
}
