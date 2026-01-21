// Two brothers want to play a game, 
// The rules of the game are: one player gives two sorted lists of 
// numerical elements and a number (sum). 
// The opponent has to find the closest pair of elements 
// to the given sum.
// -> pair consists of elements from each list

// Please help those brothers to develop a program, that takes 
// two sorted lists as input and return a pair as output.

// Input Format:
// -------------
// size of list_1
// list_1 values
// size of list_2
// list_2 values
// closest number

// Output Format:
// --------------
// comma-separated pair

// Sample Input-1:
// ---------------
// 4
// 1 4 5 7
// 4
// 10 20 30 40
// 32
// Sample Output-1
// ---------------
// 1,30

// Sample Input-2
// ---------------
// 3
// 2 4 6
// 4
// 5 7 11 13
// 15

// Sample Output-2
// ---------------
// 2, 13


import java.util.*;
public class ClosestPair
{
    public static int[] closestpair(int[] arr1,int[] arr2,int num)
    {
        int left = 0;
        int right = arr2.length-1;
        int[] res = new int[2];
        int minDiff = Integer.MAX_VALUE;
        while(right>=0 && left<=arr2.length-1)
        {
            int currentSum = arr1[left]+arr2[right];
            int diff = Math.abs(num-currentSum);
            if(diff<minDiff)
            {
                minDiff = diff;
                res[0]=arr1[left];
                res[1]=arr2[right];
            }
            if(currentSum>num)
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int [] arr1 = new int[m];
        for(int i=0;i<m;i++)
        {
            arr1[i] = sc.nextInt();
        }
        
        int n = sc.nextInt();
        int [] arr2 = new int[n];
        for(int i=0;i<n;i++)
        {
            arr2[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        int res[] = closestpair(arr1,arr2,num);
        System.out.println(res[0]+","+res[1]);
        
    }
}