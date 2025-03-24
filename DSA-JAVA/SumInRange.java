/* 
 * Problem: Given a Range [m, n] (both inclusive), where 0 <= m n <= 100000, find the sum of all integers between m and n.
 * input: 0 3
 * Output: 6
 * Explanation: The sum of all integers between 0 and 3 is 0 + 1 + 2 + 3 = 6.
 */
import java.util.Scanner;

public class SumInRange {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Input two integers m and n
        System.out.println("Enter the value of M : ");
        int m = scanner.nextInt();
        
        System.out.println("Enter the value of N : ");
        int n = scanner.nextInt();

        // Ensure m <= n using Math.min and Math.max
        int start = Math.min(m, n);
        int end = Math.max(m, n);

        // Calculate the sum using the formula for sum of n natural numbers
        int sum = (end * (end + 1) / 2) - ((start -1) * start  / 2);

        // Print the result 
        System.out.println("The Sum of Integers between " + m + " and " +n + " is : " + sum);
        
        scanner.close();
    }
}
