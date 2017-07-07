/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/continuous-subarray-sum
@Language: Java
@Datetime: 17-02-17 15:33
*/

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return result;
        }
        result.add(0);
        result.add(0);
        int n = A.length;
        //int[] sum = new int[n + 1];
        int sum = 0;
        int min = 0;
        int minIndex = 0;
        int max = Integer.MIN_VALUE;
        
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
        return result;
    }
}