/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/stone-game-ii
@Language: Java
@Datetime: 17-02-14 21:43
*/

public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame2(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] B = new int[n * 2];
        for (int i = 0; i < n; i++) {
            B[i] = A[i];
            B[i + n] = A[i];
        }
        
        int[] sum = new int[n * 2 + 1];
        sum[0] = 0;
        for (int i = 1; i <= n * 2; i++) {
            sum[i] = sum[i - 1] + A[(i - 1) % n];
        }
        
        int[][] f = new int[n * 2][n * 2];
        for (int i = 0; i < n * 2; i++) {
            f[i][i] = 0;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n * 2; j++) {
                f[j][j + i] = Integer.MAX_VALUE;
                for (int k = j; k < j + i; k++) {
                    f[j][j + i] = Math.min(f[j][j + i], f[j][k] + f[k + 1][j + i] + sum[j + i + 1] - sum[j]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, f[i][i + n - 1]);
        }
        return min;
    }
}