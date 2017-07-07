/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/roman-to-integer
@Language: Java
@Datetime: 17-02-24 23:37
*/

public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        // Write your code here
        if (s == null || s.length()==0) {
                return 0;
	    }
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    map.put('I', 1);
	    map.put('V', 5);
	    map.put('X', 10);
	    map.put('L', 50);
	    map.put('C', 100);
	    map.put('D', 500);
	    map.put('M', 1000);
	    
	    int result = map.get(s.charAt(s.length() - 1));
	    for (int i = s.length() - 2; i >= 0; i--) {
	        if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
	            result += map.get(s.charAt(i));
	        } else {
	            result -= map.get(s.charAt(i));
	        }
	    }
	    return result;
    }
}