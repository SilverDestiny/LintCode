/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/rotate-list
@Language: Java
@Datetime: 16-10-28 14:37
*/

/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        k = k % length;
        
        head = dummy;
        for (int i = 0; i < length - k; i++) {
            head = head.next;
        }
        
        tail.next = dummy.next;
        dummy.next = head.next;
        head.next = null;
        
        return dummy.next;
    }
}