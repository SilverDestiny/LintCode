/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/remove-duplicate-numbers-in-array
@Language: Java
@Datetime: 17-02-12 02:27
*/

public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        HashSet<Integer> set = new HashSet<Integer>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}