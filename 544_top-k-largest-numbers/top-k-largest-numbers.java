/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers
@Language: Java
@Datetime: 16-12-08 23:58
*/

class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        int size = k;
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(nums[i]);
            } else if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.sort(result, Collections.reverseOrder());
        int[] results = new int[k];
        for (int i = 0; i < results.length; i++) {
            results[i] = result.get(i);
        }
        return results;
    }
};

