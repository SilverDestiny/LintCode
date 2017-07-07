/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-search-tree-iterator
@Language: Java
@Datetime: 16-09-23 16:50
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode curt = null;
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        // write your code here
        curt = root;
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode node = stack.pop();
        if (node.right != null) {
            curt = node.right;
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
        }
        return node;
    }
}