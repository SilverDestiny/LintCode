/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/triangle-count
@Language: Java
@Datetime: 17-01-21 18:58
*/

public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        Arrays.sort(S);
        int count = 0;
        for (int i = 2; i < S.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (S[left] + S[right] <= S[i]) {
                    left++;
                } else {
                    count += right - left;
                    right--;
                }
            }
        }
        return count;
    }
}
