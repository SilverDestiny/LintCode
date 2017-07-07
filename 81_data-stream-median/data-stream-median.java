/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/data-stream-median
@Language: Java
@Datetime: 17-01-06 01:36
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        PriorityQueue<Integer> max = new PriorityQueue<Integer>();
        int[] medians = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            max.add(-nums[i]);
            min.add(-max.poll());
            while (max.size() < min.size()) {
                max.add(-min.poll());
            }
            medians[i] = -max.peek();
        }
        return medians;
    }
}