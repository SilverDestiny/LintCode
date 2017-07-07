/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/maximum-number-in-mountain-sequence
@Language: Java
@Datetime: 17-03-07 22:22
*/

public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            } else {
                return nums[mid];
            }
        }
        
        return Math.max(nums[start], nums[end]);
    }
}