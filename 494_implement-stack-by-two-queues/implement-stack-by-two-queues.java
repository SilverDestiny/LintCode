/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/implement-stack-by-two-queues
@Language: Java
@Datetime: 16-05-11 15:21
*/

class Stack {
    private Queue<Integer> q = new LinkedList<Integer>();
    private int count = 0;
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        q.add(x);
        count++;
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if (count == 0) {
            return;
        }
        for (int i = 0; i < count - 1; i++) {
            q.add(q.remove());
        }
        q.remove();
        count--;
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        if (count == 0) {
            return -1;
        }
        for (int i = 0; i < count - 1; i++) {
            q.add(q.remove());
        }
        int temp = q.peek();
        q.add(q.remove());
        return temp;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q.isEmpty();
    }    
}