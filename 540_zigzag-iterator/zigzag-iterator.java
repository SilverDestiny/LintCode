/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/zigzag-iterator
@Language: Java
@Datetime: 17-02-19 01:47
*/

public class ZigzagIterator {
    /**
     * @param v1 v2 two 1d vectors
     */
    Queue<Integer> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // initialize your data structure here.
        list = new LinkedList<Integer>();
        int i = 0, j = 0;
        
        while (i < v1.size() && j < v2.size()) {
            if (i == j) {
                list.offer(v1.get(i++));
            } else {
                list.offer(v2.get(j++));
            }
        }
        while (i < v1.size()) {
            list.offer(v1.get(i++));
        }
        while (j < v2.size()) {
            list.offer(v2.get(j++));
        }
    }

    public int next() {
        // Write your code here
        return list.poll();
    }

    public boolean hasNext() {
        // Write your code here
        return !list.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */