/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/sort-integers-ii
@Language: Java
@Datetime: 17-03-03 18:09
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    /*
    public void sortIntegers2(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return;
        }
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }
    
    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(A, start, mid, temp);
        mergeSort(A, mid + 1, end, temp);
        merge(A, start, mid, end, temp);
    }
    
    private void merge(int[] A, int start, int mid, int end, int[] temp) {
        int i = start, j = mid + 1, index = start;
        while (i <= mid && j <= end) {
            if (A[i] < A[j]) {
                temp[index++] = A[i++];
            } else {
                temp[index++] = A[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = A[i++];
        }
        while (j <= end) {
            temp[index++] = A[j++];
        }
        for (int k = start; k <= end; k++) {
            A[k] = temp[k];
        }
    }
    */
    public void sortIntegers2(int[] A) {
        if (A == null || A.length < 2) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start, right = end;
        int pivot = A[(start + end) / 2];
        while (left <= right) {
            if (A[left] < pivot) {
                left++;
            } else if (A[right] > pivot) {
                right--;
            } else {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}