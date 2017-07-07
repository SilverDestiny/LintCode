/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/jump-game-ii
@Language: Java
@Datetime: 17-02-22 15:35
*/

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length <= 1) {
            return 0;
        }
        
        int start = 0, farthest = 0, jump = 0;
        while (farthest < A.length - 1) {
            jump++;
            int tmp = farthest;
            for (int i = start; i <= farthest; i++) {
                if (A[i] + i > tmp) {
                    tmp = A[i] + i;
                }
            }
            start = farthest + 1;
            farthest = tmp;
        }
        return jump;
    }
}
