/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/generate-parentheses
@Language: Java
@Datetime: 17-02-26 00:43
*/

public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        StringBuilder path = new StringBuilder();
        helper(path, 0, 0, n, result);
        return result;
    }
    
    private void helper(StringBuilder path, int left, int right, int n, ArrayList<String> result) {
        if (left == n && right == n) {
            result.add(path.toString());
            return;
        }
        
        if (left < n) {
            path.append('(');
            helper(path, left + 1, right, n, result);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < n && right < left) {
            path.append(')');
            helper(path, left, right + 1, n, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}