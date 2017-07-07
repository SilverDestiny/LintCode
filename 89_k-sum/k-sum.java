/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/k-sum
@Language: Java
@Datetime: 17-02-18 20:19
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    /*
    public int kSum(int A[], int k, int target) {
        // write your code here
        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            f[i][0][0] = 1;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1 && j <= i; j++) {
                for (int t = 1; t < target + 1; t++) {
                    f[i][j][t] = f[i - 1][j][t];
                    if (t >= A[i - 1]) {
                        f[i][j][t] += f[i - 1][j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        return f[n][k][target];
    }*/
    
    public int kSum(int A[], int k, int target) {
        // write your code here
        int n = A.length;
        int[][][] f = new int[2][k + 1][target + 1];
        for (int i = 0; i < 2; i++) {
            f[i][0][0] = 1;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1 && j <= i; j++) {
                for (int t = 1; t < target + 1; t++) {
                    f[i % 2][j][t] = f[(i - 1) % 2][j][t];
                    if (t >= A[i - 1]) {
                        f[i % 2][j][t] += f[(i - 1) % 2][j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        return f[n % 2][k][target];
    }
}
