/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/max-tree
@Language: Java
@Datetime: 17-01-09 21:06
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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(new TreeNode(A[0]));
        for (int i = 1; i < A.length; i++) {
            if (A[i] < stack.peek().val) {
                stack.push(new TreeNode(A[i]));
            } else {
                TreeNode temp = stack.pop();
                while (!stack.isEmpty() && stack.peek().val < A[i]) {
                    TreeNode node = stack.pop();
                    node.right = temp;
                    temp = node;
                }
                TreeNode curt = new TreeNode(A[i]);
                curt.left = temp;
                stack.push(curt);
            }
        }
        TreeNode temp = stack.pop();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            node.right = temp;
            temp = node;
        }
        return temp;
    }  
}