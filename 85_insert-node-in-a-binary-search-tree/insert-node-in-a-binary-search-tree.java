/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/insert-node-in-a-binary-search-tree
@Language: Java
@Datetime: 16-09-23 21:00
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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        TreeNode curt = root;
        TreeNode prev = null;
        int dir = 0;
        while (curt != null) {
            prev = curt;
            if (node.val < curt.val) {
                curt = curt.left;
                dir = 0;
            } else {
                curt = curt.right;
                dir = 1;
            }
        }
        if (dir == 0) {
            prev.left = node;
            return root;
        } else {
            prev.right = node;
            return root;
        }
    }
}