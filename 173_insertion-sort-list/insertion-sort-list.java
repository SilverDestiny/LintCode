/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/insertion-sort-list
@Language: Java
@Datetime: 16-10-21 14:43
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0);
        
        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = node.next;
            node.next = head;
            head = head.next;
            node.next.next = temp;
        }
        return dummy.next;
    }
}