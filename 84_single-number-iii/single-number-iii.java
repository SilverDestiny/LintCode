/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/single-number-iii
@Language: Java
@Datetime: 17-02-26 20:39
*/

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        int bit =xor ^ (xor & (xor - 1));
        int res1 = 0, res2 = 0;
        for (int i = 0; i < A.length; i++) {
            if ((bit & A[i]) == 0) {
                res1 ^= A[i];
            } else {
                res2 ^= A[i];
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(res1);
        result.add(res2);
        return result;
    }
}