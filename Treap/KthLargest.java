// There are n football players standing in the ground, coach wants to know the 
// K-th largest height of the players. Given an array of heights[] and the value 
// of K. 
// Help the coach to find the P'th largest height.

// Note: You are supposed to print the K'th largest height in the sorted order 
// of heights[].
//       Not the P'th distinct height.

// Input Format:
// -------------
// Line-1: Size of array n and P value(space separated)
// Line-2: Array elements of size n.

// Output Format:
// --------------
// Print K'th largest height.

// Sample input-1:
// ---------------
// 8 2
// 1 2 1 3 4 5 5 5

// Sample output-1:
// ----------------
// 5

// Sample input-2:
// ---------------
// 6 3
// 2 4 3 1 2 5

// Sample output-2:
// ----------------
// 3

import java.util.*;

class TreapNode{
    int data;
    int priority;
    TreapNode left;
    TreapNode right;

    TreapNode(int data){
        this.data = data;
        this.priority = new Random().nextInt(1000);
        this.left = this.right = null;
    }
}

class KthLargest{
    static int k;
    static boolean found = false;
    public static TreapNode newNode(int key)
    {
        return new TreapNode(key);
    }

    public static TreapNode rotateLeft(TreapNode root)
    {
        TreapNode temp = root.right;
        root.right = temp.left;
        temp.left = root;
        return temp;
    }

    public static TreapNode rotateRight(TreapNode root)
    {
        TreapNode temp = root.left;
        root.left = temp.right;
        temp.right = root;
        return temp;
    }

    public static TreapNode insertNode(TreapNode root, int data)
    {
        if(root == null)
            return newNode(data);

        if(data <= root.data)
        {
            root.left = insertNode(root.left, data);
            if(root.left.priority > root.priority)
                root = rotateRight(root);
        }

        else if(data > root.data)
        {
            root.right = insertNode(root.right, data);

            if(root.right.priority > root.priority)
                root = rotateLeft(root);
        }

        return root;
    }

    static void inorder(TreapNode root)
    {
        if(root == null || found) return;
        inorder(root.left);
        if(found) return;
        k--;
        if(k == 0){
            System.out.println(root.data);
            found = true;
            return;
        }

        inorder(root.right);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        k = n - p + 1;
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        TreapNode root = null;
        for(int a : arr)
            root = insertNode(root, a);
        inorder(root);
    }

}