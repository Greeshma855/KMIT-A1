// There are some cubes, each cube is printed with an alphabet [A-Z].
// Using these cubes, you can create non-empty distinct words.
// and length of the words should be 0< length <= no.of.cubes.

// You are given a string of alphabets S, 
// Your task is to findout number of possible non-empty distinct words

// Input Format:
// -------------
// A string S, consist of A-Z letters only.

// Output Format:
// --------------
// Print an integer, number of possible non-empty distinct words.


// Sample Input-1:
// ---------------
// EGG

// Sample Output-1:
// ----------------
// 8

// Explanation:
// --------------
// The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


// Sample Input-2:
// ---------------
// MADAM

// Sample Output-2:
// ----------------
// 89


import java.util.*;
public class NumTilePossibilities
{
    static int cnt = 0;
    static int NumOfTiles(int[] freq)
    {
        for(int i=0;i<26;i++)
        {
            if(freq[i]>0)
            {
                freq[i]--;
                cnt++;
                NumOfTiles(freq);
                freq[i]++;
            }
        }
        return cnt;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int freq[] = new int[26];
        for(char c:s.toCharArray())
        {
            freq[c-'A']+=1;
        }
        System.out.println(NumOfTiles(freq));
    }
}