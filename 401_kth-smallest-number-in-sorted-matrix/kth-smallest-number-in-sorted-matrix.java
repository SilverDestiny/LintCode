/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/kth-smallest-number-in-sorted-matrix
@Language: Java
@Datetime: 17-01-22 01:01
*/

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
    
    /*
        if (matrix == null || matrix[0] == null || matrix.length * matrix[0].length < k) {
            return -1;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length && (j + 1) * (i + 1) <= k; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(matrix[i][j]);
                } else {
                    if (maxHeap.peek() > matrix[i][j]) {
                        maxHeap.poll();
                        maxHeap.offer(matrix[i][j]);
                    }
                }
            }
        }
        return maxHeap.peek();
    */
    
        if (matrix == null || matrix[0] == null || matrix.length * matrix[0].length < k) {
            return -1;
        }
        int start = matrix[0][0], end = matrix[matrix.length - 1][matrix[0].length - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            int i = matrix.length - 1, j = 0, count = 0;
            while (i >= 0 && j < matrix[0].length) {
                if (matrix[i][j] <= mid) {
                    j++;
                } else {
                    count += j;
                    i--;
                }
            }
            count += (i + 1) * j;
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        /*
        int i = matrix.length - 1, j = 0, count = 0;
        boolean exist = false;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] < end) {
                j++;
            } else {
                if (matrix[i][j] == end) {
                    exist = true;
                }
                count += j;
                i--;
            }
        }
        count += (i + 1) * j;
        if (exist && count < k) {
            return end;
        } else {
            return start;
        }
        */
        return start;
    }
}