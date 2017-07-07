/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/reverse-nodes-in-k-group
@Language: Java
@Datetime: 16-12-12 23:38
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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode preHead = dummy, tail = head, preTail = dummy;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (tail != null) {
                    tail = tail.next;
                    preTail = preTail.next;
                } else {
                    return dummy.next;
                }
            }
            preTail.next = null;
            //ListNode temp = head;
            preTail = head;
            preHead.next = reverse(head);
            //preTail = temp;
            preTail.next = tail;
            head = tail;
            preHead = preTail;
        }
        //return dummy.next;
    }
    
    private ListNode reverse(ListNode head) {
        // write your code here
        ListNode prev = null;
        while (head != null) {
            ListNode temp;
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}