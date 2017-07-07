/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/stack-sorting
@Language: Java
@Datetime: 16-12-12 04:21
*/

public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        Stack<Integer> temp = new Stack<Integer>();
        while (!stack.isEmpty()) {
            if (temp.isEmpty() || (stack.peek() <= temp.peek())) {
                temp.push(stack.pop());
            } else {
                int element = stack.pop();
                int count = 0;
                while (!temp.isEmpty() && (element > temp.peek())) {
                    stack.push(temp.pop());
                    count++;
                }
                temp.push(element);
                while (count > 0) {
                    temp.push(stack.pop());
                    count--;
                }
            }
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}