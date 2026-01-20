// Given a string s, reverse only all the vowels in the 
// string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
// appear in both lower and upper cases, more than once.

// Sample Input-1:
// ---------------
// hello

// Sample Output-1:
// ----------------
// holle

// Sample Input-2:
// ----------------
// Keshavmemorial

// Sample Output-2:
// ----------------
// Kashivmomerael



import java.util.*;
public class ReverseVowels
{
    public static String find(String s)
    {
        StringBuilder k = new StringBuilder(s);
        List<Character> vowels = new ArrayList<>();
        vowels.addAll(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int end = s.length()-1;
        int start = 0;
        while(start<end)
        {
            if(vowels.contains(k.charAt(start)) && vowels.contains(k.charAt(end)))
            {
                char temp = k.charAt(start);
                k.setCharAt(start,k.charAt(end));
                k.setCharAt(end,temp);
                start++;
                end--;
           
            }
            if(!vowels.contains(k.charAt(start)))
            {
                start++;
            }
            if(!vowels.contains(k.charAt(end)))
            {
                end--;
            }
        }
        
        return k.toString();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(find(s));
        
        
    }
}