/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/search-range-in-binary-search-tree
@Language: Java
@Datetime: 17-03-07 16:47
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
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    ArrayList<Integer> result;
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        result = new ArrayList<Integer>();
        helper(root, k1, k2);
        return result;
    }
    
    private void helper(TreeNode node, int k1, int k2) {
        if (node == null) {
            return;
        }
        if (node.val > k1) {
            helper(node.left, k1, k2);
        }
        if (node.val >= k1 && node.val <= k2) {
            result.add(node.val);
        }
        if (node.val < k2) {
            helper(node.right, k1, k2);
        }
    }
}