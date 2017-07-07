/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/backpack-iii
@Language: Java
@Datetime: 17-02-15 16:45
*/

public class Solution {
    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // Write your code here
        int[][] f = new int[2][m + 1];
        
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i % 2][j] = f[(i - 1) % 2][j];
                if (j - A[i - 1] >= 0) {
                    f[i % 2][j] = Math.max(f[i % 2][j], f[i % 2][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return f[A.length % 2][m];
    }
}