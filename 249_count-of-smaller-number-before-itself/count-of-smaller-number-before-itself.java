/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number-before-itself
@Language: Java
@Datetime: 17-02-12 01:59
*/

public class Solution {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */ 
    class SegmentTreeNode {
        int start, end, count;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
    
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if (start == end) {
            return new SegmentTreeNode(start, end, 0);
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        int mid = (start + end) / 2;
        node.left = build(start, mid);
        node.right = build(mid + 1, end);
        return node;
    }
    
    public void modify(SegmentTreeNode root, int index) {
        // write your code here
        if (index == root.start && index == root.end) {
            root.count++;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index <= mid) {
            modify(root.left, index);
        } else {
            modify(root.right, index);
        }
        root.count++;
    }
    
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (start > end) {
            return 0;
        }
        
        if (start == root.start && end == root.end) {
            return root.count;
        }
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start > mid) {
            return query(root.right, start, end);
        } else {
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        }
    }
    
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        SegmentTreeNode root = build(0, 10000);
        for (int a : A) {
            modify(root, a);
            result.add(query(root, 0, a - 1));
        }
        return result;
    }
}
