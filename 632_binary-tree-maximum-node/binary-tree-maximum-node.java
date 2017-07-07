/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-node
@Language: Java
@Datetime: 17-03-02 04:46
*/

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        TreeNode max = root;
        if (root.left != null) {
            TreeNode left = maxNode(root.left);
            if (left.val > root.val) {
                max = left;
            }
        }
        if (root.right != null) {
            TreeNode right = maxNode(root.right);
            if (right.val > max.val) {
                max = right;
            }
        }
        return max;
    }
}