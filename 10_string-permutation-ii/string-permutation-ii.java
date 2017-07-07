/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/string-permutation-ii
@Language: Java
@Datetime: 16-12-06 17:10
*/

public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            visited[i] = false;
        }
        helper(result, sb, chars, visited);
        return result;
    }
    
    private void helper(List<String> result, StringBuilder sb, char[] chars, boolean[] visited) {
        if (sb.length() == chars.length) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if ((i != 0 && chars[i - 1] == chars[i] && visited[i - 1] == false) || visited[i] == true) {
                continue;
            }
            sb.append(chars[i]);
            visited[i] = true;
            helper(result, sb, chars, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}