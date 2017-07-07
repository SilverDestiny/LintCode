/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Java
@Datetime: 16-12-02 22:17
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.equals(end)) {
            return 1;
        }
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        queue.offer(start);
        set.add(start);
        int length = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String word = queue.poll();
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == chars[i]) {
                            continue;
                        }
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (newWord.equals(end)) {
                            return length + 1;
                        }
                        if (!set.contains(newWord) && dict.contains(newWord)) {
                            queue.offer(newWord);
                            set.add(newWord);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
}