/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/partition-array
@Language: Java
@Datetime: 16-05-02 00:02
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
	    
	    int left = 0, right = nums.length - 1;
	    while (left <= right) {
	        if (nums[left] < k) {
	            left++;
	        } else {
	            int temp = nums[left];
	            nums[left] = nums[right];
	            nums[right] = temp;
	            right--;
	        }
	    }
	    
	    return left;
    }
}