/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words-map-reduce
@Language: Java
@Datetime: 17-04-01 23:07
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
 
class Node {
    String key;
    int freq;
    public Node(String key, int freq) {
        this.key = key;
        this.freq = freq;
    }
}

public class TopKFrequentWords {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);\
            String[] words = value.content.split(" ");
            for (String word : words) {
                if (word.length() > 0) {
                    output.collect(word, 1);
                }
            }
        }
    }

    public static class Reduce {
        
        private PriorityQueue<Node> minHeap;
        private int k;
        
        public void setup(int k) {
            // initialize your data structure here
            minHeap = new PriorityQueue<Node>(k, new Comparator<Node>() {
                @Override
                public int compare(Node a, Node b) {
                    if (a.freq != b.freq) {
                        return a.freq - b.freq;
                    } else {
                        return b.key.compareTo(a.key);
                    }
                }
            });
            this.k = k;
        }   

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int count = 0;
            while (values.hasNext()) {
                count++;
                values.next();
            }
            minHeap.offer(new Node(key, count));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            List<Node> list = new ArrayList<Node>();
            while (!minHeap.isEmpty()) {
                list.add(minHeap.poll());
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                output.collect(list.get(i).key, list.get(i).freq);
            }
        }
    }
}