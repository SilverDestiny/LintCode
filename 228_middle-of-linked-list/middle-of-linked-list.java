/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/middle-of-linked-list
@Language: Java
@Datetime: 16-10-19 21:57
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
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) { 
        // Write your code here
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}