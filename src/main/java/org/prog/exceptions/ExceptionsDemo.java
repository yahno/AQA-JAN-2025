package org.prog.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {

    public static void main(String[] args) throws FileNotFoundException {
//        Car carOne = new Car("red");
//        Car carTwo = new Car("blue");
//        Car carThree = new Car(null);
//
//        System.out.println(carThree.color.length());
//
//        carTwo.color = "red";
//
//        System.out.println(carOne.equals(carTwo));
//        System.out.println(carOne.hashCode());
//        System.out.println(carTwo.hashCode());

        smth1(null);
    }

    public static void smth1(String s) {
        smth2(s);
    }

    public static void smth2(String s) {
        try {
            smth3(s);
        } catch (Exception e) {
            System.out.println("OOPS!");
        }
    }

    public static void smth3(String s) {
        smth4(s);
    }

    public static void smth4(String s) {
        System.out.println(s.equals("a"));
    }

    public static void readFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader(new File("aaa.txt"));
    }
}
