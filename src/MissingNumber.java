/*
Missing number in array
Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.

Example 1:

Input:
N = 5
A[] = {1,2,3,5}
Output: 4
Example 2:

Input:
N = 10
A[] = {1,2,3,4,5,6,7,8,10}
Output: 9

Your Task :
You don't need to read input or print anything. Complete the function MissingNumber() that takes array and N as input  parameters and returns the value of the missing number.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
1 ≤ A[i] ≤ 106
*/
class MissingNumber {
    public static void main(String[] args) {
        int N = 5;
        int[] A = {1, 2, 3, 5};
        System.out.print(missingNumber(N, A));
    }

    static int missingNumber(int N, int[] a) {
        int sumUpToN = (N * (N + 1)) / 2;
        int sum = 0;
        for (int i : a)
            sum += i;
        return sumUpToN - sum;
    }
}