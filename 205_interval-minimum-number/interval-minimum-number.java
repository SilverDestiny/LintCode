/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/interval-minimum-number
@Language: Java
@Datetime: 17-02-12 02:17
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    class SegmentTreeNode {
        int start, end, min;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
            this.left = this.right = null;
        }
    }
    
    public SegmentTreeNode build(int[] A, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        int mid = (start + end) / 2;
        node.left = build(A, start, mid);
        node.right = build(A, mid + 1, end);
        node.min = Math.min(node.left.min, node.right.min);
        return node;
    }
    
    public int query(SegmentTreeNode root, int start, int end) {
        if (start == root.start && end == root.end) {
            return root.min;
        }
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start > mid) {
            return query(root.right, start, end);
        } else {
            return Math.min(query(root.left, start, mid), query(root.right, mid + 1, end));
        }
    }
     
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        SegmentTreeNode root = build(A, 0, A.length - 1);
        for (Interval q : queries) {
            result.add(query(root, q.start, q.end));
        }
        return result;
    }
}