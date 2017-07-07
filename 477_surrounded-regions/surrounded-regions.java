/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/surrounded-regions
@Language: Java
@Datetime: 17-03-17 03:39
*/

public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<Node>();
        
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new Node(i, 0));
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new Node(i, n - 1));
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new Node(0, i));
            }
            if (board[m - 1][i] == 'O') {
                queue.offer(new Node(m - 1, i));
            }
        }
        
        while (!queue.isEmpty()) {
            Node curt = queue.poll();
            visited[curt.x][curt.y] = true;
            int x = 0, y = 0;
            for (int k = 0; k < 4; k++) {
                x = curt.x + dx[k];
                y = curt.y + dy[k];
                if (x >= 1 && x < m - 1 && y >= 1 && y < n - 1 && board[x][y] == 'O' && !visited[x][y]) {
                    queue.offer(new Node(x, y));
                }
            }
        }
        
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}