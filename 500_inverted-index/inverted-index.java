/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/inverted-index
@Language: Java
@Datetime: 17-03-23 15:28
*/

/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class Solution {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        HashMap<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        for (Document doc : docs) {
            String[] words = doc.content.split(" ");
            for (String word : words) {
                if (word.length() == 0) {
                    continue;
                }
                if (!result.containsKey(word)) {
                    result.put(word, new ArrayList<Integer>());
                }
                if (!result.get(word).contains(doc.id)) {
                    result.get(word).add(doc.id);
                }
            }
        }
        return result;
    }
}