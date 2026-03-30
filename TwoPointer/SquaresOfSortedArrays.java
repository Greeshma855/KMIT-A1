// Given an integer array nums sorted in non-decreasing order, 
// return an array of the squares of each number sorted in non-decreasing order.

// Example 1:

// Input:5
// -4 -1 0 3 10
// Output: [0, 1, 9, 16, 100]

import java.util.*;
public class SquaresOfSortedArrays
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sc.nextInt();
        }
        int left = 0;
        int right = n-1;
        int pos = n-1;
        int[] res = new int[n];
        while(left<=right)
        {
            int l = arr[left]*arr[left];
            int r = arr[right]*arr[right];
            if(l>r)
            {
                res[pos]=l;
                left++;
            }
            else
            {
                res[pos]=r;
                right--;
            }
            pos--;
        }
        System.out.println(Arrays.toString(res));
    }
}