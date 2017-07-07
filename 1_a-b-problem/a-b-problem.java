/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/a-b-problem
@Language: Java
@Datetime: 17-03-19 20:51
*/

class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        int res  = a ^ b;
        int carry = a & b;
        while (carry != 0) {
            carry = carry << 1;
            int temp = res;
            res = res ^ carry;
            carry = temp & carry;
        }
        return res;
    }
};