/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/high-five
@Language: Java
@Datetime: 17-01-30 20:35
*/

/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        HashMap<Integer, Double> avg = new HashMap<Integer, Double>();
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for (Record result : results) {
            if (!map.containsKey(result.id)) {
                map.put(result.id, new PriorityQueue<Integer>(5));
                map.get(result.id).offer(result.score);
            } else {
                if (map.get(result.id).size() < 5) {
                    map.get(result.id).offer(result.score);
                } else if (result.score > map.get(result.id).peek()) {
                    map.get(result.id).poll();
                    map.get(result.id).offer(result.score);
                }
            }
        }
        
        for (Integer key : map.keySet()) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += map.get(key).poll();
            }
            avg.put(key, sum / 5.0);
        }
        return avg;
    }
}