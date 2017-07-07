/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/median
@Language: Java
@Datetime: 17-02-01 02:09
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, (nums.length + 1) / 2);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        
        int i = start, j = end;
        int pivot = nums[(start + end) / 2];
        while (i <= j) {
            if (nums[i] < pivot) {
                i++;
            } else if (nums[j] > pivot) {
                j--;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        
        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }
        if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        }
        return nums[j + 1];
    }
}
