/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/swap-nodes-in-pairs
@Language: Java
@Datetime: 16-10-20 15:38
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
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode head2 = new ListNode(0);
        head2 = head.next;
        
        while (head.next != null && head2.next != null) {
            head.next = head2.next;
            head2.next = head.next.next;
            head.next.next = head2;
            head = head2;
            head2 = head2.next;
        }
        return dummy.next;
    }
}