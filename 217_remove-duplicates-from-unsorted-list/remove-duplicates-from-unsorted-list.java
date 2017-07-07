/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-unsorted-list
@Language: Java
@Datetime: 17-01-03 05:34
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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        HashSet<Integer> set = new HashSet<Integer>();
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            if (set.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                head = head.next;
                set.add(head.val);
            }
        }
        return dummy.next;
    }  
}