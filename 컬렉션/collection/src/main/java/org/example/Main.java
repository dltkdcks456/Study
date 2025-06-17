package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));

        // 멱집합 생성
        Collection<Set<Integer>> powerSet = PowerSet.of(set);

        // 멱집합 출력
        System.out.println("Power Set:");
        for (Set<Integer> subset : powerSet) {
            System.out.println(subset);
        }
    }
}