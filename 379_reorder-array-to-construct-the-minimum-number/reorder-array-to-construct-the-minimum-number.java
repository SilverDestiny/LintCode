/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/reorder-array-to-construct-the-minimum-number
@Language: Java
@Datetime: 17-01-12 18:18
*/

public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] snums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            snums[i] = String.valueOf(nums[i]);
        }
        /*Comparator<String> comp = new Comparator<String>() {
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        };*/
        Arrays.sort(snums, new Comparator<String>() {
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < snums.length; i++) {
            if (i < snums.length - 1 && snums[i].equals("0")) {
                continue;
            }
            sb.append(snums[i]);
        }
        return sb.toString();
    }
}