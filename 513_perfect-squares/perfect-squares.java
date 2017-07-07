/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/perfect-squares
@Language: Java
@Datetime: 17-01-30 22:50
*/

public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    
    public int numSquares(int n) {
        // Write your code here
        /*
        int len = (int) Math.sqrt(n);
        int[] squares = new int[len];
        for (int i = 0; i < len; i++) {
            squares[i] = (i + 1) * (i + 1);
        }
        */
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = i;
            for (int j = 1; i >= j * j; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        return f[n];
    }
    
    /*
    public int numSquares(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i)
            dp[i * i] = 1;

        for (int i = 0; i <= n; ++i)
            for (int j = 0; i + j * j <= n; ++j)
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);

        return dp[n];
    }
    */
}