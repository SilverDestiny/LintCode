/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/coins-in-a-line-ii
@Language: Java
@Datetime: 17-02-11 21:47
*/

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        if (n < 3) {
            return true;
        }
        int[] f = new int[n + 1];
        int sum = 0;
        f[0] = 0;
        f[1] = values[n - 1];
        f[2] = values[n - 2] + values[n - 1];
        f[3] = values[n - 3] + values[n - 2];
        sum = f[3] + values[n - 1];
        
        for (int i = 4; i <= n; i++) {
            sum += values[n - i];
            //先手取后，后手尽量取最大，对于先手来说就是取的最小
            f[i] = values[n - i] + Math.max(Math.min(f[i - 2], f[i - 3]), values[n - i + 1] + Math.min(f[i - 3], f[i - 4]));
        }
        return f[n] > sum - f[n];
    }
}