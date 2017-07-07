```
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/build-post-office
@Language: Markdown
@Datetime: 17-02-07 02:34
```

public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    points.add(new Point(i, j));
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int sum = 0;
                    for (Point point : points) {
                        sum += calDistance(i, j, point);
                    }
                    result = Math.min(result, sum);
                }
            }
        }
        return result;
    }
    
    private int calDistance(int i, int j, Point point) {
        return Math.abs(i - point.x) + Math.abs(j - point.y);
    }
}