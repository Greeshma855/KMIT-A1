// Mr.Bond is a spy, he sends messages to Ms.M in an encrypted manner,Ms. M 
// needs to reverse the characters before each special character(#,@,$,_,=,!, etc...) 
// in order to decrypt the message. In te decrypted message special characters remains 
// in the same position. Can you help Ms.M to do this. The string may contain lowercase
// alphabets and uppercase alphabets also.

// Input Format:string
// Output Format: string

// Example 1:
// ---------
// Input:
// ------
// ab-cd
// Output:
// -------
// dc-ba

// Example 2:
// ----------
// Input:
// ------
// a-bC-dEf-ghIj
// Output:
// -------
// j-Ih-gfE-dCba

// Constraints:
// -------------
// 1 <= s.length <= 100
// s consists of characters with ASCII values in the range [33, 122].
// s does not contain '\"' or '\\'.


import java.util.*;
public class Decrypt
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] c = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        List<Character> list = new ArrayList<>(Arrays.asList('#','@','$','_','=','!','-'));
        while(left<right)
        {
            if(!Character.isLetter(c[left]))
            {
                left++;
            }
            else if(!Character.isLetter(c[right]))
            {
                right--;
            }
            else
            {
                char l = s.charAt(left);
                char r = s.charAt(right);
                c[left]=r;
                c[right]=l;
                left++;
                right--;
            }

        }
        System.out.println(new String(c));
    
        
    }
}






