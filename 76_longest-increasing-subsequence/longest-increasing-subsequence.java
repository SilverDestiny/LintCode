/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/longest-increasing-subsequence
@Language: Java
@Datetime: 17-01-31 21:28
*/

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
     
    /*
    //O(n ^ 2)
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int []f = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i] && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                }
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }
    */
    
    public int longestIncreasingSubsequence(int[] nums) {
        int[] f = new int[nums.length];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            //int index = Arrays.binarySearch(f, 0, len, nums[i]);
            int index = binarySearch(f, 0, len, nums[i]);
            if (index < 0) {
                index = - (index + 1);
            }
            f[index] = nums[i];
            if (index == len) {
                len++;
            }
        }
        return len;
    }
    
    private int binarySearch(int[] f, int start, int end, int target) {
        if (start == end) {
            return start;
        }
        end = end - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (f[mid] == target) {
                return mid;
            } else if (f[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (target <= f[start]) {
            return start;
        } else {
            return start + 1;
        }
    }
}
