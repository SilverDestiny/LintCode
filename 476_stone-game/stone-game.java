/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/stone-game
@Language: Java
@Datetime: 17-02-14 16:37
*/

public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 0;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                f[j][j + i] = Integer.MAX_VALUE;
                for (int k = j; k < j + i; k++) {
                    f[j][j + i] = Math.min(f[j][j + i], f[j][k] + f[k + 1][j + i] + sum[j + i + 1] - sum[j]);
                }
            }
        }
        return f[0][n - 1];
    }
}