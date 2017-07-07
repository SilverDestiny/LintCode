/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/house-robber
@Language: Java
@Datetime: 17-02-12 18:33
*/

public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        long[] f = new long[2];
        f[0] = 0;
        f[1] = A[0];
        
        for (int i = 2; i <= n; i++) {
            f[i % 2] = Math.max(f[(i - 1) % 2], f[(i - 2) % 2] + A[i - 1]);
        }
        return f[n % 2];
    }
}