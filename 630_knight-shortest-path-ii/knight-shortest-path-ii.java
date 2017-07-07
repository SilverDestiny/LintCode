/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/knight-shortest-path-ii
@Language: Java
@Datetime: 17-03-02 01:28
*/

public class Solution {
    /**
     * @param grid a chessboard included 0 and 1
     * @return the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // Write your code here
        if (grid.length == 0) {
            return -1;
        }
        if (grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        f[0][0] = 0;
        
        int[] dx = {-1, 1, -2, 2};
        int[] dy = {-2, -2, -1, -1};
        
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j]) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n && f[x][y] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i][j], f[x][y] + 1);
                    }
                }
            }
        }
        if (f[m - 1][n - 1] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return f[m - 1][n - 1];
        }
    }
}