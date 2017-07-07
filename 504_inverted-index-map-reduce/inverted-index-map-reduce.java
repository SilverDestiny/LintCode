/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/inverted-index-map-reduce
@Language: Java
@Datetime: 17-04-01 23:21
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class InvertedIndex {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] words = value.content.split(" ");
            for (String word : words) {
                if (word.length() > 0) {
                    output.collect(word, value.id);
                }
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            List<Integer> index = new ArrayList<Integer>();
            while (values.hasNext()) {
                int i = values.next();
                if (index.isEmpty() || index.get(index.size() - 1) != i) {
                    index.add(i);
                }
            }
            output.collect(key, index);
        }
    }
}
