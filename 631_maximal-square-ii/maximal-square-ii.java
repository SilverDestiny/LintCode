/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/maximal-square-ii
@Language: Java
@Datetime: 17-03-02 21:20
*/

public class Solution {
    /**
     * @param matrix a matrix of 0 and 1
     * @return an integer
     */
    public int maxSquare2(int[][] matrix) {
        // write your code here
        if (matrix.length == 0) {
            return 0;
        }
        if (matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];
        int[][] f = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
        }
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (matrix[i - 1][j - 1] == 0) {
                    up[i][j] = up[i - 1][j] + 1;
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    f[i][j] = 1;
                    f[i][j] += Math.min(f[i - 1][j - 1], Math.min(left[i][j - 1], up[i - 1][j]));
                    max = Math.max(max, f[i][j]);
                }
            }
        }
        return max * max;
    }
}