// In the magical world of Harry Potter, there are N enchanted locations, each 
// identified by a unique number from 1 to N. These locations are interconnected 
// by mystical, bidirectional pathways that allow witches and wizards to travel 
// between them.
// You are a young wizard starting your journey at location 1, and your goal is to 
// reach the final destination, location N. Along the way, you will need to traverse 
// several pathways, but to make the journey more challenging, you aim to use the 
// minimum number of pathways possible.

// you will be given number of locations, number of pathways. you need to return 
// how many pathways need to cross. If N is unreachable then return -1.

// input format : 
// ------------
// two integers N and E
// E number of integer pairs
// output format : 
// ----------------
// an integer

// Example1:
// ----------
// Input= 3
// 2
// 1 2
// 2 3
// output=2

// Explanation: 
// -------------
// To reach Node 2 from Node 1, 1 bridge is required to be crossed. 
// To reach Node 3 from Node 2, 1 bridge is required to be crossed.
// Hence, 2 bridges are required to be connected.

// Example 2:
// -------------
// Input=4
// 3
// 1 2
// 2 3
// 2 4
// Output=2

