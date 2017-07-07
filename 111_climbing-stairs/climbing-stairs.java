/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Java
@Datetime: 17-02-27 01:25
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n < 2) {
            return 1;
        }
        int[] f = new int[2];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            f[i % 2] = f[(i - 2) % 2] + f[(i - 1) % 2];
        }
        return f[n % 2];
    }
}