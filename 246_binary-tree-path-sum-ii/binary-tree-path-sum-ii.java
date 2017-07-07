/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum-ii
@Language: Java
@Datetime: 17-01-23 21:34
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
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(root, target, result);
        return result;
    }
    
    private void dfs(TreeNode root, int target, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        findPath(root, result, path, root.val, target);
        dfs(root.left, target, result);
        dfs(root.right, target, result);
    }
    
    private void findPath(TreeNode root, List<List<Integer>> result, ArrayList<Integer> path, int sum, int target) {
        if (sum == target) {
            result.add(new ArrayList<Integer>(path));
        }
        if (root.left != null) {
            path.add(root.left.val);
            findPath(root.left, result, path, sum + root.left.val, target);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            findPath(root.right, result, path, sum + root.right.val, target);
            path.remove(path.size() - 1);
        }
    }
}