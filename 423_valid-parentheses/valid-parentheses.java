/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/valid-parentheses
@Language: Java
@Datetime: 16-05-10 16:42
*/

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() &&
                    (stack.peek() == '(' && c == ')' ||
                    stack.peek() == '[' && c == ']' ||
                    stack.peek() == '{' && c == '}')) {
                    stack.pop();    
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}