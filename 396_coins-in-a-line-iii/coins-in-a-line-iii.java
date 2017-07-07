/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/coins-in-a-line-iii
@Language: Java
@Datetime: 17-02-11 22:22
*/

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        int sum = 0;
        int[][] f = new int[n][n];
        
        //i表示两头之间的距离，j表示左边的第一个coin
        for (int i = 0; i < n; i++) {
            sum += values[i];
            for (int j = 0; j + i < n; j++) {
                if (i == 0) {
                    f[j][j] = values[j];
                } else if (i == 1) {
                    f[j][j + 1] = Math.max(values[j], values[j + 1]);
                } else {
                    //从第j到第j+i个coin，先取的人有2种取法，后取的人之后也有2种取法，取大的
                    f[j][j + i] = Math.max(values[j] + Math.min(f[j + 2][j + i], f[j + 1][j + i - 1]), values[j + i] + Math.min(f[j + 1][j + i - 1], f[j][j + i - 2]));
                }
            }
        }
        return f[0][n - 1] > sum - f[0][n - 1];
    }
}