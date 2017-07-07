/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/kth-largest-in-n-arrays
@Language: Java
@Datetime: 17-01-21 19:36
*/

public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
    */ 
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (minHeap.size() < k) {
                    minHeap.offer(arrays[i][j]);
                } else if (arrays[i][j] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(arrays[i][j]);
                }
            }
        }
        return minHeap.peek();
    }
}

