/* Sum of Prime Numbers
 * Given an integer N, find the sum of all prime
 * numbers from 2 to N (inclusive).
 * Input: 10
 * Output: 17
 * Explanation: Prime between 2 and 10 => 2, 3, 5, 7
 * sum = 2 + 3 + 5 + 7 = 17
 */

 import java.util.Scanner;

 public class SumOfPrimes {
     
     // Function to check if a number is prime
     public static boolean isPrime(int num) {
         if (num <= 1) return false;
         if (num <= 3) return true;
         if (num % 2 == 0 || num % 3 == 0) return false;
         
         for (int i = 5; i * i <= num; i += 6) {
             if (num % i == 0 || num % (i + 2) == 0) return false;
         }
         return true;
     }
 
     // Function to calculate sum of primes
     public static int sumOfPrimes(int n) {
         int sum = 0;
         for (int i = 2; i <= n; i++) {
             if (isPrime(i)) {
                 sum += i;
             }
         }
         return sum;
     }
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter an integer N: ");
         int n = scanner.nextInt();
         scanner.close();
         
         int result = sumOfPrimes(n);
         System.out.println("Sum of prime numbers between 2 and " + n + " is: " + result);
     }
 }
 