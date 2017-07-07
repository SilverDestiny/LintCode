/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list
@Language: Java
@Datetime: 17-01-22 19:39
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
    /*
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if (root.left == null) {
            return;
        }
        TreeNode curt = root.left;
        while (curt.right != null) {
            curt = curt.right;
        }
        curt.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}