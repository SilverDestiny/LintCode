/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/typeahead
@Language: Java
@Datetime: 17-03-24 16:08
*/

public class Typeahead {
   private HashMap<String, List<String>> map = new HashMap<String , List<String>>();
    // @param dict A dictionary of words dict
    public Typeahead(Set<String> dict) {
        // do initialize if necessary
        for (String str : dict) {
            int len = str.length();
            for (int i = 0; i < len; ++i)
                for (int j = i + 1; j <= len; ++j) {
                    String tmp = str.substring(i, j);
                    if (!map.containsKey(tmp)) {
                        map.put(tmp, new ArrayList<String>());
                        map.get(tmp).add(str);
                    } else {
                        if (!map.get(tmp).get(map.get(tmp).size() - 1).equals(str)) {
                            map.get(tmp).add(str);
                        }
                    }
                }
        }
    }

    // @param str: a string
    // @return a list of words
    public List<String> search(String str) {
        // Write your code here
        if (!map.containsKey(str)) {
            return new ArrayList<String>();
        } else {
            return map.get(str);
        }
    }
}