package com.codeWithDivya.linkedlists;

public class ReverseLinkedList {

    public static void main(String args[]) {
        var origList = new LinkedListDS();
        origList.addLast(10);
        origList.addLast(20);
        origList.addLast(30);
        origList.addLast(40);
        origList.addLast(50);
        origList.print();

        System.out.println("---------------------");

        origList.reverseList();
        origList.print();
    }




}
