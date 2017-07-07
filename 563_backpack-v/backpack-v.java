/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/backpack-v
@Language: Java
@Datetime: 17-02-15 17:01
*/

public class Solution {
    /**
     * @param nums an integer array and all positive numbers
     * @param target an integer
     * @return an integer
     */
    public int backPackV(int[] nums, int target) {
        // Write your code here
        int[][] f = new int[2][target + 1];
        //key point: initialize f[0][0]
        f[0][0] = 1;
        
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                f[i % 2][j] = f[(i - 1) % 2][j];
                if (j - nums[i - 1] >= 0) {
                    f[i % 2][j] += f[(i - 1) % 2][j - nums[i - 1]];
                }
            }
        }
        return f[nums.length % 2][target];
    }
}