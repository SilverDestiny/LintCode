/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/insert-interval
@Language: Java
@Datetime: 17-03-16 03:08
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        // write your code here
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        int pos = 0;
        for (Interval interval : intervals) {
            if (newInterval.start <= interval.start) {
                intervals.add(pos, newInterval);
                break;
            } else {
                pos++;
            }
        }
        if (pos == intervals.size()) {
            intervals.add(pos, newInterval);
        }
        
        int s = intervals.get(0).start, e = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= e) {
                e = Math.max(e, interval.end);
            } else {
                result.add(new Interval(s, e));
                s = interval.start;
                e = interval.end;
            }
        }
        result.add(new Interval(s, e));
        
        return result;
    }
}