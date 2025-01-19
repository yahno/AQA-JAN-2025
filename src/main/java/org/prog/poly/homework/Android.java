package org.prog.poly.homework;

public class Android implements IPhone{
    @Override
    public void call() {
        System.out.println("Iphone call long");
    }
//sasa
    @Override
    public void unlock() {
        System.out.println("Iphone unlock by fingerprint");

    }
}
