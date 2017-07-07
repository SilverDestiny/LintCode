/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/word-break-ii
@Language: Java
@Datetime: 16-12-15 16:49
*/

public class Solution {
    /**
     * @param s a string
     * @param wordDict a set of words
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        if (!breakable(s, wordDict)) {
            return result;
        } else {
            StringBuilder sb = new StringBuilder();
            dfs(s, wordDict, sb, result);
            return result;
        }
    }
    
    private void dfs(String s, Set<String> wordDict, StringBuilder sb, List<String> result) {
        for (String word : wordDict) {
            if (s.equals(word)) {
                sb.append(word);
                result.add(sb.toString());
                sb.delete(sb.length() - word.length(), sb.length());
            } else if (s.startsWith(word)) {
                if (word.equals("")) {
                    return;
                } else {
                    sb.append(word + " ");
                    dfs(s.substring(word.length()), wordDict, sb, result);
                    sb.delete(sb.length() - word.length() - 1, sb.length());
                }
            }
        }
        return;
    }
    
    private boolean breakable(String s, Set<String> dict) {
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
    
    private int maxLength(Set<String> dict) {
        int max = 0;
        for (String word : dict) {
            if (word.length() > max) {
                max = word.length();
            }
        }
        return max;
    }
}