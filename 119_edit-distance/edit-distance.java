/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/edit-distance
@Language: Java
@Datetime: 16-10-19 16:21
*/

public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int m = word1.length();
        int n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        
        //initialize
        for (int i = 0; i <= m; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            f[0][i] = i;
        }
        
        //DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j -1];
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                }
            }
        }
        return f[m][n];
    }
}