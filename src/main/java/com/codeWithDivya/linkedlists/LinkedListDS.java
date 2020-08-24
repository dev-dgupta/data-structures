package com.codeWithDivya.linkedlists;

import java.util.NoSuchElementException;

public class LinkedListDS {


    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    /**
     * print all the nodes
     */
    public void print() {
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.value);
            currNode = currNode.next;
        }
    }

    public void printForCircularList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.value);
            if (currNode.next == tail) {
                System.out.println(currNode.next.value);
                break;
            }
            currNode = currNode.next;
        }
    }

    /**
     * this method add the item at the of the current list
     *
     * @param value
     */
    public void addLast(int value) {
        Node currNode = new Node(value);
        //check if list is empty, if yes make both head and last point to current node
        if (isEmpty()) {
            head = tail = currNode;
        }
        // add at last, means tail next will now be the current node and tail will be the current node
        else {
            tail.next = currNode;
            tail = currNode;
        }
    }

    /**
     * this method adds item in the beginning of the list
     *
     * @param value
     */
    public void addFirst(int value) {
        Node currNode = new Node(value);
//check if list is empty, if yes make both head and last point to current node
        if (isEmpty()) {
            head = tail = currNode;
        }
        // add at last, means tail next will now be the current node and tail will be the current node
        else {
            currNode.next = head;
            head = currNode;
        }
    }

    /**
     * returns index of value's first occurrence
     *
     * @param value
     * @return
     */
    public int indexOf(int value) {
        int index = 0;
        Node currNode = head;
        while (currNode.next != null) {
            if (value == currNode.value) {
                return index;
            }
            index++;
            currNode = currNode.next;
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    private boolean isEmpty() {
        return head == null;
    }

    /**
     * this method removes item from last
     *
     * @param value
     */
    public void remove(int value) {
        //check if list is empty
        if (isEmpty())
            throw new NoSuchElementException();
        //check if the value if first node
        if (value == head.value)
            removeFirst();
        else {
            Node currNode = head;
            Node prevNode = head;
            var isAvailable = false;
            while (currNode != null) {
                if (value == currNode.value) {
                    isAvailable = true;
                    prevNode.next = currNode.next;
                    currNode.next = null;
                    break;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
            if (!isAvailable)
                throw new NoSuchElementException();
        }
    }

    /**
     * this method removes item from last
     */
    public void removeLast() {
        //if list is empty
        if (isEmpty())
            throw new NoSuchElementException();
        //if only one node exists
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node prevNode = getPreviousNode(tail);
        prevNode.next = null;
        tail = prevNode;
    }

    private Node getPreviousNode(Node node) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.next == node)
                return currNode;
            currNode = currNode.next;
        }
        return null;
    }

    /**
     * this method removes item from first
     */
    public void removeFirst() {
        //if list is empty
        if (isEmpty())
            throw new NoSuchElementException();
        //if ponly one node exists
        if (head == tail) {
            head = tail = null;
            return;
        }

        Node currNode = head;
        head = head.next;
        currNode.next = null;
    }

    public void removeFirstOccurrence(int value) {
        remove(value);
    }

    public void removeLastOccurrence(int value) {
        if (isEmpty())
            throw new NoSuchElementException();

        //only one node
        if (value == head.value)
            removeFirst();
        else {
            Node currNode = head;
            Node prevNode = head;
            Node valuePrevNode = null;
            while (currNode != null) {
                if (value == currNode.value) {
                    valuePrevNode = prevNode;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
            if (valuePrevNode == null)
                throw new NoSuchElementException();
            else {
                currNode = valuePrevNode.next;
                valuePrevNode.next = currNode.next;
                currNode.next = null;
            }
        }
    }

    public void reverseList() {
        if (isEmpty() || head == tail)
            return;

        Node currNode = head.next;
        Node prevNode = head;
        tail = head;
        tail.next = null;
        while (currNode != null) {
            head = currNode;
            currNode = currNode.next;
            head.next = prevNode;
            prevNode = head;
        }
    }

    public void addInCircularList(int value) {
        addLast(value);
        tail.next = head;
    }

    public boolean isCircularLinkedList() {
        if (isEmpty())
            return false;

        if (head == tail)
            return true;
        if (head.next == tail && tail.next == head)
            return true;

        if (nextTwoPointersNotNull(head)) {
            Node currNode = head;
            Node nextNode = head.next.next;
            while (null != nextNode) {
                if (currNode.value == nextNode.value) {
                    return true;
                }
                currNode = currNode.next;
                if (nextTwoPointersNotNull(nextNode))
                    nextNode = nextNode.next.next;
                else
                    break;
            }
        }
        return false;
    }

    private boolean nextTwoPointersNotNull(Node currNode) {
        return null != currNode.next && null != currNode.next.next;
    }
}
