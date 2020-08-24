package com.codeWithDivya.arrays;

public class Array {
    private int[] itemArray;
    private int count = 0;

    public Array(int size) {
        itemArray = new int[size];
    }

    //indexOf
    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (item == itemArray[i])
                return i;
        }
        return -1;
    }

    //removeAt
    public void removeAt(int index) {
        //if index does not exists
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        //remove in array means shifting all elements after the index to left
        for (int i = index; i < count; i++)
            itemArray[i] = itemArray[i + 1];

        //this is for the last element that has been added to its left index but not removed from last
        count--;
    }

    public void remove(int item) {
        int index = indexOf(item);
        if (index == -1)
            System.out.println(item + "does not exists");
        else
            removeAt(index);
    }

    //insert
    public void insert(int item) {
        //if the array is full,resize it
        if (count == itemArray.length) {
            int[] newItemArray = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItemArray[i] = itemArray[i];
            }
            itemArray = newItemArray;
        }
        itemArray[count++] = item;
    }

    //print
    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(itemArray[i]);
    }


}
