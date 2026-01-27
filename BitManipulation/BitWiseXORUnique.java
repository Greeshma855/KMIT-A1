// /*Single Number- Find the element in an array that is not repeated.*/

// Sample Input:
// 7 //array size
// 4 1 2 9 1 4 2 // elements

// Sample Output:
// 9


import java.util.*;
public class BitWiseXORUnique
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
        
        for(int i=0;i<n;i++)
        {
            int cnt=0;
            for(int j=i+1;j<n;j++)
            {
                if((arr[i]^arr[j])==0)
                {
                    cnt+=1;
                }
            }
            if(cnt==0)
            {
                System.out.println(arr[i]);
            }
        }
    }
}