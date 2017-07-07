/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/implement-stack
@Language: Java
@Datetime: 16-05-10 19:27
*/

class Stack {
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        array.add(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if (array.size() > 0) {
            array.remove(array.size() - 1);
        }
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        if (array.size() > 0) {
            return array.get(array.size() - 1);
        }
        return -1;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return array.size() == 0;
    }
    
    ArrayList<Integer> array = new ArrayList<Integer>();
}