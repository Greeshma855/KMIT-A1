// Given two integers left and right, return the count of numbers in the inclusive 
// range [left, right] having a prime number of set bits in their binary
// representation.

// Recall that the number of set bits an integer has the number of 1's present when
// written in binary.

// For example, 21 written in binary is 10101, which has 3 set bits.
 
// Input Format:
// -------------
// Line-1: Two separated integers

// Output Format:
// --------------
// Line-1: An integer

// Sample Input-1:
// ---------------
// 6  10

// Sample Output-1:
// ---------------
// 4

// Explanation:
// ------------
// 6  -> 110 (2 set bits, 2 is prime)
// 7  -> 111 (3 set bits, 3 is prime)
// 8  -> 1000 (1 set bit, 1 is not prime)
// 9  -> 1001 (2 set bits, 2 is prime)
// 10 -> 1010 (2 set bits, 2 is prime)
// 4 numbers have a prime number of set bits.

// Sample Input-2:
// ---------------
// 10 15

// Sample Output-2:
// ---------------
// 5

// Explanation:
// ------------
// 10 -> 1010 (2 set bits, 2 is prime)
// 11 -> 1011 (3 set bits, 3 is prime)
// 12 -> 1100 (2 set bits, 2 is prime)
// 13 -> 1101 (3 set bits, 3 is prime)
// 14 -> 1110 (3 set bits, 3 is prime)
// 15 -> 1111 (4 set bits, 4 is not prime)
// 5 numbers have a prime number of set bits.

import java.util.*;
class Solution {
    public int PrimeSetBits(int left, int right) {
        Set<Integer> isPrime = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31));
        int primes = 0;
        for(int i=left;i<=right;i++)
        {
            int a = i;
            int cnt = 0;
            while(a>0)
            {
                a = a&(a-1);
                cnt++;
            }
            if(isPrime.contains(cnt))
            {
                primes++;
            }
        }
        return primes;

    }
}