/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/interleaving-string
@Language: Java
@Datetime: 16-04-23 21:04
*/

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int m = s1.length();
        int n = s2.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        
        f[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            f[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && f[i - 1][0];
        }
        for (int j = 1; j < n + 1; j++) {
            f[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && f[0][j - 1];
        }
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                f[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[i - 1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[i][j - 1]);
            }
        }
        return f[m][n];
    }
}