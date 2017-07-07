/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/rotate-image
@Language: Java
@Datetime: 17-01-02 23:44
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int first = i, last = n - i - 1;
            for (int j = first; j < last; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][first];
                matrix[n - j - 1][first] = matrix[last][n - j - 1];
                matrix[last][n - j - 1] = matrix[j][last];
                matrix[j][last] = temp;
            }
        }
    }
}