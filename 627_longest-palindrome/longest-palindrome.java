/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/longest-palindrome
@Language: Java
@Datetime: 17-02-23 00:10
*/

public class Solution {
    /**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // Write your code here
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean hasOdd = false;
        int sum = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] % 2 == 0) {
                sum += count[i];
            } else {
                hasOdd = true;
                sum += count[i] - 1;
            }
        }
        return hasOdd ? sum + 1 : sum;
    }
}