// Malika taught a new fun time program practice for Engineering Students.
// As a part of this she has given set of N numbers, and asked the students 
// to perform the operations listed below:
// 1. sumRange(start, end) - return the sum of numbers between the indices start 
// and end, both are inclusive.
// 2. update(ind, val) - update the value at the index 'ind' to 'val'.
// 3. Find the min value in the given range
// 4. Find the max value in the given range 

// Your task is to solve this problem using Segment Tree concept.

// Input Format:
// -------------
// Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
// Line-2: N space separated integers.
// next Q lines: Three integers option, start/ind and end/val.

// Output Format:
// --------------
// An integer result, for every sumRange query.


// Sample Input:
// -------------
// 8 7
// 4 2 13 3 25 16 17 8
// 1 2 6		//sumRange
// 1 0 7		//sumRange
// 3 2 6       //get min value in the range
// 2 2 18	    //update
// 2 4 17	    //update
// 1 2 6		//sumRange
// 4 1 5       // get max value in the range

// Sample Output:
// --------------
// 74
// 88
// 3
// 71
// 18





import java.util.*;
class SegmentTreeMinMax{
    class SegmentTreeNode{
        int start, end;
        SegmentTreeNode left, right;
        int sum, min, max;
        public SegmentTreeNode(int start,int end){
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.max = 0;
            this.min = 0;
            this.sum = 0;
        }
    }
    
    SegmentTreeNode root = null;
    public SegmentTreeMinMax(int[] nums){
        root = buildTree(nums,0,nums.length-1);
    }
    public SegmentTreeNode buildTree(int[] nums,int start,int end)
    {
        if(start>end)
        {
            return null;
        }
        SegmentTreeNode n = new SegmentTreeNode(start,end);
        if(start==end)
        {
            n.sum = nums[start];
            n.min = nums[start];
            n.max = nums[start];
        }
        else
        {
            int mid = (start+end)/2;
            n.left = buildTree(nums,start,mid);
            n.right = buildTree(nums,mid+1,end);
            n.sum = n.left.sum + n.right.sum;
            n.min = Math.min(n.left.min,n.right.min);
            n.max = Math.max(n.left.max,n.right.max);
        }
        return n;
    }

    void update(int i,int val)
    {
        update(root,i,val);
    }
    
    void update(SegmentTreeNode root,int pos,int val)
    {
        if(root.start == root.end)
        {
            root.sum = val;
            root.min = val;
            root.max = val;
        }
        else
        {
            int mid = (root.start+root.end)/2;
            if(pos <= mid)
            {
                update(root.left,pos,val);
            }
            else
            {
                update(root.right,pos,val);
            }
            root.sum = root.left.sum + root.right.sum;
            root.min = Math.min(root.left.min,root.right.min);
            root.max = Math.max(root.left.max,root.right.max);
        }
    }
    
    public int SumRange(int i,int j)
    {
        return SumRange(root,i,j);
    }
    
    public int SumRange(SegmentTreeNode root, int start, int end)
    {
        if(root.start == start && root.end == end )
        {
            return root.sum;
        }
        else
        {
            int mid = (root.start + root.end)/2;
            if(end <= mid)
            {
                return SumRange(root.left,start,end);
            }
            else if(start >= mid+1)
            {
               return SumRange(root.right,start,end); 
            }
            else
            {
                return SumRange(root.left, start, mid)+
                SumRange(root.right,mid+1,end);
            }
        }
    }
    
    public int min(int i,int j)
    {
        return min(root,i,j);
    }
    
    public int min(SegmentTreeNode root, int start, int end)
    {
        if(root.start == start && root.end == end )
        {
            return root.min;
        }
        else
        {
            int mid = (root.start + root.end)/2;
            if(end <= mid)
            {
                return min(root.left,start,end);
            }
            else if(start >= mid+1)
            {
               return min(root.right,start,end); 
            }
            else
            {
                return Math.min(min(root.left, start, mid),
                min(root.right,mid+1,end));
            }
        }
    }
    
    public int max(int i,int j)
    {
        return max(root,i,j);
    }
    
    public int max(SegmentTreeNode root, int start, int end)
    {
        if(root.start == start && root.end == end )
        {
            return root.max;
        }
        else
        {
            int mid = (root.start + root.end)/2;
            if(end <= mid)
            {
                return max(root.left,start,end);
            }
            else if(start >= mid+1)
            {
               return max(root.right,start,end); 
            }
            else
            {
                return Math.max(max(root.left, start, mid),
                max(root.right,mid+1,end));
            }
        }
    }
    
}

class SegmentTreeTest
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        SegmentTreeMinMax st = new SegmentTreeMinMax(arr);
        while(q-- != 0)
        {
            int opt = sc.nextInt();
            if(opt==1)
            {
                int s1 = sc.nextInt();
                int s2 = sc.nextInt();
                System.out.println(st.SumRange(s1,s2));
            }
            if(opt==2)
            {
                int index = sc.nextInt();
                int val = sc.nextInt();
                st.update(index,val);
            }
            if(opt==3)
            {
                int s1 = sc.nextInt();
                int s2 = sc.nextInt();
                System.out.println(st.min(s1,s2));
            }
            if(opt==4)
            {
                int s1 = sc.nextInt();
                int s2 = sc.nextInt();
                System.out.println(st.max(s1,s2));
            }
        }
    }
}




