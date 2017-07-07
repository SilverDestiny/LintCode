/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-iii
@Language: Java
@Datetime: 17-01-24 04:18
*/

/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<TreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    int result = 0;
    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        dfs(root);
        return result;
    }
    
    private void dfs(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        for (MultiTreeNode child : root.children) {
            dfs(child);
        }
        int inc = 0;
        int dec = 0;
        for (MultiTreeNode child : root.children) {
            inc = Math.max(inc, (child != null && child.val + 1 == root.val) ? calInc(child) : 0);
            dec = Math.max(dec, (child != null && child.val - 1 == root.val) ? calDec(child) : 0);
        }
        result = Math.max(result, inc + dec + 1);
    }
    
    private int calInc(MultiTreeNode root) {
        if (root == null) {
            return 0;
        }
        int inc = 0;
        for (MultiTreeNode child : root.children) {
            inc = Math.max(inc, (child != null && child.val + 1 == root.val) ? calInc(child) : 0);
        }
        return inc + 1;
    }
    
    private int calDec(MultiTreeNode root) {
        if (root == null) {
            return 0;
        }
        int dec = 0;
        for (MultiTreeNode child : root.children) {
            dec = Math.max(dec, (child != null && child.val - 1 == root.val) ? calDec(child) : 0);
        }
        return dec + 1;
    }
}