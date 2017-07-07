/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-paths
@Language: Java
@Datetime: 17-01-22 18:58
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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        dfs(root, "", result);
        return result;
    }
    
    private void dfs(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        if (root.left != null) {
            dfs(root.left, path + root.val + "->", result);
        }
        if (root.right != null) {
            dfs(root.right, path + root.val + "->", result);
        }
    }
}