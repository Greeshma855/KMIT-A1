// You are given an array called encoded, where each element is formed by 
// taking the XOR of two consecutive elements of another hidden array arr.

// You are also given the first element of the original array arr.
// Your task is to reconstruct and print the original array.

// Input Format:
// ------------------
// n — the number of elements in the encoded array.
// n space-separated integers — the elements of the encoded array.
// first — the first element of the original array.

// Output Format:
// -----------------------
// The decoded original array of size n + 1.

// Sample Input 1:
// -------------------
// 4
// 6 2 7 3
// 4

// Sample Output 1:
// -------------------
// [4, 2, 0, 7, 4]

class decode {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] arr = new int[n+1];
        arr[0]=first;
        for(int i=1;i<=n;i++)
        {
            arr[i]=arr[i-1]^encoded[i-1];
        }
        return arr;
    }
}