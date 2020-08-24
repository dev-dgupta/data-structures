package com.codeWithDivya;

/**
 * Given two digits, find previous and next numbers consisting of only those numbers
 * for e.g
 * if n=123
 * and digits are 3,5
 * then,
 * previous lucky number=55
 * and next=333
 */
public class LuckyNumberProblem {

    public static void main(String[] args) {
        LuckyNumberProblem luckyNumberProblem = new LuckyNumberProblem();
        luckyNumberProblem.getLuckyNumbers(123, 3, 5);
    }

    private void getLuckyNumbers(int n, int a, int b) {

        //find smallest of a,b
        int smallest = Math.min(a, b);
        int maximum = Math.min(a, b);
        int firstDigit = 0;
        int count = 1;
        while (n / 10 != 0) {
            //count number of digits in n
            count++;
            firstDigit = n / 10;
        }
        int totalDigits = 0;
        //if first digits<a , then n-1 digits in previous
        if (firstDigit < smallest) {
            int previous = 0;
            for (int i = 0; i < count; i++) {
                previous = previous + (int) (maximum * Math.pow(10, i));
            }
            System.out.println("Previous:" + previous);
        }

        if (firstDigit > maximum) {
            int next = 0;
            for (int i = 0; i <= count+1; i++) {
                next = next + (int) (smallest * Math.pow(10, i));
            }
            System.out.println("Previous:" + next);
        }



    }
}
