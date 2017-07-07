/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/drop-eggs-ii
@Language: Java
@Datetime: 16-12-13 21:01
*/

public class Solution {
    /**
     * @param m the number of eggs
     * @param n the umber of floors
     * @return the number of drops in the worst case
     */
    public int dropEggs2(int m, int n) {
        // Write your code here
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            f[i][0] = 0;
            f[i][1] = 1;
        }
        for (int j = 0; j <= n; j++) {
            f[1][j] = j;
        }
        
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[i - 1][k - 1], f[i][j - k]) + 1);
                }
            }
        }
        return f[m][n];
    }
}