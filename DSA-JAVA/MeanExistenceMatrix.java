/* Check Mean Existence in Parent Matrix Given a matrix Q of 
size M * n , where 1 <= M, N <=30, check if the mean (average) of 
any A * B sub-matrix exists as an element
in the original parent matrix.
Input1 : 1 1 7 
Output1 : Elements exist mean 7 : True
Input 2 : 3 3 1 2 3 4 5 6 7 8 9
Output: Elements exit mean 7: True   */
import java.util.*;

public class MeanExistenceMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the dimensions of the matrix
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        // Read the matrix elements
        int[][] matrix = new int[M][N];
        Set<Integer> elements = new HashSet<>(); // Store matrix elements for quick lookup

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
                elements.add(matrix[i][j]); // Add element to the HashSet
            }
        }

        // Read A and B (size of the sub-matrix)
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        boolean found = false;

        // Iterate over all possible sub-matrices of size A x B
        for (int i = 0; i <= M - A; i++) {
            for (int j = 0; j <= N - B; j++) {
                int sum = 0;

                // Compute sum of the sub-matrix (A x B)
                for (int x = 0; x < A; x++) {
                    for (int y = 0; y < B; y++) {
                        sum += matrix[i + x][j + y];
                    }
                }

                // Compute mean and check if it exists in the parent matrix
                int mean = sum / (A * B);
                if (elements.contains(mean)) {
                    found = true;
                    System.out.println("Elements exist mean " + mean + " : True");
                    scanner.close();
                    return;
                }
            }
        }

        // If no such mean was found
        System.out.println("Elements exist mean : False");
        scanner.close();
    }
}
