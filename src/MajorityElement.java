/*
Majority Element
Given an array A of N elements. Find the majority element in the array.
A majority element in an array A of size N is an element that appears more than N/2 times in the array.

Example 1:
Input:
N = 3
A[] = {1,2,3}
Output:
-1
Explanation:
Since, each element in
{1,2,3} appears only once so there
is no majority element.

Example 2:
Input:
N = 5
A[] = {3,1,3,3,2}
Output:
3
Explanation:
Since, 3 is present more
than N/2 times, so it is
the majority element.

Your Task:
The task is to complete the function majorityElement()
which returns the majority element in the array. If no majority exists, return -1.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 10^7
0 <= Ai <= 10^6
*/

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int N = 5;
        int[] A = {3, 1, 3, 3, 2};
        System.out.println(majorityElement(A, N));
    }

    static int majorityElement(int[] a, int n) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : a)
            freq.put(i, freq.getOrDefault(i, 0) + 1);

        int m = n / 2, result = -1;
        for (int i : freq.keySet())
            if (freq.get(i) > m) {
                m = freq.get(i);
                result = i;
            }
        return result;
    }
}