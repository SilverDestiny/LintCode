/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/continuous-subarray-sum-ii
@Language: Java
@Datetime: 17-02-17 17:53
*/

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return result;
        }
        result.add(0);
        result.add(0);
        int n = A.length;
        int total = 0;
        int sum = 0;
        int min = 0;
        int minIndex = 0;
        int max = Integer.MIN_VALUE;
        
        //maximum subarray sum
        for (int i = 1; i <= n; i++) {
            sum += A[i - 1];
            if (sum - min > max) {
                max = sum - min;
                result.set(0, minIndex);
                result.set(1, i - 1);
            }
            if (sum < min) {
                min = sum;
                minIndex = i;
            }
        }
        total = sum;
        
        sum = 0;
        int maxSum = 0;
        int start = 0;
        int end = 0;
        min = 0;
        for (int i = 1; i <= A.length; i++) {
            sum += A[i - 1];
            if (sum - maxSum < min) {
                min = sum - maxSum;
                if (total - min > max && start != 0) {
                    result.set(0, i % n);
                    result.set(1, start - 1);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                start = i;
            }
        }
        
        return result;
    }
}