/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/majority-number-iii
@Language: Java
@Datetime: 17-02-22 05:12
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    /* O(nlogn)
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        Collections.sort(nums);
        int major = nums.get(0), count = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == major) {
                count++;
            } else if (count > nums.size() / k) {
                return major;
            } else {
                major = nums.get(i);
                count = 1;
            }
        }
        return major;
    }
    */
    
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.size();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else if (map.size() < k) {
                map.put(num, 1);
            } else {
                //need a remove list, or will cause ConcurrentModificationException
                List<Integer> list = new ArrayList<Integer>();
                for (int key : map.keySet()) {
                    if (map.get(key) == 1) {
                        list.add(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                }
                for (int key : list) {
                    map.remove(key);
                }
            }
        }
        
        for (int key : map.keySet()) {
            map.put(key, 0);
        }
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                if (map.get(num) * k > n) {
                    return num;
                }
            }
        }
        return -1;
    }
}
