/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/inorder-successor-in-binary-search-tree
@Language: Java
@Datetime: 16-09-19 15:57
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode successor = null;
        while (root != null && root != p) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return successor;
        }
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}