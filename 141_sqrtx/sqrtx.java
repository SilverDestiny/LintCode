/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 17-03-07 18:09
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        long start = 0, end = x;
        while (start < end) {
            long mid = (start + end + 1) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        
        return (int) start;
    }
}