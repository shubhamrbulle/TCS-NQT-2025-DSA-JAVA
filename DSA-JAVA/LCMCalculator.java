/* Find LCM Using Formula
 * Given two integers A and B, find their LCM (Least Common Multiple) using the formula:
 * LCM(A, B) = (A * B) / GCD(A, B)
 * where GCD(A, B) is the Greatest Common Divisor of A and B.
 * INPUT1: 8 1000000000
 * OUTPUT1: 1000000000
 * INPUT2: 999999999 1000000000
 * OUTPUT2: 999999999000000000
 */

import java.util.Scanner;

public class LCMCalculator {

    //Function to calculate GCD using Euclidean algorithm
    public static long gcd(long a, long b){
        while(b!=0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    //Function to calculate LCM using formula
    public static long lcm(long a, long b){
        return (a / gcd(a, b)) * b; // Prevent overflow by dividing first
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number(A): ");
        long a = scanner.nextLong();

        System.out.print("Enter second number(B): ");
        long b = scanner.nextLong();

        //Calculate and display the LCM
        long result = lcm(a, b);
        System.out.println("LCM of " + a + " and " + b + " is: " + result);

        scanner.close();
    }
    
}
