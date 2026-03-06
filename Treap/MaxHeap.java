// Design and implement a Max Heap data structure using an array in Java.
// In a Max Heap, every parent node is greater than or equal to its child nodes, 
// ensuring that the largest element is always at the root.

// Sample Input:
// -------------
// 5
// 1 2 3 4 5

// Sample Output:
// -------------
// The max value is 5


import java.util.*;

public class MaxHeap {
    private int[] Heap;
    private int size;

    // Constructor to initialize an empty max heap
    public MaxHeap(int maxsize) {
        
    }

    // Return the index of the parent
    private int parent(int pos) {
        
    }

    // Return the index of the left child
    private int leftChild(int pos) {
        
    }

    // Return the index of the right child
    private int rightChild(int pos) {
        
    }

    // Check if the node at pos is a leaf node
    private boolean isLeaf(int pos) {
        
    }

    // Swap nodes at positions fpos and spos
    private void swap(int fpos, int spos) {
        
    }

    // Recursive function to max heapify the subtree at index pos
    private void maxHeapify(int pos) {
       
    }

    // Insert a new element into the max heap
    public void insert(int element) {
        
    }

    // Remove and return the maximum element from the heap
    public int extractMax() {
        
    }

    // Display heap structure
    public void print() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent: " + Heap[i]);
            if (leftChild(i) < size)
                System.out.print(" Left Child: " + Heap[leftChild(i)]);
            if (rightChild(i) < size)
                System.out.print(" Right Child: " + Heap[rightChild(i)]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        MaxHeap maxHeap = new MaxHeap(n);

        for (int i = 0; i < n; i++) {
            maxHeap.insert(scan.nextInt());
        }

        System.out.println("The max value is " + maxHeap.extractMax());
    }
}
