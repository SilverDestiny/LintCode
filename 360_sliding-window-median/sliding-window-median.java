/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/sliding-window-median
@Language: Java
@Datetime: 17-02-05 19:41
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k == 0 || nums.length < k) {
            return result;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        
        for (int i = 0; i < nums.length; i++) {
            if (i > k - 1) {
                if (nums[i - k] > maxHeap.peek()) {
                    //need to optimize remove in heap
                    minHeap.remove(nums[i - k]);
                } else {
                    //need to optimize remove in heap
                    maxHeap.remove(nums[i - k]);
                }
            }
            maxHeap.offer(nums[i]);
            minHeap.offer(maxHeap.poll());
            while (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            if (i > k - 2) {
                result.add(maxHeap.peek());
            }
        }
        return result;
    }
}
