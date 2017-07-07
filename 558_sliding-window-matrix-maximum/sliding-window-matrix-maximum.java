/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/sliding-window-matrix-maximum
@Language: Java
@Datetime: 17-02-13 02:40
*/

public class Solution {
    /**
     * @param matrix an integer array of n * m matrix
     * @param k an integer
     * @return the maximum number
     */
    public int maxSlidingMatrix(int[][] matrix, int k) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        if (k > m || k > n) {
            return 0;
        }
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {
                max = Math.max(max, sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k]);
            }
        }
        return max;
    }
}