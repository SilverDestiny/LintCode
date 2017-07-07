/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/add-digits
@Language: Java
@Datetime: 17-02-24 20:25
*/

public class Solution {
    /**
     * @param num a non-negative integer
     * @return one digit
     */
    public int addDigits(int num) {
        // Write your code here
        return (num - 1) % 9 + 1;
    }
}