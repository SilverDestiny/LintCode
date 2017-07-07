/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/complete-binary-tree
@Language: Java
@Datetime: 16-09-23 15:26
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
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // Write your code here
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (q.peek() != null) {
            TreeNode head = q.poll();
            q.offer(head.left);
            q.offer(head.right);
        }
        while (!q.isEmpty()) {
            if (q.poll() != null) {
                return false;
            }
        }
        return true;
    }
}