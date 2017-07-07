/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/remove-node-in-binary-search-tree
@Language: Java
@Datetime: 16-10-06 15:49
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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }
        deleteNode(parent, node);
        return dummy.left;
    }
    
    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        while (node != null && node.val != value) {
            if (node.val > value) {
                parent = node;
                node = node.left;
            } else {
                parent = node;
                node = node.right;
            }
        }
        return parent;
    }
    
    private void deleteNode(TreeNode parent, TreeNode node) {
        if (node.left == null) {
            if (parent.left == node) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        } else if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            TreeNode father = node;
            TreeNode temp = node.right;
            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }
            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            temp.left = node.left;
            temp.right = node.right;
        }
    }
}