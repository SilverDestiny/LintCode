/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words
@Language: Java
@Datetime: 16-12-12 17:57
*/

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        String[] result = new String[k];
        if (k == 0) {
            return result;
        }
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        
        //bucket sort
        ArrayList<String>[] bucket = new ArrayList[words.length + 1];
        for (String key : map.keySet()) {
            if (bucket[map.get(key)] == null) {
                bucket[map.get(key)] = new ArrayList<String>();
            }
            bucket[map.get(key)].add(key);
        }
        
        int count = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }
            Collections.sort(bucket[i]);
            for (String word : bucket[i]) {
                result[count] = word;
                count++;
                if (count == k) {
                    break;
                }
            }
            if (count == k) {
                break;
            }
        }
        return result;
    }
}