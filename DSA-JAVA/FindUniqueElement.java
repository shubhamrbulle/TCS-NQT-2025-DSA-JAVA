/* Problem Statement :
 * You are given an array Containing N integers where only one element
 * is unique (appears exactly once), while all other elements appear twice. find and 
 * return the unique element.
 * Example :
 * Input : [5, 3, 2, 3, 2]
 * Output : 5
 */
public class FindUniqueElement {

    public static int findUnique(int[] arr){
        int result = 0;
        //XOR all elements
        for(int num : arr){
            result ^=num; //XOR cancels out duplicate elements
        }
        return result;
    }
    
    public static void main(String[] args){

        int[] arr = {5, 3, 2, 3, 2};
        System.out.println("The Unique Element is : " + findUnique(arr));
        //Output : 5

    }
}
