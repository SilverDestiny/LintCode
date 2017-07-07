/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/string-permutation
@Language: Java
@Datetime: 17-01-10 21:51
*/

public class Solution {
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        // Write your code here
        if (A.length() != B.length()) {
            return false;
        }
        int[] count = new int[256];
        for (char c : A.toCharArray()) {
            count[c]++;
        }
        for (char c : B.toCharArray()) {
            count[c]--;
            if (count[c] < 0) {
                return false;
            }
        }
        return true;
    }
}