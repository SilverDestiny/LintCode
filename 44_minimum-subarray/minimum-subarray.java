/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/minimum-subarray
@Language: Java
@Datetime: 16-10-31 20:25
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums.size() == 1) {
            return nums.get(0);
        }
        int min_end_here = nums.get(0), min_so_far = nums.get(0);
        
        for (int i = 1; i < nums.size(); i++) {
            min_end_here = Math.min(nums.get(i), nums.get(i) + min_end_here);
            min_so_far = Math.min(min_so_far, min_end_here);
        }
        return min_so_far;
    }
}
