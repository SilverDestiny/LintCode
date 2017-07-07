/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers-ii
@Language: Java
@Datetime: 16-12-09 00:16
*/

public class Solution {
    
    PriorityQueue<Integer> minHeap;
    int size;
    public Solution(int k) {
        // initialize your data structure here.
        minHeap = new PriorityQueue<Integer>();
        size = k;
    }

    public void add(int num) {
        // Write your code here
        if (minHeap.size() < size) {
            minHeap.offer(num);
            return;
        }
        if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(num);
        }
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        Iterator it = minHeap.iterator();
        while (it.hasNext()) {
            result.add((Integer) it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
};