/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/minimum-size-subarray-sum
@Language: Java
@Datetime: 17-02-11 19:20
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0, j = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while (i < nums.length) {
            sum += nums[i];
            i++;
            while (sum >= s) {
                min = Math.min(min, i - j);
                sum -= nums[j];
                j++;
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}