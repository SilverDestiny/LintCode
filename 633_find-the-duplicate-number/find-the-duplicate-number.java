/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/find-the-duplicate-number
@Language: Java
@Datetime: 17-03-25 22:31
*/

public class Solution {
    /**
     * @param nums an array containing n + 1 integers which is between 1 and n
     * @return the duplicate one
     */
    /*
    public int findDuplicate(int[] nums) {
        // Write your code here
        //binary search
        int start = 1, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (check(nums, mid) <= mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    
    private int check(int[] nums, int mid) {
        int count = 0;
        for (int num : nums) {
            if (num <= mid) {
                count++;
            }
        }
        return count;
    }
    */
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}