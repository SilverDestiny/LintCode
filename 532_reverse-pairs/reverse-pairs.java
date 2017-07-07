/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/reverse-pairs
@Language: Java
@Datetime: 17-01-12 05:11
*/

public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] temp = new int[A.length];
        return mergeSort(A, 0, A.length - 1, temp);
    }
    
    private long mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        long count = 0;
        count += mergeSort(A, start, mid, temp);
        count += mergeSort(A, mid + 1, end, temp);
        count += merge(A, start, mid, end, temp);
        return count;
    }
    
    private long merge(int[] A, int start, int mid, int end, int[] temp) {
        
        int left = start;
        int right = mid + 1;
        int index = start;
        long count = 0;
        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                temp[index++] = A[left++];
                count += index - left;
            } else {
                temp[index++] = A[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = A[left++];
            count += index - left;
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
        return count;
    }
}