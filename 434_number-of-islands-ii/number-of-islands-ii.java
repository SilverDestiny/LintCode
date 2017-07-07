/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/number-of-islands-ii
@Language: Java
@Datetime: 17-02-02 02:35
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (operators == null || operators.length == 0) {
            return result;
        }
        boolean[][] grid = new boolean[n][m];
        int[] father = new int[n * m];
        for (int i = 0; i < n * m; i++) {
            father[i] = i;
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int island = 0;
        
        
        for (Point point : operators) {
            island++;
            grid[point.x][point.y] = true;
            int origin = point.x * m + point.y;
            for (int i = 0; i < 4; i++) {
                int x = point.x + dir[i][0];
                int y = point.y + dir[i][1];
                int curt = x * m + y;
                if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] && find(father, curt) != origin) {
                    father[find(father, curt)] = origin;
                    island--;
                }
            }
            result.add(island);
        }
        return result;
    }
    
    private int find(int[] father, int node) {
        if (father[node] == node) {
            return node;
        }
        return father[node] = find(father, father[node]);
    }
}