/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 17-01-23 03:49
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
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        findPath(root, result, path, root.val, target);
        return result;
    }
    
    private void findPath(TreeNode root, List<List<Integer>> result, ArrayList<Integer> path, int sum, int target) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        if (root.left != null) {
            findPath(root.left, result, path, sum + root.left.val, target);
        }
        if (root.right != null) {
            findPath(root.right, result, path, sum + root.right.val, target);
        }
        path.remove(path.size() - 1);
    }
}