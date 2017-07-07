/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/word-ladder-ii
@Language: Java
@Datetime: 16-12-06 15:51
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here 
        List<List<String>> result = new ArrayList<>();
        if (start.equals(end)) {
            ArrayList<String> path = new ArrayList<String>();
            path.add(start);
            result.add(path);
            return result;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        queue.offer(start);
        set.add(start);
        int length = 1;
        boolean exist = false;
        
        while (!queue.isEmpty()) {
            ArrayList<String> temp = new ArrayList<String>();
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String word = queue.poll();
                map.put(word, new ArrayList<String>());
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    char oldChar = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == chars[i]) {
                            continue;
                        }
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (newWord.equals(end)) {
                            length++;
                            exist = true;
                            map.get(word).add(newWord);
                            break;
                        }
                        if (!set.contains(newWord) && dict.contains(newWord)) {
                            if (!temp.contains(newWord)) {
                                temp.add(newWord);
                            }
                            map.get(word).add(newWord);
                        }
                        chars[i] = oldChar;
                    }
                }
            }
            queue.addAll(temp);
            set.addAll(temp);
            if (exist) {
                break;
            }
            length++;
        }
        if (!exist) {
            return result;
        }
        
        ArrayList<String> path = new ArrayList<String>();
        dfs(result, path, start, end, length, 1, map);

        return result;
    }
    
    private void dfs(List<List<String>> result, ArrayList<String> path, String curt, String end, int length, int distance, HashMap<String, List<String>> map) {
        if (distance > length) {
            return;
        }
        path.add(curt);
        if (curt.equals(end)) {
            result.add(new ArrayList<String>(path));
        } else {
            if (map.containsKey(curt)) {
                for (String neighbor : map.get(curt)) {
                    dfs(result, path, neighbor, end, length, distance + 1, map);
                }
            }
        }
        path.remove(path.size() - 1);
    }
    
}