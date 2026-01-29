// You are given an integer n.
// Return all numbers in the range 1 to n whose binary representation contains 
// only set bits (1s).

// Example:
// Input = 7
// Output = 1 3 7

import java.util.*;
public class CompleteSetBits
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            int cnt = 0;
            int len = Integer.toBinaryString(i).length();
            int a = i;
            while(a>0)
            {
                a = a&(a-1);
                cnt++;
            }
            if(cnt==len)
            {
                System.out.println(i);
            }
        }
    }
}