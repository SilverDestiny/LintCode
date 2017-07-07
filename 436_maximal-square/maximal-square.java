/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/maximal-square
@Language: Java
@Datetime: 17-02-09 22:09
*/

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[2][n + 1];
        int edge = 0;
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    f[i % 2][j] = Math.min(f[(i - 1) % 2][j - 1], Math.min(f[(i - 1) % 2][j], f[i % 2][j - 1])) + 1;
                    edge = Math.max(edge, f[i % 2][j]);
                } else {
                    f[i % 2][j] = 0;
                }
            }
        }
        return edge * edge;
    }
}