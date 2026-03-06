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
		
	}

	// A utility function to left rotate subtree rooted with x
	public static TreapNode leftRotate(TreapNode x) 
	{
		
	}

	/* Utility function to add a new key */
	public static TreapNode newNode(int key) 
	{
		
	}
	
	
	public static TreapNode insertNode(TreapNode root, int key) 
	{
	}

	/* Recursive implementation of Delete() */
	public static TreapNode deleteNode(TreapNode root, int key) {
}

	// Search a given key in a given BST
	public static TreapNode search(TreapNode root, int key)
	{
	
	}

	static void preorder(TreapNode root)
	{
	
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
			System.out.println("Search result "+ result.key + " " + result.priority);
		else
			System.out.println("Key " + key + " not found");
		
		do
		{
			System.out.println("Enter item to delete ");
			key = sc.nextInt();
			root = deleteNode(root, key);
			System.out.println("After delete");
			preorder(root);
		} while(key != -1 && root != null);
    }
}