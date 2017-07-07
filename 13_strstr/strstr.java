/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Java
@Datetime: 17-03-08 18:06
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        /*
        if (source == null || target == null) {
            return -1;
        }
        int lens = source.length();
        int lent = target.length();
        
        for (int i = 0; i <= lens - lent; i++) {
            if (source.substring(i, i + lent).equals(target)) {
                return i;
            }
        }
        return -1;
        */
        if (source == null || target == null) {
            return -1;
        }
        return source.indexOf(target);
    }
}