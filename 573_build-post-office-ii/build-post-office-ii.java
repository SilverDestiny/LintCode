/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/build-post-office-ii
@Language: Java
@Datetime: 17-02-07 21:23
*/

/*
public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     
    class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<Node> nodes = new ArrayList<Node>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    nodes.add(new Node(i, j));
                }
            }
        }
        
        if (nodes.size() == m * n) {
            return -1;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(min, bfs(grid, i, j, nodes, m, n));
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    private int bfs(int[][] grid, int i, int j, ArrayList<Node> nodes, int m, int n) {
        int sum = 0;
        
        for (Node node : nodes) {
            int path = -1;
            boolean[][] visited = new boolean[m][n];
            Queue<Node> queue = new LinkedList<Node>();
            queue.offer(new Node(i, j));
            visited[i][j] = true;
            boolean exist = false;
            
            while (!queue.isEmpty()) {
                path++;
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    Node temp = queue.poll();
                    for (int l = 0; l < 4; l++) {
                        int x = temp.x + dx[l];
                        int y = temp.y + dy[l];
                        if (x == node.x && y == node.y) {
                            path++;
                            exist = true;
                            sum += path;
                            queue.clear();
                            k = size;
                            break;
                        }
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !visited[x][y]) {
                            queue.offer(new Node(x, y));
                            visited[x][y] = true;
                        }
                    }
                }
            }
            if (!exist) {
                return Integer.MAX_VALUE;
            }
        }
        return sum;
    }
}
*/

public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    class Node{
        int x;
        int y;
        int dis;
        public Node(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public int shortestDistance(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }

        int n = grid.length;
        int m = grid[0].length;
        ArrayList<Node> house = new ArrayList<Node>();
        //find house position
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    house.add(new Node(i, j, 0));
                }
            }
        }
        //no empty place
        int k = house.size();
        if(k == n * m){
            return -1;
        }

        int[][][] distance = new int[k][n][m];
        for(int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(distance[i][j], Integer.MAX_VALUE);
            }
        }

        for(int i = 0; i < k; i++){
            getDistance(house.get(i), distance, i, grid);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    int sum = 0;
                    for(int l = 0; l < k; l++){
                        if(distance[l][i][j] == Integer.MAX_VALUE){
                            sum = Integer.MAX_VALUE;
                            break;
                        }
                        sum += distance[l][i][j];
                    }
                    min = Math.min(min, sum);
                }
            }
        }

        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    //BFS search for shortest path
    private void getDistance(Node curt, int[][][] distance, int k, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Node> queue = new LinkedList<Node>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(curt);
        visited[curt.x][curt.y] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i = 0; i < 4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && grid[nextX][nextY] == 0 && !visited[nextX][nextY]){
                    distance[k][nextX][nextY] = now.dis + 1;
                    queue.add(new Node(nextX, nextY, now.dis + 1));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}