/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/lfu-cache
@Language: Java
@Datetime: 17-02-28 21:43
*/

public class LFUCache {

    HashMap<Integer, Integer> kv;
    HashMap<Integer, Integer> kc;
    HashMap<Integer, LinkedHashSet<Integer>> ck;
    int min;
    int size;

    public LFUCache(int capacity) {
        kv = new HashMap<Integer, Integer>();
        kc = new HashMap<Integer, Integer>();
        ck = new HashMap<Integer, LinkedHashSet<Integer>>();
        min = 0;
        size = capacity;
        ck.put(1, new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        if (!kv.containsKey(key)) {
            return -1;
        } else {
            increaseCount(key);
            return kv.get(key);
        }
    }
    
    public void set(int key, int value) {
        if (kv.containsKey(key)) {
            increaseCount(key);
            kv.put(key, value);
        } else if (kv.size() < size) {
            addNewKey(key, value);
        } else {
            int lf = ck.get(min).iterator().next();
            kv.remove(lf);
            kc.remove(lf);
            ck.get(min).remove(lf);
            addNewKey(key, value);
        }
    }
    
    private void increaseCount(int key) {
        int count = kc.get(key);
        if (count == min && ck.get(count).size() == 1) {
            min++;
        }
        kc.put(key, count + 1);
        ck.get(count).remove(key);
        if (ck.get(count + 1) == null) {
            ck.put(count + 1, new LinkedHashSet<Integer>());
        }
        ck.get(count + 1).add(key);
    }
    
    private void addNewKey(int key, int value) {
        kv.put(key, value);
        kc.put(key, 1);
        ck.get(1).add(key);
        min = 1;
    }
}