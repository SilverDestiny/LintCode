/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/n-queens
@Language: Java
@Datetime: 16-11-30 17:32
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    public static ArrayList<ArrayList<String>> result;
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        int[] placedCol = new int[n];
        placeQueen(placedCol, 0);
        return result;
    }
    
    private void placeQueen(int[] placedCol, int row) {
        if (row == placedCol.length) {
            result.add(drawSolution(placedCol));
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
    
    private ArrayList<String> drawSolution(int[] placedCol) {
        ArrayList<String> solution = new ArrayList<String>();
        for (int i = 0; i < placedCol.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < placedCol.length; j++) {
                if (j == placedCol[i]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            solution.add(sb.toString());
        }
        return solution;
    }
}