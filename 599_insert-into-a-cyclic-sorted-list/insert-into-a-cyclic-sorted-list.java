/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/insert-into-a-cyclic-sorted-list
@Language: Java
@Datetime: 17-01-29 21:28
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    /*
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        int max = node.val;
        ListNode prev = node;
        while (prev.next != node) {
            prev = prev.next;
            max = Math.max(max, prev.val);
        }
        while (true) {
            if (x >= prev.val && x <= node.val || (x >= prev.val && prev.val == max && prev.val >= node.val)) {
                prev.next = new ListNode(x);
                prev.next.next = node;
                return prev.next;
            } else {
                node = node.next;
                prev = prev.next;
            }
        }
    }*/
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        ListNode p = node;
        ListNode prev = null;
        do {
            prev = p;
            p = p.next;
            if (x <= p.val && x >= prev.val) { 
                break;
            }
            if ((prev.val > p.val) && (x < p.val || x > prev.val)) {
                break;
            }
        } while (p != node);

        ListNode newNode = new ListNode(x);
        newNode.next = p;
        prev.next = newNode;
        return newNode;
    }
}