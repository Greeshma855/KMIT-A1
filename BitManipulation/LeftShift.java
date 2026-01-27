//Write a java program to perform left shift on given integer by 1 position

// Example 1:
// Input = 4
// output = 8

// Example 2:
// Input = 10
// Output = 20

import java.util.*;
public class LeftShift
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n<<1);
    }
}