/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/subtree-with-maximum-average
@Language: Java
@Datetime: 17-01-22 02:36
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
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    class Result {
        int sum;
        int count;
        Result(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    
    double maxAve = Integer.MIN_VALUE;
    TreeNode node = null;
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        find(root);
        return node;
    }
    
    private Result find(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);
        }
        Result left = find(root.left);
        Result right = find(root.right);
        double ave = (root.val + left.sum + right.sum) / (double) (left.count + right.count + 1);
        if (ave > maxAve) {
            maxAve = ave;
            node = root;
        }
        return new Result(root.val + left.sum + right.sum, left.count + right.count + 1);
    }
}