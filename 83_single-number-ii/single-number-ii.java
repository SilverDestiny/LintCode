/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/single-number-ii
@Language: Java
@Datetime: 17-01-03 18:04
*/

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}