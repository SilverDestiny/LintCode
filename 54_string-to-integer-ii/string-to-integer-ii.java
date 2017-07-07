/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/string-to-integer-ii
@Language: Java
@Datetime: 16-12-21 17:24
*/

public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        boolean positive = true;
        int i = 0;
        if (str.charAt(i) == '-') {
            positive = false;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        
        double result = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + str.charAt(i) - '0';
            i++;
        }
        
        if (!positive) {
            result = -result;
        }
        
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }
        return (int) result;
    }
}