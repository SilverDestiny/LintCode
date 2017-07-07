/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/burst-balloons
@Language: Java
@Datetime: 17-02-14 22:35
*/

public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] A = new int[n + 2];
        A[0] = 1;
        A[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            A[i + 1] = nums[i];
        }
        int[][] f = new int[n + 2][n + 2];
        
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 1; j + i <= n; j++) {
                for (int k = j; k <= j + i; k++) {
                    f[j][j + i] = Math.max(f[j][j + i], f[j][k - 1] + f[k + 1][j + i] + A[j - 1] * A[k] * A[j + i + 1]);
                }
            }
        }
        return f[1][n];
    }
}
