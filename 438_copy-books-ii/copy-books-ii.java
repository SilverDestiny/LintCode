/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/copy-books-ii
@Language: Java
@Datetime: 17-02-17 03:30
*/

public class Solution {
    /**
     * @param n: an integer
     * @param times: an array of integers
     * @return: an integer
     */
    public int copyBooksII(int n, int[] times) {
        // write your code here
        int start = times[0], end = 0;
        for (int time : times) {
            start = Math.min(start, time);
        }
        end = start * n;
        
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (check(mid, n, times)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    private boolean check(int min, int n, int[] times) {
        int count = 0;
        for (int time : times) {
            count += min / time;
        }
        return count >= n;
    }
}