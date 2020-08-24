package com.codeWithDivya.linkedlists;

public class CircularLinkedList {
    public static void main(String[] args) {
//        var origList = new LinkedListDS();
//        origList.addLast(10);
//        origList.addLast(20);
//        origList.addLast(30);
//        origList.addLast(40);
//        origList.addLast(50);
//        origList.print();
//        System.out.println(origList.isCircularLinkedList());
        System.out.println("---------------------");
       var origList = new LinkedListDS();
        origList.addInCircularList(10);
        origList.addInCircularList(20);
        origList.addInCircularList(30);
        origList.printForCircularList();
        System.out.println(origList.isCircularLinkedList());
    }
}
