/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/move-zeroes
@Language: Java
@Datetime: 17-02-12 02:42
*/

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
    }
}