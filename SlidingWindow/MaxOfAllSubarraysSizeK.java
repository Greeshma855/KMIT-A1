// Mr.Ram is a sales manager of Dmart, for his analysis he has to monitor 
// sales of Dmart every day. He need to send report of maximum sales 
// of every K consecutive days from given N number of days sales.
// Write a java program to do his task easy.

// Input Format:
// -------------
// Line-1: Two space separated integers, N and K
// Line-2: N space separated integers, sales[].

// Output Format:
// --------------
// Print maximum sales of every K consecutive days


// Sample Input 1:
// ---------------
// 9 3
// 1 2 3 1 4 5 2 3 6

// Sample output 1:
// ----------------
// 3 3 4 5 5 5 6

// Explanation: 
// Maximum of subarray {1, 2, 3} is 3
// Maximum of subarray {2, 3, 1} is 3
// Maximum of subarray {3, 1, 4} is 4
// Maximum of subarray {1, 4, 5} is 5
// Maximum of subarray {4, 5, 2} is 5
// Maximum of subarray {5, 2, 3} is 5
// Maximum of subarray {2, 3, 6} is 6


// ------------------------------------------------------------------------------------------------------

import java.util.*;
public class MaxOfAllSubarraysSizeK
{
    public static int[] p(int[] nums,int k)
    {
        int n = nums.length;
        int l = n-k+1;
        int[] res = new int[l];
        int c = 0;
        ArrayList<Integer> sub = new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            sub.add(nums[i]);
        }
        res[c++] = Collections.max(sub);
        for(int j=k;j<n;j++)
        {
            sub.remove(0);
            sub.add(nums[j]);
            res[c++] = Collections.max(sub);
            
        }
        return res;
        
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int[] res = p(arr,k);
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }
        
    }
}