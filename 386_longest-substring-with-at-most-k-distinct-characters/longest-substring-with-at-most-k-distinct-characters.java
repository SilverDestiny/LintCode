/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/longest-substring-with-at-most-k-distinct-characters
@Language: Java
@Datetime: 17-04-03 21:45
*/

public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (n < k) {
            return n;
        }
        int num = 0, max = 0;
        int[] count = new int[256];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (count[s.charAt(i)] == 0) {
                num++;
            }
            count[s.charAt(i)]++;
            while (num > k) {
                count[s.charAt(j)]--;
                if (count[s.charAt(j)] == 0) {
                    num--;
                }
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}