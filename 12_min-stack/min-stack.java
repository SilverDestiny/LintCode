/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/min-stack
@Language: Java
@Datetime: 16-05-31 20:34
*/

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else if (number <= minStack.peek()) {
            minStack.push(number);
        }
    }

    public int pop() {
        // write your code here
        if (minStack.peek().equals(stack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
