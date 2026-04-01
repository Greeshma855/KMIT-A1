// In the mystical land of Graphonia, there exists an ancient forest known as the 
// Enchanted Forest. 
// The forest is represented by a graph with N nodes (0 to N-1). 
// Where each node has neighboring nodes. 
// Some nodes are terminal (with no outgoing edges), 
// while others are safe (all paths lead to terminal nodes or other safe nodes).

// Your task is to find and map all safe nodes in the forest. 
// Return an array of safe nodes, sorted in ascending order.

// Input format
// ------------
// Line 1: Number of nodes, N
// Next N lines of input represents space seperated edges of each node starting 
// from 0 to N-1

// Note:
// if the edge is -1 then it represent there is no edge for that particular node

// Output format
// -------------
// List of safe nodes in ascending order


// Sample Input 1
// ---------------
// 7
// 1 2 (0)
// 2 3 (1)
// 5   (2)
// 0   (3)
// 5   (4)
// -1
// -1

// Sample output 1
// ---------------
// [2, 4, 5, 6]
// Explanation: Nodes 5 and 6 are terminal nodes, and every path starting at nodes 
// 2, 4, 5, and 6 leads to either node 5 or 6.

// Example 2:

// Sample Input 2
// --------------
// 5
// 1 2 3 4
// 1 2
// 3 4
// 0 4
// -1

// Sample Output 2
// ---------------
// [4]
  
// Explanation: Only node 4 is a terminal node, and every path starting at node 4 
// leads to node 4.
