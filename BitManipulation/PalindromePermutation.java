// AlphaCipher is a string formed from another string by rearranging its letters

// You are given a string S.
// Your task is to check, can any one of the AlphaCipher is a palindrome or not.

// Input Format:
// -------------
// A string S

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// carrace

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// code

// Sample Output-2:
// ----------------
// false


import java.util.*;
public class PalindromePermutation
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = 0;
        for(int i=0;i<s.length();i++)
        {
            int index = s.charAt(i)-'a';
            res ^= (1 << index);
        }
        int cnt = 0;
        while(res>0)
        {
            res = res&(res-1);
            cnt++;
        }
        if((cnt==1 && s.length()%2==1) || (cnt==0 && s.length()%2==0))
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }
}