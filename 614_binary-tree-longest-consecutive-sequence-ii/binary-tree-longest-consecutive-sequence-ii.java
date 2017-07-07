/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-ii
@Language: Java
@Datetime: 17-01-24 02:31
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    int result = 0;
    public int longestConsecutive2(TreeNode root) {
        // Write your code here

        dfs(root);
        
        return result;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        int left = (root.left != null && root.left.val + 1 == root.val) ? calInc(root.left) : 0;
        int right = (root.right != null && root.right.val - 1 == root.val) ? calDec(root.right) : 0;
        result = Math.max(result, left + right + 1);
        left = (root.left != null && root.left.val - 1 == root.val) ? calDec(root.left) : 0;
        right = (root.right != null && root.right.val + 1 == root.val) ? calInc(root.right) : 0;
        result = Math.max(result, left + right + 1);
    }
    
    private int calInc(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = (root.left != null && root.left.val + 1 == root.val) ? calInc(root.left) : 0;
        int right = (root.right != null && root.right.val + 1 == root.val) ? calInc(root.right) : 0;
        return Math.max(left, right) + 1;
    }
    
    private int calDec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = (root.left != null && root.left.val - 1 == root.val) ? calDec(root.left) : 0;
        int right = (root.right != null && root.right.val - 1 == root.val) ? calDec(root.right) : 0;
        return Math.max(left, right) + 1;
    }
}