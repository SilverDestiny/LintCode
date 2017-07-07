/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/longest-common-subsequence
@Language: Java
@Datetime: 16-04-23 20:38
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        int[][] f = new int[m + 1][n + 1];
        
        /*for (int i = 0; i < m; i++) {
            f[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 0;
        }*/
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[m][n];
    }
}
