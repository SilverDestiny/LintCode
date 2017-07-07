/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/longest-common-substring
@Language: Java
@Datetime: 16-10-19 17:00
*/

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int lenA = A.length();
        int lenB = B.length();
        int maxLen = 0;
        
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                int len = 0;
                while (i + len < lenA && j + len < lenB && A.charAt(i + len) == B.charAt(j + len)) {
                    len++;
                }
                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }
}