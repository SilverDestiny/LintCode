/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/ugly-number
@Language: Java
@Datetime: 16-11-10 17:15
*/

public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        // Write your code here
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num >= 2 && num % 2 == 0) {
            num = num / 2;
        }
        while (num >= 3 && num % 3 == 0) {
            num = num / 3;
        }
        while (num >= 5 && num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }
}