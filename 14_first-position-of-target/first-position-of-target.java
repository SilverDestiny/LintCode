/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 17-03-07 17:55
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}