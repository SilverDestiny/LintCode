/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/maximum-product-subarray
@Language: Java
@Datetime: 16-11-01 01:58
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp1 = max * nums[i], temp2 = min * nums[i];
            max = Math.max(Math.max(temp1, temp2), nums[i]);
            min = Math.min(Math.min(temp1, temp2), nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}