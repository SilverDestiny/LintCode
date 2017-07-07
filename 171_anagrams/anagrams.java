/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/anagrams
@Language: Java
@Datetime: 16-12-20 23:44
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        /*int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();*/
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        List<String> result = new ArrayList<String>();
        
        for (String str : strs) {
            /*int key = 1;
            for (char c : str.toCharArray()) {
                key *= prime[c - 'a'];
            }*/
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = hash(count);
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for (ArrayList<String> value : map.values()) {
            if (value.size() > 1) {
                result.addAll(value);
            }
        }
        return result;
    }
    
    private String hash(int[] count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sb.append(count[i]);
                sb.append(i);
            }
        }
        return sb.toString();
    }
}