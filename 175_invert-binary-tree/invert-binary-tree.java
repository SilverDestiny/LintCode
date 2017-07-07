/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/invert-binary-tree
@Language: Java
@Datetime: 17-02-25 21:47
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}