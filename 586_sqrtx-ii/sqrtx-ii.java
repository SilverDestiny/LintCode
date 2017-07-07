/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/sqrtx-ii
@Language: Java
@Datetime: 17-03-27 17:09
*/

public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        double end = x;
        if (x < 1) {
            end = 1;
        }
        double start = 0;
        while (end - start > 1e-10) {
            double mid = (start + end) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}