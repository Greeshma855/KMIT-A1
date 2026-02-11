// Given string num representing a non-negative integer num, 
// and an integer k, return the smallest possible integer after removing k digits 
// from num.

// Example 1:
// ----------
// Input =1432219
// 3
// Output =1219

// num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 
// which is the smallest.

// Example 2:
// ----------
// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output 
// must not contain leading zeroes.


import java.util.*;
public class RemoveKdigits
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int element = s.charAt(i++)-'0';
        stack.push(element);
        while(!stack.empty() && i<s.length())
        {
            element = s.charAt(i++)-'0';
            if(stack.peek()>element && k-->0)
            {
                stack.pop();
            }
            stack.push(element);
        }
        StringBuilder sb = new StringBuilder();
        for(int c:stack)
        {
            sb.append(c);
        }
        String res = sb.toString();
        int r = Integer.parseInt(res);
        System.out.println(r);

    }
}