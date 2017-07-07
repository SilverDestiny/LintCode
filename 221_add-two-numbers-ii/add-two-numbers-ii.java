/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/add-two-numbers-ii
@Language: Java
@Datetime: 16-10-25 22:25
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        return reverse(addLists(reverse(l1), reverse(l2)));
    }
    
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code 
        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        
        while (l1 != null) {
            int sum = l1.val + carry;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            point = point.next;
        }
        
        while (l2 != null) {
            int sum = l2.val + carry;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            point = point.next;
        }
        
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        
        return head.next;
    }
}