// Given an array of n integers and a number k, find the maximum sum of any continuous subarray of size k.
// Print only the maximum sum.
// The subarray must consist of exactly k consecutive elements.

// Input Format:
// -------------
// An integer n — number of elements in the array
// n integers — elements of the array
// An integer k — size of the subarray

// Output Format:
// --------------
// Print a single integer — the maximum sum of any subarray of size k.

// Sample input:
// -------------
// 5
// 1 2 3 1 2
// 3
// Sample Output:
// --------------
// 6


import java.util.*;
public class FixedSlidingWindow
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int maxsum = 0;
        int sum = 0;
        for(int i=0;i<k;i++)
        {
            sum+=arr[i];
        }
        maxsum = Math.max(sum,maxsum);
        for(int i=k;i<n;i++)
        {
            sum+=arr[i];
            sum-=arr[i-k];
            maxsum = Math.max(sum,maxsum);
        }
        System.out.println(maxsum);
    }
}