/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/unique-paths
@Language: Java
@Datetime: 16-12-29 16:54
*/

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        /*int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        
        return f[m - 1][n - 1];*/
        
        double value = 1;
        for (int i = 1; i <= n - 1; i++) {
            value *= (m + i - 1) / (double) i;
        }
        return (int) Math.round(value); 
    }
}
