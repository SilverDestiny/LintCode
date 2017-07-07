/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/post-office-problem
@Language: Java
@Datetime: 17-02-13 01:11
*/

public class Solution {
    /**
     * @param A an integer array
     * @param k an integer
     * @return an integer
     */
    public int postOffice(int[] A, int k) {
        // Write your code here
        int n = A.length;
        if (n == 0 || k >= n) {
            return 0;
        }
        
        Arrays.sort(A);
        int[][] dis = init(A, n);
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            f[i][1] = dis[1][i];
        }
        
        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                f[j][i] = Integer.MAX_VALUE;
                for (int m = i - 1; m < j; m++) {
                    f[j][i] = Math.min(f[j][i], f[m][i - 1] + dis[m + 1][j]);
                }
            }
        }
        return f[n][k];
    }
    
    private int[][] init(int[] A, int n) {
        int[][] dis = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int mid = (i + j) / 2;
                for (int k = i; k <= j; k++) {
                    dis[i][j] += Math.abs(A[k - 1] - A[mid - 1]);
                }
            }
        }
        return dis;
    }
}