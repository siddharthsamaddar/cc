package cc.math.easy;

/*
Trailing zeroes in factorial
For an integer N find the number of trailing zeroes in N!.

Example 1:

Input:
N = 5
Output:
1
Explanation:
5! = 120 so the number of trailing zero is 1.
Example 2:

Input:
N = 4
Output:
0
Explanation:
4! = 24 so the number of trailing zero is 0.
Your Task:
Your task is to complete the function trailingZeroes() which take an integer N as an input parameter and returns the count of trailing zeroes in the N!.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 109
*/
public class TrailingZerosInFactorial {
    public static void main(String[] args) {
        int N = 384;
        System.out.println("Trailing zeros " + trailingZeros(N));
    }

    static int trailingZeros(int n) {
        int count = 0;
        for (int i = 5; i <= n; i *= 5)
            count += n / i;
        return count;
    }
}
/*
Usual method can cause overflow for slightly bigger numbers as the factorial of a number is a big number.
The idea is to consider prime factors of a factorial n.
A trailing zero is always produced by prime factors 2 and 5.
If we can count the number of 5s and 2s, our task is done.
Consider the following examples.
n = 5: There is one 5 and 3 2s in prime factors of 5! (2 * 2 * 2 * 3 * 5). So a count of trailing 0s is 1.
n = 11: There are two 5s and eight 2s in prime factors of 11! (2 8 * 34 * 52 * 7). So the count of trailing 0s is 2.
*/