/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/bomb-enemy
@Language: Java
@Datetime: 17-02-19 00:15
*/

public class Solution {
    /**
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // Write your code here
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[] cols = new int[n];
        int rows = 0;
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rows = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            rows++;
                        }
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    cols[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            cols[j]++;
                        }
                    }
                }
                if (grid[i][j] == '0') {
                    max = Math.max(max, rows + cols[j]);
                }
            }
        }
        return max;
    }
}