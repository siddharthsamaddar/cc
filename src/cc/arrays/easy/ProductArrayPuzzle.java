package cc.arrays.easy;

/*
Product array puzzle

Given an array num[] of size n,
construct a Product Array P (of same size n) such that P[i]
is equal to the product of all the elements of num except num[i].

Example 1:
Input:
n = 5
num[] = {10, 3, 5, 6, 2}
Output:
180 600 360 300 900
Explanation:
For i=0, P[i] = 3*5*6*2 = 180.
For i=1, P[i] = 10*5*6*2 = 600.
For i=2, P[i] = 10*3*6*2 = 360.
For i=3, P[i] = 10*3*5*2 = 300.
For i=4, P[i] = 10*3*5*6 = 900.

Example 2:
Input:
n = 2
num[] = {12,0}
Output:
0 12

Your Task:
Complete the function productExceptSelf() that takes array num[] and n as input parameters
and returns a list of n integers denoting the product array P.
If the array has only one element the returned list should should contains one value i.e {1}
Note: Try to solve this problem without using the division operation.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 1000
0 <= num[i] <= 200
Array may contain duplicates.
*/
public class ProductArrayPuzzle {
    public static void main(String[] args) {
        int n = 5;
        int[] num = {10, 3, 5, 6, 2};
        long[] result = productExceptSelf(num, n);
        for (long i : result)
            System.out.print(i + " ");
    }

    static long[] productExceptSelf(int[] arr, int n) {
        // Base case
        if (n == 1)
            return new long[]{0};

        // Initialize memory to all arrays
        long[] left = new long[n];
        long[] right = new long[n];
        long[] prod = new long[n];

        int i, j;

        /* Left most element of left array is always 1 */
        left[0] = 1;

        /* Rightmost most element of right array is always 1 */
        right[n - 1] = 1;

        /* Construct the left array */
        for (i = 1; i < n; i++)
            left[i] = arr[i - 1] * left[i - 1];

        /* Construct the right array */
        for (j = n - 2; j >= 0; j--)
            right[j] = arr[j + 1] * right[j + 1];

        /* Construct the product array using left[] and right[] */
        for (i = 0; i < n; i++)
            prod[i] = left[i] * right[i];

        return prod;
    }
}
