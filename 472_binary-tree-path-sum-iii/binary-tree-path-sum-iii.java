/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum-iii
@Language: Java
@Datetime: 17-01-23 21:33
*/

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public int val;
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(root, target, result);
        return result;
    }
    
    private void dfs(ParentTreeNode root, int target, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        findPath(root, result, path, root.val, target, null);
        dfs(root.left, target, result);
        dfs(root.right, target, result);
    }
    
    private void findPath(ParentTreeNode root, List<List<Integer>> result, ArrayList<Integer> path, int sum, int target, ParentTreeNode prev) {
        if (sum == target) {
            result.add(new ArrayList<Integer>(path));
        }
        if (root.left != null && prev != root.left) {
            path.add(root.left.val);
            findPath(root.left, result, path, sum + root.left.val, target, root);
            path.remove(path.size() - 1);
        }
        if (root.right != null && prev != root.right) {
            path.add(root.right.val);
            findPath(root.right, result, path, sum + root.right.val, target, root);
            path.remove(path.size() - 1);
        }
        if (root.parent != null && prev != root.parent) {
            path.add(root.parent.val);
            findPath(root.parent, result, path, sum + root.parent.val, target, root);
            path.remove(path.size() - 1);
        }
    }
}