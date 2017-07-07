/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/backpack
@Language: Java
@Datetime: 17-02-15 16:05
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int[][] f = new int[2][m + 1];
        
        for (int i = 0; i < m + 1; i++) {
            f[0][i] = 0;
        }
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                f[i % 2][j] = f[(i - 1) % 2][j];
                if (j - A[i - 1] >= 0) {
                    f[i % 2][j] = Math.max(f[i % 2][j], f[(i - 1) % 2][j - A[i - 1]] + A[i - 1]);
                }
            }
        }
        return f[A.length % 2][m];
    }
}