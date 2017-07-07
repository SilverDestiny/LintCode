/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/consistent-hashing
@Language: Java
@Datetime: 17-03-20 15:52
*/

public class Solution {
    /**
     * @param n a positive integer
     * @return n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        PriorityQueue<ArrayList<Integer>> heap = new PriorityQueue<ArrayList<Integer>>(n, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int diff = (b.get(1) - b.get(0)) - (a.get(1) - a.get(0));
                if (diff == 0) {
                    return a.get(2) - b.get(2);
                }
                return diff;
            }
        });
        int index = 1;
        
        while (index <= n) {
            ArrayList<Integer> interval = new ArrayList<Integer>();
            if (index == 1) {
                interval.add(0);
                interval.add(359);
                interval.add(index++);
                result.add(interval);
            } else {
                ArrayList<Integer> temp = heap.poll();
                int x = temp.get(0);
                int y = temp.get(1);
                temp.set(1, (x + y) / 2);
                interval.add(temp.get(1) + 1);
                interval.add(y);
                interval.add(index++);
                result.add(result.indexOf(temp), interval);
                heap.offer(temp);
            }
            heap.offer(interval);
        }
        return result;
    }
}