/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/spiral-matrix-ii
@Language: Java
@Datetime: 17-01-12 16:37
*/

public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here
        int[][] result = new int[n][n];
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int value = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result[rowStart][i] = value;
                value++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                result[i][colEnd] = value;
                value++;
            }
            if (rowStart > rowEnd || colStart > colEnd) {
                break;
            }
            colEnd--;
            for (int i = colEnd; i >= colStart; i--) {
                result[rowEnd][i] = value;
                value++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                result[i][colStart] = value;
                value++;
            }
            colStart++;
        }
        return result;
    }
}