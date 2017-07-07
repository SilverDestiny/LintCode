/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/minimum-window-substring
@Language: Java
@Datetime: 17-02-08 20:43
*/

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        if (source == null || target == null) {
            return "";
        }
        int lenS = source.length();
        int lenT = target.length();
        if (lenS < lenT) {
            return "";
        }
        
        int[] count = new int[256];
        int num = 0;
        for (int i = 0; i < lenT; i++) {
            count[target.charAt(i)]++;
            num++;
        }
        String result = "";
        
        for (int i = 0, j = 0; i < lenS; i++) {
            if (count[source.charAt(i)] > 0) {
                num--;
            }
            count[source.charAt(i)]--;
            if (num == 0) {
                while (num == 0) {
                    count[source.charAt(j)]++;
                    if (count[source.charAt(j)] > 0) {
                        num++;
                    }
                    j++;
                }
                if (result.equals("") || i - j + 2 < result.length()) {
                    result = source.substring(j - 1, i + 1);
                }
            }
        }
        return result;
    }
}