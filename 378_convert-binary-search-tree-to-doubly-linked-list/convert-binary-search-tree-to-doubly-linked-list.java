/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/convert-binary-search-tree-to-doubly-linked-list
@Language: Java
@Datetime: 16-12-20 16:30
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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    class ResultType {
        DoublyListNode first, last;
        ResultType(DoublyListNode first, DoublyListNode last) {
            first = this.first;
            last = this.last;
        }
    }
    
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if (root == null) {
            return null;
        }
        ResultType result = helper(root);
        return result.first;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        DoublyListNode node = new DoublyListNode(root.val);
        ResultType result = new ResultType(null, null);
        
        if (left == null) {
            result.first = node;
        } else {
            result.first = left.first;
            node.prev = left.last;
            left.last.next = node;
        }
        if (right == null) {
            result.last = node;
        } else {
            result.last = right.last;
            node.next = right.first;
            right.first.prev = node;
        }
        return result;
    }
}
