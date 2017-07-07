/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/maximum-subarray-iii
@Language: Java
@Datetime: 16-11-01 22:14
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || k > nums.length) {
            return 0;
        }
        int len = nums.length;
        int[][] f = new int[k + 1][len + 1];
        //f[1][0] = nums[0];
        
        for (int i = 1; i <= k; i++) {
            int preMax = Integer.MIN_VALUE;
            for (int j = i; j <= len; j++) {
                preMax = Math.max(preMax, f[i - 1][j - 1]) + nums[j - 1];
                if (j == i) {
                    f[i][j] = preMax;
                } else {
                    f[i][j] = Math.max(f[i][j - 1], preMax);
                }
            }
        }
        return f[k][len];
    }
    
    /*public int maxSubArray(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int len = nums.length;
        
       
        int[][] globalMax = new int[k + 1][len + 1];
        int[][] localMax = new int[k + 1][len + 1];
        
        for (int i = 1; i <= k; i++) {
            localMax[i][i-1] = Integer.MIN_VALUE;
            //小于 i 的数组不能够partition
            for (int j = i; j <= len; j++) {
                localMax[i][j] = Math.max(localMax[i][j-1], globalMax[i - 1][j-1]) + nums[j-1];
                if (j == i)
                    globalMax[i][j] = localMax[i][j];
                else
                    globalMax[i][j] = Math.max(globalMax[i][j-1], localMax[i][j]);
            }
        }
        return globalMax[k][len];
    }*/
}
