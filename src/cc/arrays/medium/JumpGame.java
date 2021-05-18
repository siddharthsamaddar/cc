package cc.arrays.medium;

/*
Jump Game

Given an positive integer N and a list of N integers A[].
Each element in the array denotes the maximum length of jump you can cover.
Find out if you can make it to the last index if you start at the first index of the list.

Example 1:
Input:
N = 6
A[] = {1, 2, 0, 3, 0, 0}
Output:
1
Explanation:
Jump 1 step from first index to
second index. Then jump 2 steps to reach
4th index, and now jump 2 steps to reach
the end.

Example 2:
Input:
N = 3
A[] =  {1, 0, 2}
Output:
0
Explanation:
You can't reach the end of the array.

Your Task:
Task is to complete the function canReach() which takes a Integer N and a list A
of size N as input and returns 1 if the end of the array is reachable, else return 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 10^5
1 <= A[i] <= 10^5
*/
public class JumpGame {
    public static void main(String[] args) {
        int N = 6;
        int[] A = {1, 2, 0, 3, 0, 0};
        System.out.println(canReach(A, N));
    }

    static int canReach(int[] a, int n) {
        int stepCount = a[0];
        for (int i = 1; i < n; i++) {
            if (stepCount < 1)
                return 0;
            if (stepCount < a[i])
                stepCount = a[i];
            else
                stepCount--;
        }
        return 1;
    }
}


/*
Approach:
1. basic thinking is like we only reach next index if (i+arr[i] > i)
2. if condition 1 fulfils we will increment i by 1 and assign
arr[i] = max(arr[i], arr[i-1]-1) ,
previous array index value is decreased by 1
as of now it has traversed one index and proceeded to i+1 index
3. if at last i becomes N-1 return 1
else return 0 for other cases

for example lets take array N = 6
A[] = {1, 2, 0, 3, 0, 0}
After processing array becomes
A[] = {1, 2, 1, 3, 2, 1}
*/