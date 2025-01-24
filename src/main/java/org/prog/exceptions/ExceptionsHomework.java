package org.prog.exceptions;

import org.prog.parent.Car;

// TODO: write a method which ca cause NullPointerException
// TODO: write try-catch-finally to catch NPE
// TODO: on exception -> print "EXCEPTION CAUGHT!"
// TODO: always print "DONE TRY-CATCH-FINALLY"
public class ExceptionsHomework {
    public static void main(String[] args) {
        Car carOne = new Car("red");
        Car carTwo = new Car("blue");
        Car carThree = new Car(null);

        System.out.println(carThree.color.length());
    }
}
