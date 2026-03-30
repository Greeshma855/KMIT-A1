// You are given an 'm * n' matrix 'spaces' that represents the layout of an art gallery. 
// If a space is unavailable, it is denoted by a '#' character; 
// otherwise, it is denoted by a '.' character.

// Art pieces can be influenced by those placed to the left, right, upper left, 
// and upper right due to their proximity, but they are not influenced by pieces 
// directly in front or behind them. 
// Return the maximum number of art pieces that can be placed in the gallery 
// without any influence being possible.

// Art pieces must be placed in available spaces.

// Input format
// ------------
// Number of rows in the space matrix 
// Space matrix

// Output format
// -------------
// Integer which represents the result

// Example 1:
// Sample Input 1
// --------------
// 3
// #.##.#
// .####.
// #.##.#

// Sample Output 1
// ---------------
// 4

// Explanation: The curator can place 4 art pieces in available spaces so they don't influence each other.


// Example 2:
// Sample Input 2
// --------------
// 5
// .#
// ##
// #.
// ##
// .#

// Sample Output 2
// ---------------
// 3


// Constraints:

// - 'spaces' contains only characters '.' and '#'.
// - 'm == spaces.length'
// - 'n == spaces[i].length'
// - '1 <= m <= 8'
// - '1 <= n <= 8'
