// You are given an integer n.
// Your task is to print all numbers from 0 to n (inclusive) whose binary 
// representation is a palindrome.

// Example:
// n=7
// Output is 0 1 3 5 7

import java.util.*;
public class BinaryPalindrome
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<=n;i++)
        {
            // ---------- Important Logic -----------
            int bits = Integer.toBinaryString(i).length();
            int reversed = Integer.reverse(i) >>> (32-bits);
            if((i^reversed)==0)
            {
                System.out.println(i);
            }
        }
    }
}