/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Java
@Datetime: 16-04-21 16:44
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        int n = s.length();
        int maxLength = maxLength(dict);
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        
        for (int i = 1; i <= n; i++) {
            int j = 0;
            if (i - maxLength > 0) {
                j = i - maxLength;
            }
            for (; j < i; j++) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
    
    public int maxLength(Set<String> dict) {
        int max = 0;
        for (String word : dict) {
            if (word.length() > max) {
                max = word.length();
            }
        }
        return max;
    }
}