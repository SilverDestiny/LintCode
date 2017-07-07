/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum-ii
@Language: Java
@Datetime: 17-01-14 20:36
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
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return Math.max(Math.max(left, right), 0) + root.val;
    }
}