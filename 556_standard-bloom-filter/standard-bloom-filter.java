/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/standard-bloom-filter
@Language: Java
@Datetime: 17-04-08 20:24
*/

public class StandardBloomFilter {

    HashSet<String> set;
    public StandardBloomFilter(int k) {
        // initialize your data structure here
        set = new HashSet<String>();
    }

    public void add(String word) {
        // Write your code here
        set.add(word);
    }

    public boolean contains(String word) {
        // Write your code here
        return set.contains(word);
    }
}