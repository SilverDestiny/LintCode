/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/mini-cassandra
@Language: Java
@Datetime: 17-03-22 21:12
*/

/**
 * Definition of Column:
 * public class Column {
 *     public int key;
 *     public String value;
 *     public Column(int key, String value) {
 *         this.key = key;
 *         this.value = value;
 *    }
 * }
 */
public class MiniCassandra {
    private HashMap<String, TreeMap<Integer, String>> map;
    public MiniCassandra() {
        // initialize your data structure here.
        map = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return void
     */
    public void insert(String raw_key, int column_key, String column_value) {
        // Write your code here
        if (!map.containsKey(raw_key)) {
            map.put(raw_key, new TreeMap<Integer, String>());
        }
        map.get(raw_key).put(column_key, column_value);
    }

    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {
        // Write your code here
        List<Column> list = new ArrayList<Column>();
        if (map.containsKey(raw_key)) {
            for (int key : map.get(raw_key).keySet()) {
                if (key >= column_start && key <= column_end) {
                    list.add(new Column(key, map.get(raw_key).get(key)));
                }
            }
        }
        return list;
    }
}