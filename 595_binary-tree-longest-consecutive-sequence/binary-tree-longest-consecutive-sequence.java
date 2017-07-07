/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence
@Language: Java
@Datetime: 17-03-30 16:52
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
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        // Write your code here
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int ans = 1;
        if (left != 0 && node.val == node.left.val - 1) {
            ans = left + 1;
        }
        if (right != 0 && node.val == node.right.val - 1) {
            ans = Math.max(ans, right + 1);
        }
        max = Math.max(max, ans);
        return ans;
    }
}