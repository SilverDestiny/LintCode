/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/rate-limiter
@Language: Java
@Datetime: 17-04-09 21:57
*/

public class RateLimiter {
    /**
     * @param timestamp the current timestamp
     * @param event the string to distinct different event
     * @param rate the format is [integer]/[s/m/h/d]
     * @param increment whether we should increase the counter
     * @return true or false to indicate the event is limited or not
     */
    
    private HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
     
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        // Write your code here
        int slash = rate.indexOf("/");
        int limit = Integer.parseInt(rate.substring(0, slash));
        String type = rate.substring(slash + 1);
        
        int duration = 1;
        if (type.equals("m"))
            duration = duration * 60;
        else if (type.equals("h"))
            duration = duration * 60 * 60;
        else if (type.equals("d"))
            duration = duration * 60 * 60 * 24;

        if (!map.containsKey(event))
            map.put(event, new ArrayList<Integer>());
        int count = countEvents(map.get(event), timestamp - duration + 1);

        boolean is_ratelimited = count >= limit;
        if (increment && !is_ratelimited)
            map.get(event).add(timestamp);
        return is_ratelimited;
    }
    
    private int countEvents(List<Integer> list, int target) {
        int start = 0, end = list.size() - 1;
        if (end == -1 || list.get(end) < target) {
            return 0;
        }
        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return list.size() - start;
    }
}