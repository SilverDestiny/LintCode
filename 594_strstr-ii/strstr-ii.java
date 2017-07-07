/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/strstr-ii
@Language: Java
@Datetime: 17-01-23 18:07
*/

public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    /*
    private int[] failureFunction(char[] str) {
        int[] f = new int[str.length+1];
        for (int i = 2; i < f.length; i++) {
            int j = f[i-1];
            while (j > 0 && str[j] != str[i-1]) j = f[j];
            if (j > 0 || str[j] == str[i-1]) f[i] = j+1;
        }
        return f;
    }

    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (target.length() == 0) return 0;
        if (target.length() <= source.length()) {
            int[] f = failureFunction(target.toCharArray());
            int i = 0, j = 0;
            while (i < source.length()) {
                if (source.charAt(i) == target.charAt(j)) {
                    i++; j++;
                    if (j == target.length()) return i-j;
                } else if (j > 0) j = f[j];
                else i++;
            }
        }
        return -1;
    }
    */
    public int strStr2(String source, String target) {
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }
        int m = source.length();
        int n = target.length();
        if (n == 0) {
            return 0;
        }
        int mod = 1000000;
        int hashTarget = 0;
        for (int i = 0; i < n; i++) {
            hashTarget = (hashTarget * 31 + target.charAt(i)) % mod;
        }
        
        int multi = 1;
        for (int i = 0; i < n; i++) {
            multi = multi * 31 % mod;
        }
        int hashSource = 0;
        for (int i = 0; i < m; i++) {
            hashSource = (hashSource * 31 + source.charAt(i)) % mod;
            if (i > n - 1) {
                hashSource = (hashSource - multi * source.charAt(i - n)) % mod;
                if (hashSource < 0) {
                    hashSource += mod;
                }
            }
            if (i >= n - 1 && hashSource == hashTarget) {
                if (source.substring(i - n + 1, i + 1).equals(target)) {
                    return i - n + 1;
                }
            }
        }
        return -1;
    }
}