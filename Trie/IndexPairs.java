// theAn 8th standard student has been assigned a task as part of punishment for his mistake.

// The task is, there is an input string STR(without any space) and an array of 
// strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
// index and ending index of every string in words[] in the input string STR.

// Note: Print the pairs[s, e] in sorted order.
// (i.e., sort them by their first coordinate, and in case of ties sort them by 
// their second coordinate).

// Input Format
// ------------
// Line-1: string STR(without any space)
// Line-2: space separated strings, words[]

// Output Format
// -------------
// Print the pairs[s, e] in sorted order.


// Sample Input-1:
// ---------------
// thekmecandngitcolleges
// kmec ngit colleges

// Sample Output-1:
// ----------------
// 3 6
// 10 13
// 14 21


// Sample Input-2:
// ---------------
// xyxyx
// xyx xy

// Sample Output-2:
// ----------------
// 0 1
// 0 2
// 2 3
// 2 4

// Explanation: 
// ------------
// Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].


// Sample Input-3:
// ---------------
// kmecngitkmitarecsecolleges
// kmit ngit kmec cse

// Sample Output-3:
// ----------------
// 0 3
// 4 7
// 8 11
// 15 17


import java.util.*;
public class IndexPairs
{
    static String text;
    static final int NUM_CHARS = 26;
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[NUM_CHARS];
        boolean isEndOfWord;
        TrieNode()
        {
            isEndOfWord = false;
            for(int i=0;i<NUM_CHARS;i++)
            {
                children[i] = null;
            }
        }
    }
    static TrieNode root = new TrieNode();
    static void insert(String key)
    {
        TrieNode currentNode = root;
        for(int i=0;i<key.length();i++)
        {
            int index = key.charAt(i)-'a';
            if(currentNode.children[index]==null)
            {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }
    static void search()
    {
        for(int i=0;i<text.length();i++)
        {
          TrieNode currentNode = root;
          
          for(int j=i;j<text.length();j++)
          {
            int index = text.charAt(j)-'a';
            if(currentNode.children[index]==null)
            {
              break;  
            }  
            currentNode = currentNode.children[index];
            if(currentNode.isEndOfWord)
            {
              System.out.println(i+" "+j);  
            }  
          } 
         
        }  
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        text = sc.next();
        sc.nextLine();
		String[] words= sc.nextLine().split(" ");
        for(int i = 0; i < words.length; i++) 
        {
            insert(words[i]);
        }
        search();
    }
}