/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-iii
@Language: Java
@Datetime: 16-11-30 22:36
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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public static boolean a_exist = false, b_exist = false;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        exist(root, A, B);
        if (!a_exist || !b_exist) {
            return null;
        } else {
            return lowestCommonAncestor(root, A, B);
        }
    }
    
    private void exist(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return;
        }
        if (root == A) {
            a_exist = true;
        }
        if (root == B) {
            b_exist = true;
        }
        exist(root.left, A, B);
        exist(root.right, A, B);
    }
    
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) {
            return root;
        }
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        // Conquer
        if (left != null && right != null) {
            return root;
        } 
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}