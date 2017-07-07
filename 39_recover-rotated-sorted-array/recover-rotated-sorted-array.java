/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/recover-rotated-sorted-array
@Language: Java
@Datetime: 17-01-26 03:59
*/

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() < 2) {
            return;
        }
        int end = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                break;
            } else {
                end++;
            }
        }
        if (end == nums.size() - 1) {
            return;
        }
        reverse(nums, 0, end);
        reverse(nums, end + 1, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }
    
    private void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}