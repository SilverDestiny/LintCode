/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/longest-substring-without-repeating-characters
@Language: Java
@Datetime: 17-02-08 16:16
*/

public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && j <= map.get(s.charAt(i))) {
                j = map.get(s.charAt(i)) + 1;
            }
            maxLen = Math.max(maxLen, i - j + 1);
            map.put(s.charAt(i), i);
        }
        return maxLen;
    }
}