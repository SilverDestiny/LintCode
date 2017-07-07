/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix-ii
@Language: Java
@Datetime: 16-09-15 19:57
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0|| matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length, columns = matrix[0].length;
        int x = rows - 1, y = 0, count = 0;
        
        while (x >= 0 && y < columns) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                count++;
                x--;
                y++;
            }
        }
        return count;
    }
}
