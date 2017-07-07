/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/subarray-sum-ii
@Language: Java
@Datetime: 17-02-21 18:19
*/

public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] sum = new int[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
            if (sum[i] - start < 0) {
                continue;
            }
            /*
            int left = firstPosition(sum, 0, i - 1, sum[i] - end);
            int right = lastPosition(sum, 0, i - 1, sum[i] - start);
            count += right - left + 1;
            */
            int left = sum[i] <= end ? -1 : binarySearch(sum, 0, i - 1, sum[i] - end - 1);
            int right = binarySearch(sum, 0, i - 1, sum[i] - start);
            count += right - left;
        }
        return count;
    }
    
    private int binarySearch(int[] sum, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (sum[mid] == target) {
                return mid;
            } else if (sum[mid] < target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    
    /*
    private int firstPosition(int[] sum, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (sum[mid] == target) {
                return mid;
            } else if (sum[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (sum[start] >= target) {
            return start;
        } else {
            return start + 1;
        }
    }
    
    private int lastPosition(int[] sum, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (sum[mid] == target) {
                return mid;
            } else if (sum[mid] < target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    */
}