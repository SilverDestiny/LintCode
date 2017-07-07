/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/unique-binary-search-trees
@Language: Java
@Datetime: 16-12-29 22:34
*/

public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        int[] f = new int[n + 1];
        f[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j] * f[i - 1 - j];
            }
        }
        return f[n];
    }
}