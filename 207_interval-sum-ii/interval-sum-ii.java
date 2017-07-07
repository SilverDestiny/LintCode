/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/interval-sum-ii
@Language: Java
@Datetime: 17-02-12 01:09
*/

public class Solution {
    /* you may need to use some attributes here */
    
    long[] sum;
    int[] B;
    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
        // write your code here
        B = A;
        sum = new long[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return sum[end + 1] - sum[start];
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
        int gap = value - B[index];
        B[index] = value;
        for (int i = index + 1; i < sum.length; i++) {
            sum[i] += gap;
        }
    }
}
