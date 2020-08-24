package com.codeWithDivya.arrays;

public class ArrayMain {

    public static void main(String[] args) {
	// write your code here

        Array arr= new Array(3);
        arr.insert(10);
        arr.insert(20);
        arr.insert(30);
        arr.insert(40);
        arr.insert(50);
        arr.print();
        System.out.println("-------------------------------");
        arr.removeAt(3);

        System.out.println(arr.indexOf(40));
        System.out.println(arr.indexOf(50));

        arr.remove(20);
        arr.print();
    }
}
