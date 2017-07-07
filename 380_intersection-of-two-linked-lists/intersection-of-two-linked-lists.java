/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/intersection-of-two-linked-lists
@Language: Java
@Datetime: 17-01-04 04:23
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if (headA == null || headB == null) {
            return null;
        }
    
        ListNode a = headA;
        ListNode b = headB;
        
        
        return a;
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
        	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;    
        }
    }*/
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) {
    		return null;
    	}
    	
    	Result a = getLength(headA);
    	Result b = getLength(headB);
    	if (a.lastNode != b.lastNode) {
    		return null;
    	}
    	if (a.length > b.length) {
    		return findIntersection(headA, headB, a.length - b.length);
    	} else {
    		return findIntersection(headB, headA, b.length - a.length);
    	}
    }
    
    class Result {
        int length;
        ListNode lastNode;
        Result(int length, ListNode lastNode) {
            this.length = length;
            this.lastNode = lastNode;
        }
    }
    
    private Result getLength(ListNode head) {
    	int length = 1;
    	while (head.next != null) {
    		head = head.next;
    		length++;
    	}
    	return new Result(length, head);
    }
    
    private ListNode findIntersection(ListNode n1, ListNode n2, int cutoff) {
    	while (cutoff != 0) {
    		n1 = n1.next;
    		cutoff--;
    	}
    	while (n1 != n2) {
    		n1 = n1.next;
    		n2 = n2.next;
    	}
    	return n1;
    }
}