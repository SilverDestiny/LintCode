/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/last-position-of-target
@Language: Java
@Datetime: 17-03-07 17:50
*/

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}