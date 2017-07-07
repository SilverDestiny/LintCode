/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/knight-shortest-path
@Language: Java
@Datetime: 17-01-27 04:43
*/

/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(source);
        grid[source.x][source.y] = true;
        int[][] dir = {{-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}};
        
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point temp = queue.poll();
                if (temp.x == destination.x && temp.y == destination.y) {
                    return step;
                }
                for (int j = 0; j < 8; j++) {
                    int x = temp.x + dir[j][0];
                    int y = temp.y + dir[j][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !grid[x][y]) {
                        queue.offer(new Point(x, y));
                        grid[x][y] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}