/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/submatrix-sum
@Language: Java
@Datetime: 17-02-16 01:30
*/

public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[2][2];
        if (m == 0 || n == 0) {
            return result;
        }
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                map.clear();
                for (int k = 0; k <= n; k++) {
                    int diff = sum[j][k] - sum[i][k];
                    if (map.containsKey(diff)) {
                        result[0][0] = i;
                        result[0][1] = map.get(diff);
                        result[1][0] = j - 1;
                        result[1][1] = k - 1;
                        return result;
                    } else {
                        map.put(diff, k);
                    }
                }
            }
        }
        return result;
    }
}