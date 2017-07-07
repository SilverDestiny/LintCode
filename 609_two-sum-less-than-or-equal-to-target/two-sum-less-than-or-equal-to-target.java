/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/two-sum-less-than-or-equal-to-target
@Language: Java
@Datetime: 17-01-30 01:22
*/

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int result = 0;
        while (i < j) {
            if (nums[i] + nums[j] <= target) {
                result += j - i;
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}