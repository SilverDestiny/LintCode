/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/fast-power
@Language: Java
@Datetime: 16-12-29 23:04
*/

class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }
        long product = fastPower(a, b, n / 2);
        product = product * product % b;
        if (n % 2 != 0) {
            product = product * a % b;
        }
        return (int) product;
    }
};