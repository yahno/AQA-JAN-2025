package org.prog.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("b");
        stringSet.add("c");
        stringSet.add("e");

        System.out.println(stringSet.size());
    }
}
