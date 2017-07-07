/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/segment-tree-build-ii
@Language: Java
@Datetime: 17-02-09 02:46
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if (A == null) {
            return null;
        }
        return build(A, 0, A.length - 1);
    }
    
    public SegmentTreeNode build(int[] A, int start, int end) {
        // write your code here
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
        node.left = build(A, start, (start + end) / 2);
        node.right = build(A, (start + end) / 2 + 1, end);
        node.max = Math.max(node.left.max, node.right.max);
        return node;
    }
}