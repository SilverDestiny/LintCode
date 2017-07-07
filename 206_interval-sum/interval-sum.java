/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/interval-sum
@Language: Java
@Datetime: 17-02-12 00:53
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        long[] sum = new long[A.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= A.length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        
        ArrayList<Long> result = new ArrayList<Long>();
        for (Interval query : queries) {
            result.add(sum[query.end + 1] - sum[query.start]);
        }
        return result;
    }
}
