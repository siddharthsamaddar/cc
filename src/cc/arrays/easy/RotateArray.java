package cc.arrays.easy;

/*
Rotate Array
Given an unsorted array arr[] of size N, rotate it by D elements in the counter-clockwise direction.

Example 1:
Input:
N = 5, D = 2
arr[] = {1,2,3,4,5}
Output: 3 4 5 1 2
Explanation: 1 2 3 4 5  when rotated
by 2 elements, it becomes 3 4 5 1 2.

Example 2:
Input:
N = 10, D = 3
arr[] = {2,4,6,8,10,12,14,16,18,20}
Output: 8 10 12 14 16 18 20 2 4 6
Explanation: 2 4 6 8 10 12 14 16 18 20
when rotated by 3 elements, it becomes
8 10 12 14 16 18 20 2 4 6.

Your Task:
Complete the function rotateArr() which takes the array, D and N as input parameters
and rotates the array by D elements. The array must be modified in-place without using extra space.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 10^7
1 <= D <= N
0 <= arr[i] <= 10^5
*/
public class RotateArray {
    public static void main(String[] args) {
        int N = 10, D = 3;
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        rotateArr(arr, N, D);
        for (int j : arr)
            System.out.print(" " + j);
    }

    static void rotateArr(int[] arr, int n, int d) {
        reverseArr(arr, 0, d - 1);
        reverseArr(arr, d, n - 1);
        reverseArr(arr, 0, n - 1);
    }

    static void reverseArr(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
