// You are given an array of n integers and a number k representing the window size.
// Your task is to find the minimum element in every continuous subarray of size k.
// The window should move one position to the right at a time, and the minimum value 
// of each window should be printed in order, separated by commas. If the window size 
// k is greater than the number of elements n, print -1.

// Input Format
// ---------------------
// An integer n — number of elements in the array
// n integers — elements of the array
// An integer k — size of the sliding window

// Output Format
// --------------------
// Print the minimum element of each subarray of size k, separated by commas
// Note: If k > n, print -1

// Explanation:
// ----------------
// n = 8  
// arr = 3 1 5 2 6 2 1 4  
// k = 3
// Sliding windows of size 3:
// [3, 1, 5] → min = 1
// [1, 5, 2] → min = 1
// [5, 2, 6] → min = 2
// [2, 6, 2] → min = 2
// [6, 2, 1] → min = 1
// [2, 1, 4] → min = 1

// output should be:
// 1,1,2,2,1,1

// Sample Input:
// --------------
// 7
// 2 5 1 8 3 9 4
// 3

// Sample output:
// ---------------
// 1,1,1,3,3


import java.util.*;
public class MinimumElementSubArray
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        
        List<Integer> window = new ArrayList<>();
        int[] res = new int[n-k+1];
        for(int i=0;i<k;i++)
        {
            window.add(arr[i]);
        }
        System.out.println("haha");
        res[0] = Collections.min(window);
        for(int i=k;i<n;i++)
        {
            window.remove(Integer.valueOf(arr[i-k]));
            window.add(arr[i]);
            res[i-k+1]=Collections.min(window);
            System.out.println(i+" "+(i-k+1));
        }
        System.out.println(Arrays.toString(res));
        
        
    }
}