/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/zigzag-iterator-ii
@Language: Java
@Datetime: 17-02-19 02:06
*/

public class ZigzagIterator2 {
    /**
     * @param vecs a list of 1d vectors
     */
    Queue<Iterator> queue;
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        // initialize your data structure here.
        queue = new LinkedList<Iterator>();
        for (ArrayList<Integer> vec : vecs) {
            if (!vec.isEmpty()) {
                queue.offer(vec.iterator());
            }
        }
    }

    public int next() {
        // Write your code here
        Iterator curt = queue.poll();
        int result = (int) curt.next();
        if (curt.hasNext()) {
            queue.offer(curt);
        }
        return result;
    }

    public boolean hasNext() {
        // Write your code here   
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */