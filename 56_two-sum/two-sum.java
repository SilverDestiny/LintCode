/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/two-sum
@Language: Java
@Datetime: 16-05-01 22:32
*/

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                result[0] = map.get(numbers[i]) + 1;
                result[1] = i + 1;
                return result;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return result;
    }
}