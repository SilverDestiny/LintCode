/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/number-of-islands
@Language: Java
@Datetime: 17-02-07 22:49
*/

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } 
    
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    //dfs(grid, i, j);
                    bfs(grid, new Node(i, j), m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(boolean[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || !grid[i][j]) {
            return;
        }
        grid[i][j] = false;
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    private void bfs(boolean[][] grid, Node node, int m, int n) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);
        grid[node.x][node.y] = false;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y]) {
                    queue.offer(new Node(x, y));
                    grid[x][y] = false;
                }
            }
        }
    }
}