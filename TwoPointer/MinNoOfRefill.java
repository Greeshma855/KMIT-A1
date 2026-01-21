// Andy and Berry are serving water to n guests sitting in a line.
// Each guest needs a certain amount of water.

// Andy starts serving from the left end (guest 0).
// Berry starts serving from the right end (guest n−1).
// Both move towards the center.

// Each of them has a water jar:
// Andy’s jar has capacity: capacityA
// Berry’s jar has capacity: capacityB

// Initially, both jars are full.

// Before serving a guest:
// If the jar does not have enough water, it must be refilled.

// Refilling is instant.

// When both reach the same guest, the person who has more water serves that guest.
// If both have the same amount, Andy serves.

// Your task is to calculate how many times the jars are refilled to serve all 
// guests.

// Input Format:
// ------------------------------------------
// An integer n – number of guests
// n integers – water required by each guest
// Integer capacityA – Andy’s jar capacity
// Integer capacityB – Berry’s jar capacity

// Output Format:
// ----------------------------------
// Print a single integer:
// the total number of refills required

// Sample Input 1:
// --------------
// 6
// 2 4 5 1 2 3
// 5
// 5
 
// Sample Output 1:
// ----------------
// 3



