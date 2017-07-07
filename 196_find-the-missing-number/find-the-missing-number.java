/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/find-the-missing-number
@Language: Java
@Datetime: 16-12-01 15:38
*/

public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        /*int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return (((1 + n) * n) / 2) - sum;*/
        
        int result = 0, i;
        for (i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        return result ^ i;
    }
}