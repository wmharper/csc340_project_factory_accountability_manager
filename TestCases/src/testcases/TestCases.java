/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testcases;

/**
 *
 * @author Billy
 */
public class TestCases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = -195;
        System.out.println("n =  " + n);
        System.out.println("result of 1:  " + functionI(n));
        System.out.println("result of 2:  " + functionII(n));
        System.out.println("result of 3:  " + functionIII(n));
        System.out.println("result of 4:  " + functionIV(n));
    }

    public static int functionI(int n) {
        int notLastDigit = n / 10;
        int lastDigit = n % 10;
        if (lastDigit < 5) {
            return notLastDigit * 10;
        } else {
            return notLastDigit * 10 + 10;
        }
    }

    public static int functionII(int n) {
        if (n < 0) {
            return (n - 5) / 10 * 10;
        } else {
            return (n + 5) / 10 * 10;
        }
    }

    public static int functionIII(int n) {
        return (n + 5) / 10 * 10;
    }

    public static int functionIV(int n) {
        int notLastDigit = n / 10;
        int lastDigit = n % 10;
        if (n > 0 && lastDigit < 5) {
            notLastDigit = notLastDigit * 10;
        } else if (n > 0 && lastDigit > 5) {
            notLastDigit = notLastDigit * 10 + 10;
        } else if (n < 0 && lastDigit > -5) {
            notLastDigit = notLastDigit * 10;
        } else if (n < 0 && lastDigit < -5) {
            notLastDigit = notLastDigit * 10 - 10;
        }
        return notLastDigit;
    }

}
