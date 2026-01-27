// Write a Java program to count the number of bits of an integer.
import java.util.*;
public class CountOfSetBits
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int cnt = 0;
        while(a>0)
        {
            a = a&(a-1);
            cnt++;
        }
        System.out.println(cnt);
    }
}