/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-arrays
@Language: Java
@Datetime: 17-03-06 00:27
*/

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    class Node {
        int val, row;
        public Node(int val, int row) {
            this.val = val;
            this.row = row;
        }
    }
     
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (arrays == null || arrays.length == 0) {
            return result;
        }
        int k = arrays.length;
        PriorityQueue<Node> heap = new PriorityQueue<Node>(k, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });
        int[] pointers = new int[k];
        for (int i = 0; i < k; i++) {
            if (arrays[i].length > 0) {
                heap.offer(new Node(arrays[i][0], i));
                pointers[i] = 1;
            }
        }
        
        while (!heap.isEmpty()) {
            Node temp = heap.poll();
            result.add(temp.val);
            if (pointers[temp.row] < arrays[temp.row].length) {
                heap.offer(new Node(arrays[temp.row][pointers[temp.row]], temp.row));
                pointers[temp.row]++;
            }
        }
        return result;
    }
}