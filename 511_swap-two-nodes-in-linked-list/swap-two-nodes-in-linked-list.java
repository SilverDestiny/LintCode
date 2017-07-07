/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/swap-two-nodes-in-linked-list
@Language: Java
@Datetime: 16-10-25 21:52
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy, p2 = dummy;
        
        while (p1.next != null && p1.next.val != v1) {
            p1 = p1.next;
        }
        while (p2.next != null && p2.next.val != v2) {
            p2 = p2.next;
        }
        if (p1.next == null || p2.next == null) {
            return head;
        }
        
        ListNode temp1 = p1.next;
        ListNode temp2 = p2.next;
        p1.next = temp2;
        p2.next = temp1;
        ListNode temp = temp1.next;
        temp1.next = temp2.next;
        temp2.next = temp;
        
        return dummy.next;
    }
}