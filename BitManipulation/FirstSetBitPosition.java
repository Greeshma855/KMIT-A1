// Find the position of the first set bit (bit equal to 1) in the binary 
// representation of a positive integer.
// The position counting starts from 1 at the least significant bit (rightmost bit).

// If the number is 0, then no set bit exists and the program should return 0.
// If no set bit is found during iteration, return -1.

// Example 1:
// ---------------
// Input: 18
// Binary of 18 → 10010
// Positions from right → 1 2 3 4 5
// Rightmost 1 is at position 2
// Output: 2
import java.util.*;
public class FirstSetBitPosition
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0)
        {
            System.out.println(0);
            return;
        }
        
        int position = 1;
        while((n & 1) == 0)
        {
            n = n >> 1;
            position++;
        }
        
        System.out.println(position);
    }
}