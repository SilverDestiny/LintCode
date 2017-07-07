/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/unique-characters
@Language: Java
@Datetime: 17-01-02 00:23
*/

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if (str.length() > 128) {
            return false;
        }
        boolean[] chars = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            if (chars[str.charAt(i)]) {
                return false;
            }
            chars[str.charAt(i)] = true;
        }
        return true;
    }
}