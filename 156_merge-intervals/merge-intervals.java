/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/merge-intervals
@Language: Java
@Datetime: 17-03-16 03:11
*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        List<Interval> result = new ArrayList<Interval>();
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