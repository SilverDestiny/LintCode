/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Java
@Datetime: 16-10-04 21:38
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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        boolean dir = false;
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = q.poll();
                list.add(head.val);
                s.push(head);
            }
            result.add(list);
            while (!s.isEmpty()) {
                TreeNode node = s.pop();
                if (dir == true) {
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                } else {
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                }
            }
            dir = !dir;
        }
        return result;
    }
}