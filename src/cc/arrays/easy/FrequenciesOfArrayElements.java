package cc.arrays.easy;

/*
Frequencies of Limited Range Array Elements

Given an array A[] of N positive integers which can contain integers from 1 to P
where elements can be repeated or can be absent from the array.
Task is to count the frequency of all elements from 1 to N.

Example 1:
Input:
N = 5
arr[] = {2, 3, 2, 3, 5}
P = 5
Output:
0 2 2 0 1
Explanation:
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 2 times.
3 occurring 2 times.
4 occurring 0 times.
5 occurring 1 time.

Example 2:
Input:
N = 4
arr[] = {3,3,3,3}
P = 3
Output:
0 0 4 0
Explanation:
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 0 times.
3 occurring 4 times.
4 occurring 0 times.

Your Task:
Complete the function frequencyCount() that takes the array and n as input parameters
and returns an array in place to denote the frequency count of each element from 1 to N.
i,e element at index 0 should represent frequency of 1 and so on.

Expected Time Complexity: O(N logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 10^5
1 ≤ P ≤ 4*10^4
1 <= A[i] <= P
*/
public class FrequenciesOfArrayElements {
    public static void main(String[] args) {
        int N = 5;
        int[] arr = {2, 3, 2, 3, 5};
        frequencyCount(arr, N);
        for (int i : arr)
            System.out.print(i + " ");
    }

    static void frequencyCount(int[] arr, int n) {
        // Function to find counts of all elements present in
        // arr[0..n-1]. The array elements must be range from
        // 1 to n
        // Traverse all array elements
        int i = 0;
        while (i < n) {
            // If this element is already processed,
            // then nothing to do
            if (arr[i] <= 0) {
                i++;
                continue;
            }

            // Find index corresponding to this element
            // For example, index for 5 is 4
            int elementIndex = arr[i] - 1;

            // If the elementIndex has an element that is not
            // processed yet, then first store that element
            // to arr[i] so that we don't lose anything.
            if (arr[elementIndex] > 0) {
                arr[i] = arr[elementIndex];

                // After storing arr[elementIndex], change it
                // to store initial count of 'arr[i]'
                arr[elementIndex] = -1;
            } else {
                // If this is NOT first occurrence of arr[i],
                // then decrement its count.
                arr[elementIndex]--;

                // And initialize arr[i] as 0 means the element
                // 'i+1' is not seen so far
                arr[i] = 0;
                i++;
            }
        }
        for (int j = 0; j < n; j++)
            arr[j] = Math.abs(arr[j]);
    }
}
/*
By making elements negative.
Approach: The idea is to traverse the given array, use elements as an index
and store their counts at the index. Consider the basic approach,
a Hashmap of size n is needed and the array is also of size n.
So the array can be used as a hashmap, all the elements of the array are from 1 to n,
i.e. all are positive elements. So the frequency can be stored as negative.
This might lead to a problem. Let i-th element be a then the count should be stored at array[a-1],
but when the frequency will be stored the element will be lost. To deal with this problem,
first, replace the ith element by array[a-1] and then put -1 at array[a-1].
So our idea is to replace the element by frequency and store the element in the current index
and if the element at array[a-1] is already negative,
then it is already replaced by a frequency so decrement array[a-1].
*/