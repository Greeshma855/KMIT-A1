// Find the maximum number of books we can read in k minutes, 
// where each element of the array contains the time in minutes required to read 
// a book.

// Example
// For the input array {1, 1, 2, 1, 1, 1, 4, 2} and k = 8:

// The algorithm dynamically adjusts the window size.
// It identifies subarrays like {1, 1, 2, 1, 1, 1}, {1, 2, 1, 1, 1}, 
// {2, 1, 1, 1}, etc., which satisfy the sum condition.
// The longest subarray has a length of 6.

// Sample Input-1:
// ---------------
// 6
// 4 1 2 1 7 1

// Sample Output-1:
// ----------------
// 3

import java.util.*;
public class FlexibleSlidingWindow
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int arr[] = new int[k];
        for(int i=0;i<k;i++)
        {
            arr[i] = sc.nextInt();
        }
        
        int start = 0;
        int sum = 0;
        int maxlen = 0;
        for(int end=0;end<k;end++)
        {
            sum+=arr[end];
            while(sum>k)
            {
                // System.out.println("Entered while");
                sum-=arr[start];
                start++;
            }
            // System.out.println(start+" "+end);
            maxlen = Math.max(maxlen,(end-start+1));
        }
        System.out.println(maxlen);
    }
}