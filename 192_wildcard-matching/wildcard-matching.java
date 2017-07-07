/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/wildcard-matching
@Language: Java
@Datetime: 16-12-14 18:08
*/

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        int i = 0, j = 0, sStart = 0, starIndex = -1;
        
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                sStart = i;
                starIndex = j;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                sStart++;
                i = sStart;
            } else {
                return false;
            }
        }
        while (j < p.length()) {
            if (p.charAt(j) == '*') {
                j++;
            } else {
                break;
            }
        }
        return j == p.length();
     }
}