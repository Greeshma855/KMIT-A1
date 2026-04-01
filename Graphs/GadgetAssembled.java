// You have information about 'n' different gadgets. 
// You are given a list of 'gadgets'. The 'i'th gadget has the name 'gadgets[i]', 
// and you can build it if you have all the needed components 
// where components of each gadget are provided.
// You are also given a string array 'supplies' containing all the components 
// that you initially have, and you have an infinite supply of all of them.
// Components for a gadget may need to be assembled from other gadgets i.e.
// may contain a string that is in 'gadgets'.

// Return a list of all the gadgets that you can build.
// Note that two gadgets may require each other in their components.

// Input format
// ------------
// Line 1: Space separated gadgets
// Line 2: Space seperated supplies
// next lines of input includes 'n' times the gadgets
// number of components of a gadget say 'x'
// 'x' number of components of that gadget in each line

// Output format
// -------------
// List of gadgets which can be assembled based on given input

// Example 1:

// Sample Input 1:
// ---------------
// smartphone
// screen processor camera
// 2
// screen processor

// Sample Output 1:
// -----------------
// [smartphone]

// Explanation: We can build a "smartphone" since we have the components "screen" and "processor".


// Example 2:

// Input 2
// --------
// smartphone camera
// screen processor lens
// 2
// screen
// processor
// 2
// smartphone
// lens

// Output 2
// ---------
// [smartphone, camera]

// Explanation:
// We can build a "smartphone" since we have the components "screen" and "processor".
// We can build a "camera" since we have the component "lens" and can assemble the component "smartphone".

// Note: All the values of 'gadgets' and 'supplies' combined are unique.
