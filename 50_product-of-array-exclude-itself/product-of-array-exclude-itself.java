/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/product-of-array-exclude-itself
@Language: Java
@Datetime: 16-12-28 15:54
*/

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return result;
        }
        
        int len = A.size();
        long[] backward = new long[len];
        backward[len - 1] = A.get(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            backward[i] = A.get(i) * backward[i + 1];
        }
        
        long forward = 1;
        for (int i = 0; i < len; i++) {
            if (i + 1 < len) {
                result.add(forward * backward[i + 1]);
            } else {
                result.add(forward);
            }
            forward *= A.get(i);
        }
        return result;
    }
}
