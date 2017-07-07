/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/powx-n
@Language: Java
@Datetime: 16-12-30 15:23
*/

public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        // Write your code here
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double product = myPow(x, n / 2);
        product *= product;
        if (n % 2 != 0) {
            product *= x;
        }
        return product;
    }
}