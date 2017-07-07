/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/load-balancer
@Language: Java
@Datetime: 17-04-06 01:42
*/

public class LoadBalancer {

    HashSet<Integer> set;
    Random random;
    
    public LoadBalancer() {
        // Initialize your data structure here.
        set = new HashSet<Integer>();
        random = new Random();
    }

    // @param server_id add a new server to the cluster 
    // @return void
    public void add(int server_id) {
        // Write your code here
        set.add(server_id);
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        // Write your code here
        if (set.contains(server_id)) {
            set.remove(server_id);
        }
    }

    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        // Write your code here
        Iterator it = set.iterator();
        int step = random.nextInt(set.size());
        for (int i = 0; i < step; i++) {
            it.next();
        }
        return (int) it.next();
    } 
}