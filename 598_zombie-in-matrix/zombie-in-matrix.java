/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/zombie-in-matrix
@Language: Java
@Datetime: 17-01-24 17:40
*/

public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        // Write your code here
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int days = 0;
        boolean done = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    flag[i][j] = true;
                } else {
                    done = false;
                }
            }
        }
        while (!done) {
            days++;
            boolean changed = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 && flag[i][j] == true) {
                        if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                            grid[i - 1][j] = 1;
                            changed = true;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                            grid[i][j - 1] = 1;
                            changed = true;
                        }
                        if (i + 1 < grid.length && grid[i + 1][j] == 0) {
                            grid[i + 1][j] = 1;
                            changed = true;
                        }
                        if (j + 1 < grid[0].length && grid[i][j + 1] == 0) {
                            grid[i][j + 1] = 1;
                            changed = true;
                        }
                    }
                }
            }
            if (!changed) {
                return -1;
            }
            done = true;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 || grid[i][j] == 2) {
                        flag[i][j] = true;
                    } else {
                        done = false;
                    }
                }
            }
        }
        return days;
    }
}