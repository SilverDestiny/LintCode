/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/candy
@Language: Java
@Datetime: 17-02-22 05:34
*/

public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // Write your code here
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        int[] right = new int[n];
        right[n - 1] = 1;
        int result = 0;
        
        for (int i = 1; i < n; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
            right[n - 1 - i] = ratings[n - 1 - i] > ratings[n - i] ? right[n - i] + 1 : 1; 
        }
        
        for (int i = 0; i < n; i++) {
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}