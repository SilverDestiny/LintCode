/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/window-sum
@Language: Java
@Datetime: 17-01-29 20:33
*/

public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int sum = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                result[index++] = sum;
            }
        }
        return result;
    }
}

