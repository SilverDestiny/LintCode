/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/compare-strings
@Language: Java
@Datetime: 16-12-20 20:42
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        int[] count = new int[256];
        for (int i = 0; i < A.length(); i++) {
            count[A.charAt(i)]++;
        }
        for (int i = 0; i < B.length(); i++) {
            count[B.charAt(i)]--;
            if (count[B.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}