/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/sliding-window-maximum
@Language: Java
@Datetime: 17-01-19 15:14
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length < k) {
            return result;
        }
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k - 1) {
                result.add(nums[dq.peekFirst()]);
            }
        }
        return result;
    }
}
