package cc.arrays.easy;
/*
Alternate positive and negative numbers
Given an unsorted array Arr of N positive and negative numbers.
Your task is to create an array of alternate positive and negative numbers
without changing the relative order of positive and negative numbers.
Note: Array should start with positive number.

Example 1:
Input:
N = 9
Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
Output:
9 -2 4 -1 5 -5 0 -3 2

Example 2:
Input:
N = 10
Arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output:
5 -5 2 -2 4 -8 7 1 8 0

Your Task:
Your task is to complete the function rearrange()
which takes the array of integers arr[] and n as parameters.
You need to modify the array itself.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 10^7
-106 ≤ Arr[i] ≤ 10^7
*/

import java.util.ArrayList;

public class AlternatePosNegNumbers {
    public static void main(String[] args) {
        int N = 10;
        int[] Arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrange(Arr, N);
        for (int i : Arr)
            System.out.print(i + " ");
    }

    static void rearrange(int[] arr, int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int num : arr)
            if (num >= 0)
                pos.add(num);
            else
                neg.add(num);
        int i = 0, j = 0, k = 0;
        while (i < n) {
            if (j < pos.size())
                arr[i++] = pos.get(j++);
            if (k < neg.size())
                arr[i++] = neg.get(k++);
        }
    }
}