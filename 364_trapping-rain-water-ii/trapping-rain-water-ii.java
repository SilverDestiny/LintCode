/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/trapping-rain-water-ii
@Language: Java
@Datetime: 17-02-04 23:10
*/

public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    class Cell {
        int x, y, height;
        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
    
    public int trapRainWater(int[][] heights) {
        // write your code here
        if (heights == null || heights.length < 3 || heights[0] == null || heights[0].length < 3) {
            return 0;
        }
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(2 * (m + n), new Comparator<Cell>() {
           public int compare (Cell a, Cell b) {
               return a.height - b.height;
           } 
        });
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m - 1; i++) {
            minHeap.offer(new Cell(i, 0, heights[i][0]));
            minHeap.offer(new Cell(i + 1, n - 1, heights[i + 1][n - 1]));
            visited[i][0] = true;
            visited[i + 1][n - 1] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            minHeap.offer(new Cell(0, i + 1, heights[0][i + 1]));
            minHeap.offer(new Cell(m - 1, i, heights[m - 1][i]));
            visited[0][i + 1] = true;
            visited[m - 1][i] = true;
        }
        
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int result = 0;
        while (!minHeap.isEmpty()) {
            Cell temp = minHeap.poll();
            for (int i = 0; i < 4; i++) {
                int x = temp.x + dir[i][0];
                int y = temp.y + dir[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    result += Math.max(0, temp.height - heights[x][y]);
                    //Math.max(heights[x][y], temp.height), not heights[x][y]
                    minHeap.offer(new Cell(x, y, Math.max(heights[x][y], temp.height)));
                    visited[x][y] = true;
                }
            }
        }
        return result;
    }
};