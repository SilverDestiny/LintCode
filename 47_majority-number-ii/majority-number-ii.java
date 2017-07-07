/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/majority-number-ii
@Language: Java
@Datetime: 17-01-04 02:10
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        /*Collections.sort(nums);
        int major = nums.get(0), count = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == major) {
                count++;
            } else if (count > nums.size() / 3) {
                return major;
            } else {
                major = nums.get(i);
                count = 1;
            }
        }
        return major;*/
        int candidate1 = 0, candidate2 = 0;
        int count1, count2;
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (candidate1 == nums.get(i)) {
                count1 ++;
            } else if (candidate2 == nums.get(i)) {
                count2 ++;
            } else if (count1 == 0) {
                candidate1 = nums.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums.get(i);
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidate1) {
                count1++;
            } else if (nums.get(i) == candidate2) {
                count2++;
            }
        }    
        return count1 > count2 ? candidate1 : candidate2;
    }
}
