import java.util.*;
class TrieNode
{
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode()
    {
        children = new TreeMap<>();
        isEndOfWord = false;
    }
}
class Trie
{
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode curNode = root;

        for(char c : word.toCharArray())
        {
            curNode.children.putIfAbsent(c, new TrieNode());
            curNode = curNode.children.get(c);
        }
        curNode.isEndOfWord = true;
    }
    public void printTrie()
    {
        printTrieHelper(root, new StringBuilder());
    }

    public void printTrieHelper(TrieNode node, StringBuilder prefix)
    {
        if(node.isEndOfWord)
        {
            System.out.println(prefix.toString());
        }
        for(Map.Entry<Character, TrieNode> entry : node.children.entrySet())
        {
            char c = entry.getKey();
            TrieNode child = entry.getValue();
            prefix.append(c);
            printTrieHelper(child, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
    public boolean search(String word)
    {
        TrieNode currNode = root;
        for(char c : word.toCharArray())
        {
            if(currNode.children.get(c) == null)
            {
                return false;
            }
            currNode = currNode.children.get(c);
        }
        return currNode.isEndOfWord;
    }
}

class test
{
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
		String words[]=sc.nextLine().split(" ");	

        Trie trie = new Trie();
        for(String word : words)
            trie.insert(word);

        trie.printTrie();
        while(true)
		{
			System.out.println("Enter a word to search");
			String word = sc.next();
			if(word.equals("-1"))
				break;
			if(trie.search(word) == true)
				System.out.println(word + " is present ");
			else System.out.println(word + " is not present");
		}
    }
}

/*
Output=
ant
bat
cat
Enter a word to search
bat
bat is present 
Enter a word to search
ba
ba is not present
*/
