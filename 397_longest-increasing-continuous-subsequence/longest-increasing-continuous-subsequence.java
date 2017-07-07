/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/longest-increasing-continuous-subsequence
@Language: Java
@Datetime: 17-02-09 23:12
*/

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null) {
            return 0;
        }
        int n = A.length;
        if (n < 2) {
            return n;
        }
        int max = 1;
        int count1 = 1;
        int count2 = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                count1++;
                max = Math.max(max, count1);
            } else {
                count1 = 1;
            }
            if (A[n - 1 - i] > A[n - i]) {
                count2++;
                max = Math.max(max, count2);
            } else {
                count2 = 1;
            }
        }
        return max;
    }
}