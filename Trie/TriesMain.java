class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int prefixCount;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        prefixCount = 0;
    }
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // ====== Insert Word ======
    public void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
            node.prefixCount++;
        }

        node.isEndOfWord = true;
    }

    // ====== Search Word ======
    public boolean search(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

        return node.isEndOfWord;
    }

    // ====== Check Prefix ======
    public boolean startsWith(String prefix) {

        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

        return true;
    }

    // ====== Count Words With Prefix ======
    public int countWordsWithPrefix(String prefix) {

        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                return 0;
            }

            node = node.children[index];
        }

        return node.prefixCount;
    }

    // ====== Delete Word ======
    public void delete(String word) {
        deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode node, String word, int depth) {

        if (node == null) return false;

        if (depth == word.length()) {

            if (!node.isEndOfWord) return false;

            node.isEndOfWord = false;

            return isEmpty(node);
        }

        int index = word.charAt(depth) - 'a';

        if (deleteHelper(node.children[index], word, depth + 1)) {

            node.children[index] = null;

            return !node.isEndOfWord && isEmpty(node);
        }

        return false;
    }

    private boolean isEmpty(TrieNode node) {

        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }

        return true;
    }

    // ====== Display Words ======
    public void display() {
        displayHelper(root, "");
    }

    private void displayHelper(TrieNode node, String word) {

        if (node.isEndOfWord) {
            System.out.println(word);
        }

        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {

                char ch = (char) (i + 'a');

                displayHelper(node.children[i], word + ch);
            }
        }
    }

        public void printTrie() 
        {
            printTrieHelper(root, "", "root");
    }

    private void printTrieHelper(TrieNode node, String indent, String label) {

    if(node == null) return;

    System.out.print(indent + label);

    if(node.isEndOfWord)
        System.out.print(" *");

    System.out.println();

    for(int i = 0; i < 26; i++) {

        if(node.children[i] != null) {

            char ch = (char)(i + 'a');

            printTrieHelper(
                node.children[i],
                indent + "   ",
                "└── " + ch
            );
        }
    }
}
}

public class TriesMain {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("captivate");
        trie.insert("dog");
        trie.insert("cap");

        System.out.println("Search cat: " + trie.search("cat"));
        System.out.println("Search cow: " + trie.search("cow"));

        System.out.println("Prefix ca: " + trie.startsWith("ca"));

        System.out.println("Words with prefix 'ca': " + trie.countWordsWithPrefix("ca"));

        System.out.println("\nAll words:");
        trie.display();

        trie.delete("cat");

        System.out.println("\nAfter deleting 'cat':");
        trie.display();
        trie.printTrie();
    }
}