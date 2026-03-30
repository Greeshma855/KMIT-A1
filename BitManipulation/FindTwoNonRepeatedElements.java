// Given an array of integers where all elements occur twice 
// except exactly two elements, which occur only once, 
// your task is to find these two non-repeated elements.

// You must print the two non-repeating elements in the order they are found.

// Input Format
// ------------
// First line contains an integer N — size of the array.
// Second line contains N space-separated integers.

// Output Format
// ---------------
// Print the two non-repeated integers, separated by space.

// Constraints
// -----------
// 2 ≤ N ≤ 10^6
// Array will contain exactly two unique elements and all others repeated twice.

// Input:
// ------
// 8
// 2 3 7 9 2 3 9 11

// Output:
// --------
// 7  11  (OR)
// 11 7

// Explanation:
// ------------
// 2,3,9 are repeated twice → ignored
// 7 and 11 occur once → printed.

import java.util.*;
public class FindTwoNonRepeatedElements{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int xor = 0;
        for(int i=0;i<n;i++)
        {
            xor ^= arr[i];
        }
        int setbit = xor&(-xor);
        int xor1 = 0;
        int xor2 = 0;
        for(int i=0;i<n;i++)
        {
            if((arr[i]&setbit)==0)
            {
                xor1^= arr[i];
            }
            else
            {
                xor2^= arr[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]==xor1)
            {
                System.out.println(xor1+" "+xor2);
                break;
            }
            else if(arr[i]==xor2)
            {
                System.out.println(xor2+" "+xor1);
                break;
            }
            
        }
    }
}