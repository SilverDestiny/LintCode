/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/evaluate-reverse-polish-notation
@Language: Java
@Datetime: 17-02-14 04:20
*/

public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int a = 0, b = 0;
        for (String token : tokens) {
            if (token.equals("+")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}