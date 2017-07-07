/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/wiggle-sort-ii
@Language: Java
@Datetime: 17-02-18 22:32
*/

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return;
        }
        double median = median(nums);
        int n = nums.length;
        
        //3-way partition, index needs to be updated
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }
    
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public double median(int[] nums) {
        // write your code here
        if (nums.length % 2 != 0) {
            return quickSelect(nums, 0, nums.length - 1, nums.length / 2);
        } else {
            return (quickSelect(nums, 0, nums.length - 1, nums.length / 2) + quickSelect(nums, 0, nums.length - 1, nums.length / 2 + 1)) / 2.0;
        }
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        
        int i = start, j = end;
        int pivot = nums[(start + end) / 2];
        while (i <= j) {
            if (nums[i] < pivot) {
                i++;
            } else if (nums[j] > pivot) {
                j--;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        
        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }
        if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        }
        return nums[j + 1];
    }
}
