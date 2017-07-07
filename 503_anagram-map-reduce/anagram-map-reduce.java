/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/anagram-map-reduce
@Language: Java
@Datetime: 17-04-02 00:04
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */
public class Anagram {

    public static class Map {
        public void map(String key, String value,
                        OutputCollector<String, String> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, String value);
            String[] words = value.split(" ");
            for (String word : words) {
                if (word.length() > 0) {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    output.collect(String.valueOf(chars), word);
                }
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<String> values,
                           OutputCollector<String, List<String>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<String> value);
            List<String> list = new ArrayList<String>();
            while (values.hasNext()) {
                list.add(values.next());
            }
            output.collect(key, list);
        }
    }
}
