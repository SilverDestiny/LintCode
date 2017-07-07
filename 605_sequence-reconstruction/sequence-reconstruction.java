/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/sequence-reconstruction
@Language: Java
@Datetime: 17-01-28 20:00
*/

public class Solution {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Write your code here
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> degree = new HashMap<Integer, Integer>();
        
        int count = 0;
        for (int i = 0; i < seqs.length; i++) {
            for (int j = 0; j < seqs[i].length - 1; j++) {
                if (!map.containsKey(seqs[i][j])) {
                    map.put(seqs[i][j], new ArrayList<Integer>());
                    count++;
                }
                map.get(seqs[i][j]).add(seqs[i][j + 1]);
                if (!degree.containsKey(seqs[i][j + 1])) {
                    degree.put(seqs[i][j + 1], 1);
                } else {
                    degree.put(seqs[i][j + 1], degree.get(seqs[i][j + 1]) + 1);
                }
            }
        }
        for (int i = 0; i < seqs.length; i++) {
            if (seqs[i].length != 0 && !map.containsKey(seqs[i][seqs[i].length - 1])) {
                map.put(seqs[i][seqs[i].length - 1], new ArrayList<Integer>());
                count++;
            }
        }
        if (count < org.length) {
            return false;
        }
        if (count == 0 && org.length == 0) {
            return true;
        }
        
        if (count > org.length) {
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        if (!degree.containsKey(org[0])) {
            queue.offer(org[0]);
        } else {
           return false;
        }
        int index = 1;
        
        while (queue.size() == 1 && index < org.length) {
            int temp = queue.poll();
            if (map.containsKey(temp)) {
                for (int value : map.get(org[index - 1])) {
                    degree.put(value, degree.get(value) - 1);
                    if (degree.get(value) == 0) {
                        queue.offer(value);
                    }
                }
            } else {
                return false;
            }
            index++;
        }
        return index == org.length;
    }
}