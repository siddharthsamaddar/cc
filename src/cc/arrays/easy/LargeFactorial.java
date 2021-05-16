package cc.arrays.easy;

/*
Large Factorial
You are given an array A of integers of length N.
You need to calculate factorial of each number.
The answer can be very large, so print it modulo 10^9 + 7.

Example 1:
Input:
N = 5
A[] = {0, 1, 2, 3, 4}
Output:
1 1 2 6 24
Explanation:
Factorial of 0 is 1,
factorial of 1 is 1,
factorial of 2 is 2,
factorial of 3 is 6 and so on.

Example 2:
Input:
N = 3
A[] = {5, 6, 3}
Output:
120 720 6
Explanation:
Factorial of 5 is 120,
factorial of 6 is 720,
factorial of 3 is 6.

Your Task:
Complete the function factorial() which takes list a and single integer n,
as input parameters and returns a list of factorials of the numbers in the list a.

Expected Time Complexity: O(max(A) + N)
Expected Auxiliary Space: O(max(A))

Constraints:
1 <= N <= 10^5
0 <= A[i] <= 10^5
*/
public class LargeFactorial {
    public static void main(String[] args) {
        int N = 3;
        long[] A = {5, 6, 3};
        factorial(A, N);
        for (long i : A)
            System.out.print(i + " ");
    }

    static void factorial(long[] a, int n) {
        int max = (int) max(a);
        long[] fact = new long[max + 1];
        fact[0] = fact[1] = 1;
        for (int i = 2; i < max + 1; i++)
            fact[i] = i * fact[i - 1] % 1000000007;
        for (int i = 0; i < n; i++)
            a[i] = fact[(int) a[i]];
    }

    static long max(long[] a) {
        long max = Long.MIN_VALUE;
        for (long i : a)
            if (i > max)
                max = i;
        return max;
    }
}