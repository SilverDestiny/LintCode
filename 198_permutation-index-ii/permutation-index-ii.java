/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/permutation-index-ii
@Language: Java
@Datetime: 17-01-29 19:55
*/

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    
    public long permutationIndexII(int[] A) {
        // Write your code here
        int n = A.length - 1;
        long index = 1;
        long factorial = 1;
        long div = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = n - 1; i >= 0; i--) {
            factorial *= n - i;
            int count = 0;
            boolean added = false;
            for (int j = i + 1; j < n + 1; j++) {
                if (A[i] == A[j] && !added) {
                    if (!map.containsKey(A[i])) {
                        map.put(A[i], 2);
                    } else {
                        map.put(A[i], map.get(A[i]) + 1);
                    }
                    div *= map.get(A[i]);
                    added = true;
                }
                if (A[i] > A[j]) {
                    count++;
                }
            }
            index += factorial * count / div;
        }
        return index;
    }
}