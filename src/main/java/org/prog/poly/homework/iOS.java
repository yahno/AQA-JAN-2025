package org.prog.poly.homework;

public class iOS implements IPhone{
    @Override
    public void call() {
        System.out.println("iOS call beautiful");
    }

    @Override
    public void unlock() {
        System.out.println("iOS unlock by eye");

    }
}
