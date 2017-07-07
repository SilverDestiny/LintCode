/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/decode-ways
@Language: Java
@Datetime: 16-10-12 22:20
*/

public class Solution {
 /**
 * @param s a string, encoded message
 * @return an integer, the number of ways decoding
 */
 public int numDecodings(String s) {
 // Write your code here
    if (s == null || s.length() == 0) {
        return 0;
    }
    int n = s.length();
    char[] nums = s.toCharArray();
    int[] f = new int[n + 1];
    
    f[0] = 1;
    for (int i = 1; i < n + 1; i++) {
        if (nums[i - 1] != '0') {
            f[i] = f[i - 1];
        }
        if (i - 2 >= 0) {
            int twoDigit = (nums[i - 2] - '0') * 10 + (nums[i - 1] - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                f[i] += f[i - 2];
            }
        }
    }
    return f[n];
 }
}