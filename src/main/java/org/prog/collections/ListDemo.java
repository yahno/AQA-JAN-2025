package org.prog.collections;

import org.prog.parent.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        List<String> lList = new LinkedList<>();

        aList.add("Player 1");//0
        aList.add("Player 2");//1
        aList.add("Player 5");//1
        aList.add("Player 3");//3
        aList.add("Player 4000");//... +1
        //<<<<<<<<<<<<<//2

        lList.add("Player 1");//[start-of-list]-[1]-[2]
        lList.add("Player 2");//[1]-[2]-[4]
        lList.add("Player 4");//[2]-[4]-[3]
        lList.add("Player 3");//[4]-[3]-[end-of-list]
    }
}
