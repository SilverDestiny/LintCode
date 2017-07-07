/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/house-robber-iii
@Language: Java
@Datetime: 17-02-24 22:34
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    public int houseRobber3(TreeNode root) {
        // write your code here
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];
        
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];
    
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        
        return res;
    }
}