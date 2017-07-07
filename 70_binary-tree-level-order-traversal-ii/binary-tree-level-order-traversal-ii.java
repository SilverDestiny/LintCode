/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal-ii
@Language: Java
@Datetime: 16-10-04 22:01
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
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = q.poll();
                list.add(head.val);
                if (head.left != null) {
                    q.offer(head.left);
                }
                if (head.right != null) {
                    q.offer(head.right);
                }
            }
            stack.push(list);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}