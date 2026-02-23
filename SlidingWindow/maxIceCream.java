// In Turkey, an ice cream parlour gives an offer to a lucky kid.
// The parlour keep N icecream cups in a row, and there are different flavours 
// of icecreams, where i-th cup filled with the flavour[i] type of ice cream.

// The kid can pick the continuous set of ice cream cups, where the cups filled
// with the icecreams of atmost two different flavours. The kid wants to 
// pick maximum number of icecream cups from the row.

// You will be given the integer array, flavours[] of size N.
// Your task is to help the kid to pick the maximum number of icecream cups 
// with atmost two different flavours.


// Input Format:
// -------------
// Line-1: An integer, number of icecreams.
// Line-2: N space separated integers, flavours[] 

// Output Format:
// --------------
// Print an integer result, maximum number of icecream cups can be picked.


// Sample Input-1:
// ---------------
// 10
// 1 2 3 1 1 3 3 2 3 2

// Sample Output-1:
// ----------------
// 5

// Explanation:
// ------------
// The kid can pick the continuous set of icecream cups as follows: 3 1 1 3 3
// Where the cups are filled with two different flavours, 1 and 3.


import java.util.*;
public class maxIceCream
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
        int flavours = 2;
        int start = 0;
        int maxcnt = 0;
        int cnt = 0;
        Map<Integer,Integer> m = new HashMap<>();
        for(int end=0;end<n;end++)
        {
            m.put(arr[end],m.getOrDefault(arr[end],0)+1);
            while(m.size()>flavours)
            {
                m.put(arr[start],m.get(arr[start])-1);
                if(m.get(arr[start])<=0)
                {
                    m.remove(arr[start]);
                }
                start++;
            }
            cnt = end-start+1;
            maxcnt = Math.max(cnt,maxcnt);
        }
        System.out.println(maxcnt);
    }
}