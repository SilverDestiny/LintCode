/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/remove-substrings
@Language: Java
@Datetime: 17-03-09 01:55
*/

public class Solution {
    /**
     * @param s a string
     * @param dict a set of n substrings
     * @return the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // Write your code here
        HashSet<String> set = new HashSet<String>();
        int len = s.length();
        set.add(s);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);
        
        while (!queue.isEmpty()) {
            String curt = queue.poll();
            for (String sub : dict) {
                int index = curt.indexOf(sub);
                while (index != -1) {
                    String newStr = curt.substring(0, index) + curt.substring(index + sub.length(), curt.length());
                    if (!set.contains(newStr)) {
                        queue.offer(newStr);
                        set.add(newStr);
                        len = Math.min(len, newStr.length());
                    }
                    index = curt.indexOf(sub, index + 1);
                }
            }
        }
        return len;
    }
}