/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning
@Language: Java
@Datetime: 16-11-17 22:19
*/

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        ArrayList<String> path = new ArrayList<String>();
        helper(s, path, 0, result);
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    private void helper(String s, ArrayList<String> path, int pos, List<List<String>> result) {
        if (pos == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }
        
        for (int i = pos; i < s.length(); i++) {
            String temp = s.substring(pos, i + 1);
            if (!isPalindrome(temp)) {
                continue;
            }
            path.add(temp);
            helper(s, path, i + 1, result);
            path.remove(path.size() - 1);
        }
    }
}