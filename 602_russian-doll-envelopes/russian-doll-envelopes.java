/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/russian-doll-envelopes
@Language: Java
@Datetime: 17-03-19 22:55
*/

public class Solution {
    /**
     * @param envelopes a number of envelopes with widths and heights
     * @return the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        });
        
        int[] f = new int[envelopes.length];
        int len = 0;
        for (int i = 0; i < envelopes.length; i++) {
            int index = Arrays.binarySearch(f, 0, len, envelopes[i][1]);
            if (index < 0) {
                index = - (index + 1);
            }
            f[index] = envelopes[i][1];
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}