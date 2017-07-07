/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/two-sum-data-structure-design
@Language: Java
@Datetime: 17-01-30 01:10
*/

public class TwoSum {
    
    HashMap<Integer, Integer> map;
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }
    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if (map.containsKey(number)) {
            map.put(number, 2);
        } else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for (Integer key : map.keySet()) {
            if ((key * 2 == value && map.get(key) == 2) || 
                (key * 2 != value && map.containsKey(value - key))) {
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);