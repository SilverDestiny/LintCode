/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/convert-sorted-array-to-binary-search-tree-with-minimal-height
@Language: Java
@Datetime: 17-01-08 01:39
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        return helper(A, 0, A.length - 1);
    }
    
    private TreeNode helper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = helper(A, start, mid - 1);
        root.right = helper(A, mid + 1, end);
        return root;
    }
}
