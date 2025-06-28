package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        for (int i = 0; i < c.size(); i++) {
            c.set(i, c.get(i) * 2);
        }
        System.out.println("c = " + c);
    }
}