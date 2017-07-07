/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/climbing-stairs-ii
@Language: Java
@Datetime: 16-11-30 21:56
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        // Write your code here
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0) {
                f[i] += f[i - 1];
            }
            if (i - 2 >= 0) {
                f[i] += f[i - 2];
            }
            if (i - 3 >= 0) {
                f[i] += f[i - 3];
            }
        }
        return f[n];
    }
}