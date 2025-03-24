/* You are given three Integers P, Q, and R. 
You can perform the following operation any number of times:
- Select any two numbers and increase both by 1.
- Decrease the third number by 1.
Your task is to determine the minimum number of operations required to make all three numbers
equal.
INPUT : 
4 <- number of test cases\
1 2 3
4 4 4
3 2 6
1 1 7

OUTPUT : 
-1
0
-1
3
*/

import java.util.Scanner;
import java.util.Arrays;

public class EqualizeNumbers {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Read number of test cases
        int t = scanner.nextInt();

        while(t-- > 0){
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int r = scanner.nextInt();

            int[] arr = {p, q, r};
            Arrays.sort(arr);
            
            int x = arr[0];
            int y = arr[1];
            int z = arr[2];
            
            //Check if it's possible to make all three numbers equal
            int sum = x + y + z;
            if(sum % 3 != 0){
                System.out.println("-1");
            }
            else{
                //Calculate the target value (sum/3)
                int target = sum / 3;

                //Calculate the number of operations required
                int operations = (target - x) + (target - y);
                System.out.println(operations);
            }
        }
        scanner.close();
    }
    
}
