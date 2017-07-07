/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/largest-divisible-subset
@Language: Java
@Datetime: 17-01-30 22:14
*/

public class Solution {
    /**
     * @param nums a set of distinct positive integers
     * @return the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }
        int[] pre = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pre[i] = -1;
        }
        int max = 0;
        int maxIndex = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && f[i] + 1 > f[j]) {
                    f[j] = f[i] + 1;
                    pre[j] = i;
                    if (f[j] > max) {
                        max = f[j];
                        maxIndex = j;
                    }
                }
            }
        }
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        return result;
    }
}