/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/distinct-subsequences
@Language: Java
@Datetime: 16-04-21 15:25
*/

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int m = S.length();
        int n = T.length();
        int[][] f = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            f[i][0] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = f[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] += f[i - 1][j - 1];
                }
            }
        }
        return f[m][n];
    }
}