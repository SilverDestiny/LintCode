/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/subtree
@Language: Java
@Datetime: 17-04-02 04:41
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
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    /*
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T2 == null) {
            return true;
        }
        if (T1 == null) {
            return false;
        }
        if (check(T1, T2)) {
            return true;
        }
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    
    private boolean check(TreeNode T1, TreeNode T2) {
        if (T1 == null || T2 == null) {
            return T1 == T2;
        }
        if (T1.val != T2.val) {
            return false;
        }
        return check(T1.left, T2.left) && check(T1.right, T2.right);
    }
    */
    
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        preOrder(T1, str1);
        preOrder(T2, str2);
        return str1.indexOf(str2.toString()) != -1; //need KMP algorithm to optimize indexOf() to O(n)
    }
    
    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }
        sb.append(node.val + " ");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }
}