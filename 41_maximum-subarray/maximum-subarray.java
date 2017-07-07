/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 16-11-04 15:04
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum, 0) + nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}