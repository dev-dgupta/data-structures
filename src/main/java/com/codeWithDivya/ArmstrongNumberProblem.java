package com.codeWithDivya;

/**
 * A positive integer is called an Armstrong number (of order n) if
 * <p>
 * abcd... = an + bn + cn + dn +
 * In the case of an Armstrong number of 3 digits, the sum of cubes of each digit is equal to the number itself. For example, 153 is an Armstrong number because
 * <p>
 * 153 = 1*1*1 + 5*5*5 + 3*3*3
 */
public class ArmstrongNumberProblem {

    public static void main(String[] args) {
        ArmstrongNumberProblem armstrongNumberProblem = new ArmstrongNumberProblem();
        System.out.println(armstrongNumberProblem.isArmstrongNumber(153));
        System.out.println(armstrongNumberProblem.isArmstrongNumber(13));
        System.out.println(armstrongNumberProblem.isArmstrongNumber(5678));
    }

    boolean isArmstrongNumber(int n) {
        int sum = 0;
        int number = n;
        while (number / 10 != 0) {
            int i = number % 10;
            sum = (int) (sum + Math.pow(i, 3));
            number = number / 10;
        }
        sum = (int) (sum + Math.pow(number, 3));
        if (sum == n)
            return true;
        else return false;
    }
}
