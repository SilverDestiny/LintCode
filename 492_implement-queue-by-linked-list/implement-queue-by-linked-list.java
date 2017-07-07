/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/implement-queue-by-linked-list
@Language: Java
@Datetime: 16-05-11 16:25
*/

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class Queue {
    ListNode first, last;
    public Queue() {
        // do initialize if necessary
        first = last = null;
    }

    public void enqueue(int item) {
        // Write your code here
        if (first == null) {
            first = new ListNode(item);
            last = first;
        } else {
            last.next = new ListNode(item);
            last = last.next;
        }
    }

    public int dequeue() {
        // Write your code here
        if (first != null) {
            int temp = first.val;
            first = first.next;
            return temp;
        }
        return -1;
    }
}