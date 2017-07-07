/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/memcache
@Language: Java
@Datetime: 17-03-22 16:33
*/

public class Memcache {

    class Node {
        int key, value, time;
        public Node(int key, int value, int time) {
            this.key = key;
            this.value = value;
            this.time = time;
        }
    }
    HashMap<Integer, Node> map;
    PriorityQueue<Node> heap;
    public Memcache() {
        // Initialize your data structure here.
        map = new HashMap<Integer, Node>();
        heap = new PriorityQueue<Node>(11, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return a.time - b.time;
            }
        });
    }

    public int get(int curtTime, int key) {
        // Write your code here
        evict(curtTime);
        if (!map.containsKey(key)) {
            return Integer.MAX_VALUE;
        } else {
            return map.get(key).value;
        }
    }

    public void set(int curtTime, int key, int value, int ttl) {
        // Write your code here
        evict(curtTime);
        Node node = new Node(key, value, curtTime + ttl);
        map.put(key, node);
        if (ttl != 0) {
            heap.offer(node);
        }
    }

    public void delete(int curtTime, int key) {
        // Write your code here
        evict(curtTime);
        if (map.containsKey(key)) {
            map.remove(key);
        }
    }
    
    public int incr(int curtTime, int key, int delta) {
        // Write your code here
        evict(curtTime);
        if (!map.containsKey(key)) {
            return Integer.MAX_VALUE;
        } else {
            map.put(key, new Node(key, map.get(key).value + delta, map.get(key).time));
            return map.get(key).value;
        }
    }

    public int decr(int curtTime, int key, int delta) {
        // Write your code here
        evict(curtTime);
        if (!map.containsKey(key)) {
            return Integer.MAX_VALUE;
        } else {
            map.put(key, new Node(key, map.get(key).value - delta, map.get(key).time));
            return map.get(key).value;
        }
    }
    
    public void evict(int curtTime) {
        while (!heap.isEmpty() && curtTime == heap.peek().time) {
            Node node = heap.poll();
            if (map.containsKey(node.key) && map.get(node.key).time == node.time) {
                map.remove(node.key);
            }
        }
    }
}