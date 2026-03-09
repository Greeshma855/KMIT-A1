Design and implement a Trie (Prefix Tree) to store a collection of lowercase 
words (a–z).
The Trie should allow duplicate word insertions and maintain the frequency of 
each word using a counter at the EndOfWord node.

The program should perform the following operations:
-Insert Words
-Display Words with Frequency
-Delete a Word
When a word is deleted, decrease its frequency by 1.
If the frequency becomes 0, remove the word completely from the Trie.
Display Updated Frequencies
After deletion, print the updated list of words and their frequencies.
-Exit the program.

Example:
--------
Enter words:
hell hello and and and hell and and and

Words with Frequency:
and : 6
hell : 2
hello : 1

1.Delete Word
2.Display
3.Exit
1
Enter word to delete:
and

Updated Trie:
and : 5
hell : 2
hello : 1