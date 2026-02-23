// Tata motors released a new ELECTRIC CAR, which recharges its battery based on the 
// vehicle movement at specific points along the road when vehicle passes those points 
// at a specified speed.As you are the owner of that CAR, you want to get maximum benefit 
// of that, and you are travelling on a road of length "N" kilometres. There are specific 
// recharge points at every kilometre, it specifies how much percentage of battery improves 
// when you pass those points with a specified speed. But you can travel with this specified 
// speed for a continuous distance of "K" kilometres. With your programming skills can you 
// determine how to maximize the benefit from this.

// Input format:
// --------------
// First line contains two space-separated integers N and K, 
// the length of the track and the maximum distance car can 
// run at specified speed.

// Second line contains N space-separated integers, the number 
// of charging points within each kilometre of the road.

// Output Format:
// --------------
// An integer.

// Sample 1:
// ---------
// Input:
// -------
// 7 2
// 2 4 8 1 2 1 8

// output:
// -------
// 12

// Explanation:
// -------------
// Car can get maximum recharge 4+8=12 if it runs at specified speed 
// between the 2nd and the 3rd kilometre, inclusive.

// Constraints:
// ------------
// 1≤T≤10
// 1≤K≤N≤100
// 1≤ai≤100



import java.util.*;
public class CarRecharge
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        int max = 0;
        for(int i=0;i<k;i++)
        {
            sum+=arr[i];
        }
        max = Math.max(sum,max);
        for(int i=k;i<n;i++)
        {
            sum+=arr[i];
            sum-=arr[i-k];
            max = Math.max(sum,max);
        }
        System.out.println(max);
    }
}