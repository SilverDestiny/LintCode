/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/web-logger
@Language: Java
@Datetime: 17-04-09 21:15
*/

public class WebLogger {

    private Queue<Integer> queue;

    public WebLogger() {
        // initialize your data structure here.
        queue = new LinkedList<Integer>();
    }

    /**
     * @param timestamp an integer
     * @return void
     */
    public void hit(int timestamp) {
        // Write your code here
        queue.offer(timestamp);
    }

    /**
     * @param timestamp an integer
     * @return an integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        // Write your code here
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            queue.poll();
        }
        return queue.size();
    }
}