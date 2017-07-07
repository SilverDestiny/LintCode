/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/number-of-ways-to-represent-n-cents
@Language: Java
@Datetime: 16-11-30 19:51
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int waysNCents(int n) {
        // Write your code here
        int[] f = new int[n + 1];
        f[0] = 1;
        int[] cents = {1, 5, 10, 25};
        
        for (int i = 0; i < cents.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - cents[i] >= 0) {
                    f[j] += f[j - cents[i]];
                }
            }
        }
        return f[n];
    }
}