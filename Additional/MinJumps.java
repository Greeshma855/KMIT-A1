// Given an array of integers arr, you are initially positioned at the first index 
// of the array.

// In one step you can jump from index i to index:
// i + 1 where: i + 1 < arr.length.
// i - 1 where: i - 1 >= 0.
// j where: arr[i] == arr[j] and i != j.
// Return the minimum number of steps to reach the last index of the array.

// Notice that you can not jump outside of the array at any time.

// Example 1:
// ------------
// Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
// Output: 3
// Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that 
// index 9 is the last index of the array.

// Example 2:
// ------------
// Input: arr = [7]
// Output: 0
// Explanation: Start index is the last index. You do not need to jump.

// Example 3:
// ------------
// Input: arr = [7,6,9,6,9,6,9,7]
// Output: 1
// Explanation: You can jump directly from index 0 to index 7 which is last index 
// of the array.
 
// Constraints:
// -------------
// 1 <= arr.length <= 5 * 104
// -108 <= arr[i] <= 108




// ----------------------- My Method (doesn't work for all cases) -------------------------------------

// import java.util.*;

// public class MinJumps {

//     static Map<Integer, Integer> map;
//     static boolean[] visited;
//     static int n;

//     public static int jump(int[] arr, int current) {

//         // base cases
//         if (current < 0 || current >= n) return Integer.MAX_VALUE;
//         if (current == n - 1) return 0;
//         if (visited[current]) return Integer.MAX_VALUE;

//         visited[current] = true;

//         int minSteps = Integer.MAX_VALUE;

//         // jump to last occurrence if it moves forward
//         int lastIdx = map.get(arr[current]);
//         if (lastIdx > current) {
//             int res = jump(arr, lastIdx);
//             if (res != Integer.MAX_VALUE)
//                 minSteps = Math.min(minSteps, 1 + res);
//         }

//         // try +1
//         int res1 = jump(arr, current + 1);
//         if (res1 != Integer.MAX_VALUE)
//             minSteps = Math.min(minSteps, 1 + res1);

//         // try -1
//         int res2 = jump(arr, current - 1);
//         if (res2 != Integer.MAX_VALUE)
//             minSteps = Math.min(minSteps, 1 + res2);

//         visited[current] = false; // backtrack
//         return minSteps;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         int[] arr = new int[n];

//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         // build map ONCE
//         map = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             map.put(arr[i], i);
//         }

//         visited = new boolean[n];

//         int ans = jump(arr, 0);
//         System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
//     }
// }
