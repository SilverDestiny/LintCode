/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/previous-permutation
@Language: Java
@Datetime: 17-01-28 23:50
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		if (nums == null || nums.size() < 2) {
		    return nums;
		}
		int i = nums.size() - 2;
        while (i >= 0 && nums.get(i) <= nums.get(i + 1)) {
            i--;
        }
        if (i >= 0) {
            int j = nums.size() - 1;
            while (j >= 0 && nums.get(j) >= nums.get(i)) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return nums;
    }

    private void reverse(ArrayList<Integer> nums, int start) {
        int i = start, j = nums.size() - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(ArrayList<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
