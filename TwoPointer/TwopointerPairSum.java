// You are given an array of integers.
// Your task is to determine whether there exists any pair of two distinct elements
// in the array whose sum equals a given target value.

// If such a pair exists, print 1.
// Otherwise, print 0.

// Note:
// ------
// You may not use the same element twice.
// You need to sort the array.

// Input Format:
// -------------
// Line-1: An integer N, representing the size of the array.
// Line-2: N space-separated integers, representing the array elements.
// Line-3: An integer X, representing the target sum.

// Output Format:
// -----------------
// Print 1 if a pair exists whose sum equals X, otherwise print 0.

// Constraints
// 1 ≤ N ≤ 10^5
// -10^9 ≤ array[i] ≤ 10^9
// -10^9 ≤ X ≤ 10^9

// Sample Input:
// -------------
// 4
// 1 4 2 5
// 7

// Sample Output:
// -------------
// 1

// Explanation
// ------------
// The numbers 2 and 5 form the sum 7.
// Hence, a valid pair exists → output is 1.

import java.util.*;

public class TwopointerPairSum
{
    public static int PairSum(int[] arr, int x)
    {
        int left = 0;
        int right = arr.length - 1; // Corrected: Initialize to the last index
        int cnt = 0;
        while (left < right)
        {
            int currentSum = arr[left] + arr[right];
            if (currentSum > x)
            {
                right--; // Sum is too large, decrease the right pointer
            }
            else if (currentSum < x)
            {
                left++; // Sum is too small, increase the left pointer
            }
            else // currentSum == x (Found a pair)
            {
                cnt++;
                left++;
                right--; // Move both pointers to look for more distinct pairs
            }
        }
        return cnt;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the elements:");
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the target sum (x):");
        int x = sc.nextInt();
        
        Arrays.sort(arr); // Corrected: Use Arrays.sort() for primitive arrays
        
        System.out.println("Number of pairs that sum to " + x + ": " + PairSum(arr, x));
        sc.close(); // Good practice to close scanner
    }
}
