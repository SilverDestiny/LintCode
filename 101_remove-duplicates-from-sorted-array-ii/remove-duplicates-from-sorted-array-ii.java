/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array-ii
@Language: Java
@Datetime: 16-12-27 23:22
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        boolean twice = false;
        
        int i = 0, j = 1;
        while (j < nums.length) {
            if (twice) {
                if (nums[i] < nums[j]) {
                    i++;
                    nums[i] = nums[j];
                    twice = false;
                }
                j++;
            } else {
                if (nums[i] == nums[j]) {
                    twice = true;
                }
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        
        return i + 1;
    }
}