/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/partition-array-by-odd-and-even
@Language: Java
@Datetime: 17-01-10 01:04
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 == 1) {
                start++;
            } else if (nums[end] % 2 == 0) {
                end--;
            } else {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
    }
}