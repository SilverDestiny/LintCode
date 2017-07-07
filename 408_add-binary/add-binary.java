/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/add-binary
@Language: Java
@Datetime: 17-02-25 22:07
*/

public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i >= 0 || j >= 0) {
            int v1 = 0;
            int v2 = 0;
            if (i >= 0) {
                v1 = a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                v2 = b.charAt(j) - '0';
                j--;
            }
            sb.append((v1 + v2 + carry) % 2);
            carry = (v1 + v2 + carry) / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}