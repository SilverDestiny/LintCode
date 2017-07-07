/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/kth-largest-element
@Language: Java
@Datetime: 17-01-14 01:10
*/

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int l = left, r = right;
        int pivot = nums[right];
        
        while (l < r) {
            if (nums[l] < pivot) {
                l++;
            } else if (nums[r] >= pivot) {
                r--;
            } else {
                swap(nums, l, r);
            }
        }
        swap(nums, l, right);
        
        if (l == k) {
            return nums[l];
        } else if (l < k) {
            return quickSelect(nums, l + 1, right, k);
        } else {
            return quickSelect(nums, left, l - 1, k);
        }
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
};