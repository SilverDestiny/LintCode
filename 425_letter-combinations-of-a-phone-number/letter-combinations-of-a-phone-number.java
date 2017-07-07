/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/letter-combinations-of-a-phone-number
@Language: Java
@Datetime: 17-02-25 23:30
*/

public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    
    String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder path = new StringBuilder();
        helper(digits, path, result);
        return result;
    }
    
    private void helper(String digits, StringBuilder path, ArrayList<String> result) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }
        char c = digits.charAt(path.length());
        for (int i = 0; i < letters[c - '2'].length(); i++) {
            path.append(letters[c - '2'].charAt(i));
            helper(digits, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}