/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/copy-books
@Language: Java
@Datetime: 17-01-07 20:26
*/

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int start = 0, end = 0;
        for (int i = 0; i < pages.length; i++) {
            start = Math.max(start, pages[i]);
            end += pages[i];
        }
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (check(pages, k, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (check(pages, k, start)) {
            return start;
        } else {
            return end;
        }
    }
    
    private boolean check(int[] pages, int k, int mins) {
        int count = 0, total = 0;
        for (int i = 0; i < pages.length; i++) {
            if (total + pages[i] > mins) {
                count++;
                total = 0;
            }
            total += pages[i];
        }
        if (total > 0) {
            count++;
        }
        return count <= k;
    }
}