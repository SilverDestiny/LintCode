/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/n-queens-ii
@Language: Java
@Datetime: 16-11-30 17:13
*/

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public static int sum;
    public int totalNQueens(int n) {
        //write your code here
        sum = 0;
        int[] placedCol = new int[n];
        placeQueen(placedCol, 0);
        return sum;
    }
    
    private void placeQueen(int[] placedCol, int row) {
        if (row == placedCol.length) {
            sum++;
            return;
        }
        for (int i = 0; i < placedCol.length; i++) {
            if (isValid(placedCol, row, i)) {
                placedCol[row] = i;
                placeQueen(placedCol, row + 1);
            }
        }
    }
    
    private boolean isValid(int[] placedCol, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (placedCol[i] == col) {
                return false;
            }
            if ((row - i) == Math.abs(col - placedCol[i])) {
                return false;
            }
        }
        return true;
    }
};

