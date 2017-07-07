/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/count-and-say
@Language: Java
@Datetime: 17-02-25 21:13
*/

public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        String prev = "1";
        while (n > 1) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char curt = prev.charAt(0);
            for (int i = 1; i < prev.length(); i++) {
                if (prev.charAt(i) == curt) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(curt);
                    count = 1;
                    curt = prev.charAt(i);
                }
            }
            sb.append(count);
            sb.append(curt);
            prev = sb.toString();
            n--;
        }
        return prev;
    }
}