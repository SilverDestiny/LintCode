/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/single-number
@Language: Java
@Datetime: 16-12-31 18:32
*/

public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = A[0];
        for (int i = 1; i < A.length; i++) {
            res = res ^ A[i];
        }
        return res;
    }
}