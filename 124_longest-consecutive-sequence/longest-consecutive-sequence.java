/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/longest-consecutive-sequence
@Language: Java
@Datetime: 17-03-30 03:59
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : num) {
            set.add(n);
        }
        
        int max = 0;
        for (int n: num) {
            if (set.contains(n)) {
                int left = n;
                int right = n;
                while (set.contains(left - 1)) {
                    left--;
                    set.remove(left);
                }
                while (set.contains(right + 1)) {
                    right++;
                    set.remove(right);
                }
                int len = right - left + 1;
                max = Math.max(max, len);
                set.remove(n);
            }
        }
        return max;
    }
}