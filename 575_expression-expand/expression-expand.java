/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/expression-expand
@Language: Java
@Datetime: 16-12-16 17:46
*/

public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        Stack<StringBuilder> stack = new Stack<StringBuilder>();
        
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                StringBuilder sb = new StringBuilder();
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    sb.append(s.charAt(index));
                    index++;
                }
                stack.push(sb);
            } else if (s.charAt(index) == '[') {
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = stack.pop();
                while (!(Character.isDigit(stack.peek().charAt(0)))) {
                    temp = stack.pop().append(temp);
                }
                StringBuilder strNum = stack.pop();
                int num = 0;
                for (int i = 0; i < strNum.length(); i++) {
                    num = num * 10 + strNum.charAt(i) - '0';
                }
                if (num != 0) {
                    StringBuilder temp2 = new StringBuilder();
                    for (int i = 0; i < num; i++) {
                        temp2.append(temp);
                    }
                    stack.push(temp2);
                }
                index++;
            } else {
                StringBuilder sb = new StringBuilder();
                while (index < s.length() && Character.isLetter(s.charAt(index))) {
                    sb.append(s.charAt(index));
                    index++;
                }
                stack.push(sb);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result = stack.pop().append(result);
        }
        return result.toString();
    }
}