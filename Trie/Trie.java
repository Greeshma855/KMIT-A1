// 1. Write a Java program to implement a Trie (Prefix Tree) that stores a set of 
// lowercase English words.
// The program should support operations such as Insert, Search, Delete and Display.

// Initially, the program reads a line containing words separated by spaces and 
// inserts them into the Trie.
// After constructing the Trie, the program should repeatedly accept numeric 
// options from the user to perform the following operations:

// 1.Insert – Insert a new word into the Trie.
// 2.Search – Check whether a given word exists in the Trie.
// 3.Delete – Delete a word from the Trie if it exists.
// 4.Display – Display all the words currently stored in the Trie.
// 5.Exit – Terminate the program.

// All words consist only of lowercase English letters (a–z).

// Input Format:
// ------------
// - A list of words separated by spaces to initialize the Trie.
// - A number representing the operation to be performed.
// - If the option is 1, 2, or 3, the next input will be a word related to that 
// operation.
// - The last input will always be 5, which terminates the program.

// Output Format:
// -------------
// - The program should display appropriate messages based on the operation 
// performed.
// - After Insert, display the updated content of the Trie.
// - For Search, print whether the word is present or not.
// - After Delete print whether deletion was successful and display the updated 
// Trie.
// - For Display, print all words currently stored in the Trie.

// Example 1:
// ---------
// Input
// -----
// apple ape ant animal
// 4
// 2 apple
// 1 ball
// 3 ape
// 4
// 5

// Output
// ------
// //(4)
// Content of Trie:
// animal
// ant
// ape
// apple

// //(2)
// apple is present

// //(1)
// Content of Trie:
// animal
// ant
// ape
// apple
// ball

// //(3)
// ape is deleted

// //(3)
// Content of Trie after deletion:
// animal
// ant
// apple
// ball

// //(4)
// Content of Trie:
// animal
// ant
// apple

import java.util.*;

class Trie 
{	
	static final int NUM_CHARS = 26;
	// To handle prefix deletion
	static boolean isDeleted = false;	
	// trie node
	static class TrieNode
	{
		TrieNode[] children = new TrieNode[NUM_CHARS];
	
		// isEndOfWord is true if the node represents end of a word
		boolean isEndOfWord;
		
		TrieNode()
		{
			isEndOfWord = false;
			for (int i = 0; i < NUM_CHARS; i++)
				children[i] = null;
		}
	};
	
	static TrieNode root;
	
	// If not present, inserts key into trie
	// If the key is prefix of trie node, just marks leaf node
	static void insert(String key)
	{
		int level;
		int length = key.length();
		int index;
	
		TrieNode currentNode = root;
	
		for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
			if (currentNode.children[index] == null)
				currentNode.children[index] = new TrieNode();
	
			currentNode = currentNode.children[index];
		}
	
		// mark last node as leaf
		currentNode.isEndOfWord = true;
	}
	
	// Returns true if key (prefix or complete word) is present in trie, else false
	static boolean search(String key)
	{
		int level;
		int length = key.length();
		int index;
		TrieNode currentNode = root;
	
		for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
	
			if (currentNode.children[index] == null)
				return false;
	
			currentNode = currentNode.children[index];
		}
	
		// To check if prefix exists in the Trie
		// return true;

		// To check for complete word
		return (currentNode.isEndOfWord);
	}

	// Returns true if root has no children, else false
    static boolean isEmpty(TrieNode root)
    {
        for (int i = 0; i < NUM_CHARS; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

	// Recursive function to delete a key from given Trie
    static TrieNode delete(TrieNode root, String key, int depth)
    {
		//System.out.println("key " + key + " depth " + depth + " root.isEndOfWord " + root.isEndOfWord);
        // If tree is empty
        if (root == null)
            return null;
 
        // If last character of key is being processed
        if (depth == key.length()) 
		{ 
			// isDeleted is true if it is end of word and not otherwise
			isDeleted = root.isEndOfWord;
            // This node is no more end of word after removal of given key
            if (root.isEndOfWord)
                root.isEndOfWord = false;
 
            // If given is not prefix of any other word
            if (isEmpty(root)) 
			{
                return null;
            } 
            return root;
        }
		
		// If not last character, recur for the child obtained using ASCII value
        int index = key.charAt(depth) - 'a';
		//System.out.println("index " + index + " key.charAt(depth) " + key.charAt(depth));

		if (root.children[index] == null)
				return null;

        root.children[index] = delete(root.children[index], key, depth + 1);
 
        // If root does not have any child (its only child got
        // deleted), and it is not end of another word.
        if (isEmpty(root) && root.isEndOfWord == false)
		{
            return null;
        } 
        return root;
    }

	// To check if current node is leaf node or not
	static boolean isLeafNode(TrieNode root) 
	{
		return root.isEndOfWord == true;
	}
 
	// print Trie
	static void print(TrieNode root, char[] str, int level) 
	{
		// If node is leaf node, it indicates end of string, 
		// so a null character is added and string is printed
		if (isLeafNode(root)) 
		{
			for (int k = level; k < str.length; k++)
				str[k] = 0;
			System.out.println(str);
		}
	 
		int i;
		for (i = 0; i < NUM_CHARS; i++) 
		{
			// if NON NULL child is found add parent key to str and
			// call the print function recursively for child node
			if (root.children[i] != null) 
			{
				str[level] = (char) (i + 'a');
				print(root.children[i], str, level + 1);
			}
		}
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String keys[]=sc.nextLine().split(" ");	
		root = new TrieNode();
		// Construct trie
		int i;
		for (i = 0; i < keys.length ; i++)
			insert(keys[i]);

		char[] str = new char[50];
		String word;
	LABEL1: while(true)
		{
			int opt = sc.nextInt();
			sc.nextLine();
			switch(opt)
			{
				case 4:
					System.out.println("Content of Trie: ");
					print(root, str, 0);
					break;
				case  1:
					String s = sc.nextLine();
					insert(s);
					System.out.println("Content of Trie: ");
					print(root, str, 0);
					break;
				case 2:
					word = sc.next();
					if(search(word) == true)
						System.out.println(word + " is present ");
					else 
						System.out.println(word + " is not present");
					break;
				case 3:
					word = sc.next();
					if(delete(root, word, 0) != null & isDeleted == true)
						System.out.println(word + " is deleted ");
					else
						System.out.println(word + " is not present in Trie to be deleted");
					System.out.println("Content of Trie after deletion: ");
					print(root, str, 0);
					break;
				case 5:
					break LABEL1;
			}
		}
	}	
}