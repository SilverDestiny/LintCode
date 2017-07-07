/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/permutation-index
@Language: Java
@Datetime: 17-01-29 00:26
*/

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        int n = A.length - 1;
        long index = 1;
        long factorial = 1;
        for (int i = n - 1; i >= 0; i--) {
            factorial *= n - i;
            for (int j = i + 1; j < n + 1; j++) {
                if (A[i] > A[j]) {
                    index += factorial;
                }
            }
        }
        return index;
    }
}