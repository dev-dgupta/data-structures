package com.codeWithDivya;

/**
 * perfect number is equal to the sum of its proper divisors excluding the number itself. Let me cite an example to
 * help you understand it better. Let’s consider a few examples:
 * Example1: 6
 * Positive factors are; 1,2,3,6
 * Here, the sum of all the factors excluding the number itself is equal to 6.
 * Example2: 28
 * Positive factors are; 1,2,4,7,14,28
 * Again the sum of all the factors excluding the number itself comes out to be 28.
 */
public class PerfectNumberProblem {

    public static void main(String[] args) {
        PerfectNumberProblem perfectNumberProblem = new PerfectNumberProblem();
        System.out.println(perfectNumberProblem.isPerfectNumber(28));
        System.out.println(perfectNumberProblem.isPerfectNumber(19));
        System.out.println(perfectNumberProblem.isPerfectNumber(6));
        System.out.println(perfectNumberProblem.isPerfectNumber(21));
    }

    /*
    Complexity 0(n)
     */
    public boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum = sum + i;
            }
        }
        if (sum == n)
            return true;
        else return false;
    }
}
