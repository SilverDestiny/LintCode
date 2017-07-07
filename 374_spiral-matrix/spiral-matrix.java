/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/spiral-matrix
@Language: Java
@Datetime: 17-01-11 15:39
*/

public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int beginRow = 0;
        int endRow = matrix.length - 1;
        int beginCol = 0;
        int endCol = matrix[0].length - 1;
        while (beginRow <= endRow && beginCol <= endCol) {
            for (int i = beginCol; i <= endCol; i++) {
                result.add(matrix[beginRow][i]);
            }
            beginRow++;
            for (int i = beginRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            endCol--;
            if (beginRow > endRow || beginCol > endCol) {
                break;
            }
            for (int i = endCol; i >= beginCol; i--) {
                result.add(matrix[endRow][i]);
            }
            endRow--;
            for (int i = endRow; i >= beginRow; i--) {
                result.add(matrix[i][beginCol]);
            }
            beginCol++;
        }
        return result;
    }
}