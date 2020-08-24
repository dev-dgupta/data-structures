package com.codeWithDivya;

import java.util.Arrays;
import java.util.Comparator;

public class MySort {
    public static void main(String[] args) {
        String[] cities = {"b", "p", "s", "n"};
        MySorts ms = new MySorts();
        Arrays.sort(cities, ms);
        System.out.println(Arrays.binarySearch(cities, "n"));
    }

    static class MySorts implements Comparator {

        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }

        @Override
        public int compare(Object o1, Object o2) {
            return compare(o1.toString(),o2.toString());
        }
    }
}