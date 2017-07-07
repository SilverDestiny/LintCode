/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/house-robber-ii
@Language: Java
@Datetime: 17-02-09 17:58
*/

public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(houseRobber(nums, 0, nums.length - 2), houseRobber(nums, 1, nums.length - 1));
    }
    
    public int houseRobber(int[] A, int start, int end) {
        // write your code here
        if (end - start == 0) {
            return 0;
        }
        int n = end - start + 1;
        int[] f = new int[3];
        f[start % 3] = 0;
        f[(start + 1) % 3] = A[start];
        
        for (int i = start + 2; i <= end + 1; i++) {
            f[i % 3] = Math.max(f[(i - 1) % 3], f[(i - 2) % 3] + A[i - 1]);
        }
        return f[(end + 1) % 3];
    }
}