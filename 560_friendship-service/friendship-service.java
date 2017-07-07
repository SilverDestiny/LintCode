/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/friendship-service
@Language: Java
@Datetime: 17-03-14 01:43
*/

public class FriendshipService { 
    
    HashMap<Integer, List<Integer>> followers;
    HashMap<Integer, List<Integer>> followings;
    public FriendshipService() {
        // initialize your data structure here.
        followers = new HashMap<Integer, List<Integer>>();
        followings = new HashMap<Integer, List<Integer>>();
    }

    // @param user_id an integer
    // return all followers and sort by user_id
    public List<Integer> getFollowers(int user_id) {
        // Write your code here
        if (followers.containsKey(user_id)) {
            Collections.sort(followers.get(user_id));
            return followers.get(user_id);
        }
        return new ArrayList<Integer>();
    }
        
    // @param user_id an integer
    // return all followings and sort by user_id
    public List<Integer>  getFollowings(int user_id) {
        // Write your code here
        if (followings.containsKey(user_id)) {
            Collections.sort(followings.get(user_id));
            return followings.get(user_id);
        }
        return new ArrayList<Integer>();
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!followers.containsKey(from_user_id)) {
            followers.put(from_user_id, new ArrayList<Integer>());
        }
        if (!followers.get(from_user_id).contains(to_user_id)) {
            followers.get(from_user_id).add(to_user_id);
        }
        
        if (!followings.containsKey(to_user_id)) {
            followings.put(to_user_id, new ArrayList<Integer>());
        }
        if (!followings.get(to_user_id).contains(from_user_id)) { 
            followings.get(to_user_id).add(from_user_id);
        }
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (followers.containsKey(from_user_id) && followings.containsKey(to_user_id)) {
            followers.get(from_user_id).remove((Integer) to_user_id);
            followings.get(to_user_id).remove((Integer) from_user_id);
        }
    }
}