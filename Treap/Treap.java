// Implement a Treap data structure that performs the following operations:
// -Insert elements into the Treap.
// -Display all nodes (key and priority).
// -Search for a given element.
// -Delete a given element.
// -Display the updated Treap after deletion.

// Input Format:
// ------------
// An integer n — number of elements to insert.
// n space-separated integers — keys to be inserted into the Treap.
// An integer — key to search.
// One or more integers — keys to delete.
// Enter -1 to stop deletion.

// Output Format:
// -------------
// Display the Preorder Traversal of the Treap after insertion.
// Display the search result 
// After each deletion, display:After delete; 
// followed by the preorder traversal of the updated Treap.

// Sample Input - 1:
// -----------------
// 6
// 2 4 3 1 7 5
// 3
// 4
// -1

// Sample Output - 1:
// -------------------
// Key: 4 Priority: 87
// Key: 2 Priority: 65
// Key: 1 Priority: 22
// Key: 3 Priority: 70
// Key: 7 Priority: 50
// Key: 5 Priority: 15

// Element found: 3 with Priority: 70

// Treap after deletion:
// Key: 3 Priority: 70
// Key: 2 Priority: 65
// Key: 1 Priority: 22
// Key: 7 Priority: 50
// Key: 5 Priority: 15


import java.util.Scanner;

// A Treap Node
class TreapNode
{
	int key, priority;
	TreapNode left, right;
}

class Treap
{
	public static TreapNode rightRotate(TreapNode y) 
	{
		TreapNode x = y.left;
		TreapNode T2 = x.right;
		x.right = y;
		y.left = T2;
		return x;
	}

	// A utility function to left rotate subtree rooted with x
	public static TreapNode leftRotate(TreapNode x) 
	{
		TreapNode y = x.right;
		TreapNode T2 = y.left;
		y.left = x;
		x.right = T2;
		return y;
	}

	/* Utility function to add a new key */
	public static TreapNode newNode(int key) 
	{
		TreapNode node = new TreapNode();
		node.key = key;
		node.priority = (int)(Math.random() * 100);
		node.left = null;
		node.right = null;
		return node;
	}
	
	
	public static TreapNode insertNode(TreapNode root, int key) 
	{
		if (root == null) return newNode(key);
		if (key <= root.key) {
			root.left = insertNode(root.left, key);
			if (root.left.priority > root.priority) {
				root = rightRotate(root);
			}
		} else {
			root.right = insertNode(root.right, key);
			if (root.right.priority > root.priority) {
				root = leftRotate(root);
			}
		}
		return root;
	}

	/* Recursive implementation of Delete() */
	public static TreapNode deleteNode(TreapNode root, int key) {
		if (root == null) return root;
		if (key < root.key) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			if (root.left.priority < root.right.priority) {
				root = leftRotate(root);
				root.left = deleteNode(root.left, key);
			} else {
				root = rightRotate(root);
				root.right = deleteNode(root.right, key);
			}
		}
		return root;
	}

	// Search a given key in a given BST
	public static TreapNode search(TreapNode root, int key)
	{
		if (root == null || root.key == key) return root;
		if (key < root.key) return search(root.left, key);
		return search(root.right, key);
	}

	static void preorder(TreapNode root)
	{
		if (root != null) {
			System.out.println("Key: " + root.key + " Priority: " + root.priority);
			preorder(root.left);
			preorder(root.right);
		}
	}

	
	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        TreapNode root = null;
        for(int a:arr){
            root = insertNode(root,a);
        }
		preorder(root);
		System.out.println("Enter item to search ");
		int key = sc.nextInt();

		TreapNode result = search(root, key);
		if(result != null)
			System.out.println("Element found: " + result.key + " with Priority: " + result.priority);
		else
			System.out.println("Key " + key + " not found");
		
		do
		{
			System.out.println("Enter item to delete ");
			key = sc.nextInt();
			if(key != -1){
				root = deleteNode(root, key);
				System.out.println("Treap after deletion:");
				preorder(root);
			}
		} while(key != -1 && root != null);
    }
}