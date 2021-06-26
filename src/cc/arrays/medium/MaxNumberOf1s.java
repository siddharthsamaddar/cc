package cc.arrays.medium;

/*
Maximize Number of 1's

Given a binary array arr of size N and an integer M.
Find the maximum number of consecutive 1's produced
by flipping at most M 0's.

Example 1:
Input:
N = 3
arr[] = {1, 0, 1}
M = 1
Output:
3
Explanation:
Maximum subArray is of size 3
which can be made subArray of all 1 after
flipping two zeros to 1.

Example 2:
Input:
N = 11
arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
M = 2
Output:
8
Explanation:
Maximum subArray is of size 8
which can be made subArray of all 1 after
flipping two zeros to 1.

Your Task:
Complete the function findZeroes() which takes array arr
and two integers n, m, as input parameters
and returns an integer denoting the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 10^7
0 <= M <= N
0 <= arri <= 1
*/
public class MaxNumberOf1s {
    public static void main(String[] args) {
        int N = 11;
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int M = 2;
        System.out.println(findZeroes(arr, N, M));
    }

    static int findZeroes(int[] arr, int n, int m) {
        int i = 0, j = 0, count0 = 0, max_window = 0;
        while (j < n) {
            if (arr[j] == 0)
                count0++;
            if (count0 <= m)
                max_window = Math.max(max_window, j - i + 1);
            while (count0 > m)
                if (arr[i++] == 0)
                    count0--;
            j++;
        }
        return max_window;
    }
}