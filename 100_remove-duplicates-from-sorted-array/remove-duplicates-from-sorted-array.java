/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array
@Language: Java
@Datetime: 16-07-30 21:03
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
        
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] < nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        
        return i + 1;
    }
}