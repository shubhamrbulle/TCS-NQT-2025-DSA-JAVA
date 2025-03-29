/* Find Leftover Elements in a Range Given a range [L, U] and 
an array A of N elements, find all numbers that are not present in 
A within the given range. The missing numbers should be grouped sequentially.
Input1 : 1 10 1 5
Output1 : [1 4] [6 10]
Input2 : 3 90 5 7 22 50 66 78
Output2 : [3 6] [8 21] [23 49] [51 65] [67 77] [79 90]
 */
import java.util.*;

public class LeftoverElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the range L and U
        int L = scanner.nextInt();
        int U = scanner.nextInt();
        
        // Read the number of elements in array A
        int N = scanner.nextInt();
        
        // Read the elements of array A
        Set<Integer> elements = new HashSet<>();
        for (int i = 0; i < N; i++) {
            elements.add(scanner.nextInt());
        }

        // Find missing numbers in the range [L, U]
        List<List<Integer>> missingGroups = new ArrayList<>();
        List<Integer> currentGroup = new ArrayList<>();

        for (int num = L; num <= U; num++) {
            if (!elements.contains(num)) {
                currentGroup.add(num);
            } else if (!currentGroup.isEmpty()) {
                missingGroups.add(new ArrayList<>(currentGroup));
                currentGroup.clear();
            }
        }

        // Add last group if any numbers are left
        if (!currentGroup.isEmpty()) {
            missingGroups.add(new ArrayList<>(currentGroup));
        }

        // Print the output in the required format
        for (List<Integer> group : missingGroups) {
            System.out.print("[" + group.get(0) + " " + group.get(group.size() - 1) + "] ");
        }

        scanner.close();
    }
}
