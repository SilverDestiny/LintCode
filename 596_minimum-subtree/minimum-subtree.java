/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/minimum-subtree
@Language: Java
@Datetime: 17-01-22 02:20
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
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    int min = Integer.MAX_VALUE;
    TreeNode node = null;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        find(root);
        return node;
    }
    
    private int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = find(root.left);
        int right = find(root.right);
        int sum = root.val + left + right;
        if (sum < min) {
            min = sum;
            node = root;
        }
        return sum;
    }
}