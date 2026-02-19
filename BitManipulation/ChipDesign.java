// You are working in an electronic circuit design industry. You will be given a 
// chip which consists of n flipflops numbered from 0 to n-1, Initially all flipflops 
// are set to 0. Your task is to change the chip position to given target, where 
// target[i] is '1' if the i-th flipflop is turned on and is '0' if it is turned off.

// You have a switch to change the state of the flipflops which is called as 
// flip operation defined as follows:

// Choose any flipflop (index i) of your current configuration.
// Flip each flipflop from index i to n-1.

// When any flipflop is flipped it means that if it is 0 it changes to 1 
// and if it is 1 it changes to 0.

// Return the minimum number of flips required to form target.

// Note : use bitmanipulation approach only

// Input format : 
// -------------
// Binary string

// Output format:
// -------------
// an integer

// Example 1:
// ---------
// Input:
// -------
// 10111

// Output: 
// ---------
// 3
// Explanation: 
// -----------
// Initial configuration "00000".
// flip from the third bulb:  "00000" -> "00111"
// flip from the first bulb:  "00111" -> "11000"
// flip from the second bulb:  "11000" -> "10111"
// We need at least 3 flip operations to form target.

// Constraints:
// ===========
// 1 <= target.length <= 10^5
// target[i] == '0' or target[i] == '1'
