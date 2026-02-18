// Mr Akshay is playing with lines he is drawing lines with some height,imagine 
// that two lines that together with the x-axis form a container, then find, with 
// given integer heights maximum amount of water akshay can store,
// You are given an integer array height of length n. There are n vertical lines 
// drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Return the maximum amount of water a container can store.

// Input :
// --------
// number of lines n
// n integer values of height of each line

// Output:
// -------
// maximum water a container can store

// Example 1:
// -------------
// Input :
// 9
// 1 8 6 2 5 4 8 3 7
// Output : 49

// Explanation :
// -------------
// first line height is 1 second line height is 8 like that last line height is 7, 
// so akshay can store water between second line and last line with the height of 7
// distance between last and second line is 7 so maximum capacity is 7*7=49

// note : if we consider two 8 lines i.e at position 2 and 7 then the height of 
//  container is 8 and distance of container is 5 so water capacity is 8 * 5 = 40
 
// hence 49 is the maximum capacity returned.

// Example 2:
// ----------
// Input = 9
// 1 2 3 4 5 6 7 8 9
// Output = 20


import java.util.*;
public class WaterContainer
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++)
        {
            num[i] = sc.nextInt();
        }
        int left = 0;
        int right = n-1;
        int maxvolume = 0;
        while(left<right)
        {
            int height = Math.min(num[left],num[right]);
            int width = right-left;
            int volume = height*width;
            maxvolume = Math.max(volume,maxvolume);
            if(num[left]>num[right])
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        System.out.println(maxvolume);
        
    }
}