/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/partition-array-ii
@Language: Java
@Datetime: 17-03-01 23:22
*/

public class Solution {
    /**
     * @param nums an integer array
     * @param low an integer
     * @param high an integer
     * @return nothing
     */
    public void partition2(int[] nums, int low, int high) {
        // Write your code here
        int i = 0, j = nums.length - 1;
        int index = 0;
        while (index <= j) {
            if (nums[index] < low) {
                swap(nums, i, index);
                i++;
                index++;
            } else if (nums[index] > high) {
                swap(nums, j, index);
                j--;
            } else {
                index++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}