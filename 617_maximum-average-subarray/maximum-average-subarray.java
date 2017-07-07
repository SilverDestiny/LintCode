/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/maximum-average-subarray
@Language: Java
@Datetime: 17-03-07 22:13
*/

public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            start = Math.min(start, nums[i]);
            end = Math.max(end, nums[i]);
        }
        
        while (end - start > 1e-5) {
            double mid = (start + end) / 2;
            double sum = 0, preMin = 0, preSum = 0;
            boolean flag = false;
            for (int i = 0; i < k - 1; i++) {
                sum += nums[i] - mid;
            }
            for (int i = k - 1; i < nums.length; i++) {
                sum += nums[i] - mid;
                if (sum - preMin >= 0) {
                    flag = true;
                    break;
                }
                preSum += nums[i - k + 1] - mid;
                preMin = Math.min(preMin, preSum);
            }
            if (flag) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}