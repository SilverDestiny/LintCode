/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/minimum-adjustment-cost
@Language: Java
@Datetime: 16-10-13 21:25
*/

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int n = A.size();
        int[][] f = new int[n + 1][101];
        for (int j = 1; j < 101; j++) {
            f[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < 101; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < 101; j++) {
                //if (f[i - 1][j] != Integer.MAX_VALUE) {
                    for (int k = Math.max(1, j - target); k <= Math.min(100, j + target); k++) {
                        f[i][k] = Math.min(f[i][k], f[i - 1][j] + Math.abs(A.get(i - 1) - k));
                    }
                //}
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 1; j < 101; j++) {
            result = Math.min(result, f[n][j]);
        }
        return result;
    }
}