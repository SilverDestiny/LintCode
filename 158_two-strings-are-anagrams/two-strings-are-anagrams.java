/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/two-strings-are-anagrams
@Language: Java
@Datetime: 16-12-20 19:49
*/

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]--;
            if (count[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
};