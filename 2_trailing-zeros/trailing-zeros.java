/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/trailing-zeros
@Language: Java
@Datetime: 17-03-13 01:13
*/

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        long sum = 0;
        for (long i = 5; i <= n; i *= 5) {
            sum += n / i; 
        }
        return sum;
    }
};
