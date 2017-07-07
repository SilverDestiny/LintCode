/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/wood-cut
@Language: Java
@Datetime: 17-03-07 19:39
*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        int start = 1, end = 0;
        for (int i = 0; i < L.length; i++) {
            end = Math.max(L[i], end);
        }
        
        while (start < end) {
            int mid = start + 1 + (end - start - 1) / 2;
            if (count(L, mid) < k) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        if (count(L, start) >= k) {
            return start;
        }
        return 0;
    }
    
    private int count(int[] L, int len) {
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i] / len;
        }
        return sum;
    }
}