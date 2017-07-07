/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum
@Language: Java
@Datetime: 16-09-16 20:32
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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    int maxValue;
    public int maxPathSum(TreeNode root) {
        // write your code here
        maxValue = Integer.MIN_VALUE;
        helper(root);
        return maxValue;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxValue = Math.max(maxValue, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}