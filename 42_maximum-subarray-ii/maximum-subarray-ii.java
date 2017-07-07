/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/maximum-subarray-ii
@Language: Java
@Datetime: 16-11-04 15:39
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0 || nums.size() == 1) {
            return 0;
        }
        
        int len = nums.size();
        int[][] f = new int[3][len + 1];
        
        for (int i = 1; i <= 2; i++) {
            int sum = Integer.MIN_VALUE;
            for (int j = 1; j <= len; j++) {
                sum = Math.max(sum, f[i - 1][j - 1]) + nums.get(j - 1);
                if (j == i) {
                    f[i][j] = sum;
                } else {
                    f[i][j] = Math.max(f[i][j - 1], sum);
                }
            }
        }
        return f[2][len];
    }
}

