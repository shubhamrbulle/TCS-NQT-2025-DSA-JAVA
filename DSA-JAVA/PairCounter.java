/* Given an array of size N and two numbers X and Y, count the pairs(i, j) where:
 * 1 <=i, j <= N
 * X <= CONCAT(Arr[i], Arr[j]) <= Y
 * ( Concatenation means joining the two numbers as strings, e.g., CONCAT(3, 7) = 37, 
 * CONCAT(45, 70) -> 4570 )
 * INPUT: 
 * 1 5 200 2000 5 15 25 35 45
 * Output: 11
 */

 import java.util.Scanner;

 public class PairCounter {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         // Read input values
         System.out.print("Enter size of array (N): ");
         int N = scanner.nextInt();
         int[] arr = new int[N];
 
         System.out.println("Enter array elements:");
         for (int i = 0; i < N; i++) {
             arr[i] = scanner.nextInt();
         }
 
         System.out.print("Enter value of X: ");
         int X = scanner.nextInt();
         System.out.print("Enter value of Y: ");
         int Y = scanner.nextInt();
 
         int count = 0;
 
         // Iterate through all possible (i, j) pairs
         for (int i = 0; i < N; i++) {
             for (int j = 0; j < N; j++) {
                 // Concatenate numbers as strings
                 String concatenated = String.valueOf(arr[i]) + String.valueOf(arr[j]);
                 int concatenatedValue = Integer.parseInt(concatenated);
 
                 // Check if the concatenated value is within range [X, Y]
                 if (concatenatedValue >= X && concatenatedValue <= Y) {
                     count++;
                 }
             }
         }
 
         System.out.println("Output: " + count);
         scanner.close();
     }
 }
 