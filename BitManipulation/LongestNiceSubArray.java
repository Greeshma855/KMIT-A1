// You are given an array of integers.
// A subarray is called nice if no two numbers in it share a common set bit
// Your task is to find the length of the longest nice subarray.

// Input Format:
// ----------------
// n
// array integers

// Output format:
// ----------------
// length of longest nice subarray

// Sample Input:
// -------------
// 5
// 1 3 8 48 10

// Sample Output:
// -------------
// 3

// Explanation:
// ------------
// 1  = 00001  
// 3  = 00011  
// 8  = 01000  
// 48 = 110000  
// 10 = 01010
// The longest nice subarray is: [3, 8, 48]
// No two numbers share a set bit.
