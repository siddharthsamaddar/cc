package cc.math.hard;

/*
Nth Natural Number

Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9 .


Example 1:

Input:
N = 8
Output:
8
Explanation:
After removing natural numbers which contains
digit 9, first 8 numbers are 1,2,3,4,5,6,7,8
and 8th number is 8.
Example 2:

Input:
N = 9
Output:
10
Explanation:
After removing natural numbers which contains
digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10
and 9th number is 10.


Your Task:
Complete the function findNth() which accepts an integer N as input parameter and return the Nth number after removing all the numbers containing digit 9.


Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 10^12
*/
public class NthNaturalNumber {
    public static void main(String[] args) {
        long n = 19;
        System.out.println("Output :" + findNth(n));
    }

    static long findNth(long n) {
        long mul = 1, result = 0;
        long rem;
        while (n > 0) {
            rem = n % 9;
            result += mul * rem;
            mul *= 10;
            n = n / 9;
        }
        return result;
    }
}

/*
Optimized approach on the following observations:

It is known that, digits of base 2 numbers varies from 0 to 1. Similarly, digits of base 10 numbers varies from 0 to 9.
Therefore, the digits of base 9 numbers will vary from 0 to 8.
It can be observed that Nth number in base 9 is equal to Nth number after skipping numbers containing digit 9.
So the task is reduced to find the base 9 equivalent of the number N.
*/