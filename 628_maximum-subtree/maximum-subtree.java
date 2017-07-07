/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/maximum-subtree
@Language: Java
@Datetime: 17-02-22 23:42
*/

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the maximum weight node
     */
    TreeNode res;
    int maxSum;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        res = null;
        maxSum = Integer.MIN_VALUE;
        sum(root);
        return res;
    }
    
    private int sum(TreeNode node) {
        int left = 0;
        int right = 0;
        if (node.left != null) {
            left = sum(node.left);
        }
        if (node.right != null) {
            right = sum(node.right);
        }
        int sum = left + right + node.val;
        if (sum > maxSum) {
            maxSum = sum;
            res = node;
        }
        return sum;
    }
}