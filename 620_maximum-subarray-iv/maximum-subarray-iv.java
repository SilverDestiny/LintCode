/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/maximum-subarray-iv
@Language: Java
@Datetime: 17-01-29 23:09
*/

public class Solution {
    /**
     * @param nums an array of integers
     * @param k an integer
     * @return the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length < k) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int preMin = 0;
        int preSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i - k >= 0) {
                preSum += nums[i - k];
                preMin = Math.min(preMin, preSum);
            }
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, sum - preMin);
            }
        }
        return maxSum;
    }
}