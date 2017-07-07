/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/longest-increasing-continuous-subsequence-ii
@Language: Java
@Datetime: 17-02-10 17:27
*/

public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(A, i, j, m, n, cache));
            }
        }
        return max;
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    private int dfs(int[][] A, int i, int j, int m, int n, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int len = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && A[x][y] > A[i][j]) {
                len = Math.max(len, 1 + dfs(A, x, y, m, n, cache));
            }
        }
        cache[i][j] = len;
        return len;
    }
}