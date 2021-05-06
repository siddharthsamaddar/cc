import java.util.ArrayList;
import java.util.LinkedList;

/*
Plus One
Given a non-negative number represented as a list of digits,
add 1 to the number (increment the number represented by the digits).
The digits are stored such that the most significant digit is first element of array.

Example 1:
Input:
N = 3
arr[] = {1, 2, 4}
Output:
1 2 5
Explanation:
124+1 = 125, and so the Output

Example 2:
Input:
N = 3
arr[] = {9,9,9}
Output:
1 0 0 0
Explanation:
999+1 = 1000, and so the output

Your Task:
Complete the function increment() that takes an integer N,
and an array arr of size N as input and returns a list of integers
denoting the new number which we get after adding one to the number denoted by the array arr.

Expected Time Complexity:  O(N)
Expected Axillary Space: O(1)

Constraints:
1 <= N <= 10^5
0 <= arr[i] <= 9
*/
public class PlusOneToDigitArray {
    public static void main(String[] args) {
        int N = 3;
        int[] arr = {9, 9, 9};
        ArrayList<Integer> ans = increment(arr, N);
        for (int i : ans)
            System.out.print(i + " ");
    }

    static ArrayList<Integer> increment(int[] arr, int n) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            int rem = arr[i] % 10 + carry;
            if (rem <= 9) {
                result.push(rem);
                carry = 0;
            } else {
                result.push(0);
                carry = 1;
            }
        }
        if (carry == 1)
            result.push(carry);
        return new ArrayList<>(result);
    }
}
