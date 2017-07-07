/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/heart-beat
@Language: Java
@Datetime: 17-03-27 01:09
*/

public class HeartBeat {
    
    int k;
    HashMap<String, Integer> lastPing;
    
    public HeartBeat() {
        // initialize your data structure here
        lastPing = new HashMap<String, Integer>();
    }

    // @param slaves_ip_list a list of slaves'ip addresses
    // @param k an integer
    // @return void
    public void initialize(List<String> slaves_ip_list, int k) {
        // Write your code here
        this.k = k;
        for (String ip : slaves_ip_list) {
            lastPing.put(ip, 0);
        }
    }

    // @param timestamp current timestamp in seconds
    // @param slave_ip the ip address of the slave server
    // @return nothing
    public void ping(int timestamp, String slave_ip) {
        // Write your code here
        if (lastPing.containsKey(slave_ip)) {
            lastPing.put(slave_ip, timestamp);
        }
    }

    // @param timestamp current timestamp in seconds
    // @return a list of slaves'ip addresses that died
    public List<String> getDiedSlaves(int timestamp) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        for (String ip : lastPing.keySet()) {
            if (timestamp - lastPing.get(ip) >= k * 2) {
                result.add(ip);
            }
        }
        return result;
    }
}