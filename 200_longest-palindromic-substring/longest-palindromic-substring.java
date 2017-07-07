/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/longest-palindromic-substring
@Language: Java
@Datetime: 17-02-11 23:31
*/

public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    private int lo, maxLen;

    public String longestPalindrome(String s) {
    	int len = s.length();
    	if (len < 2)
    		return s;
    	
        for (int i = 0; i < len-1; i++) {
         	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
         	extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }
    
    private void extendPalindrome(String s, int j, int k) {
    	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
    		j--;
    		k++;
    	}
    	if (maxLen < k - j - 1) {
    		lo = j + 1;
    		maxLen = k - j - 1;
    	}
    }

    
    /* Manacher's Algorithm
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int length = s.length();    
        int max = 0;
        String result = "";
        for(int i = 1; i <= 2 * length - 1; i++){
            int count = 1;
            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
                count++;
            }
            count--; // there will be one extra count for the outbound #
            if(count > max) {
                result = s.substring((i - count) / 2, (i + count) / 2);
                max = count;
            }
        }
        
        return result;
    }
    
    private char get(String s, int i) {
        if(i % 2 == 0)
            return '#';
        else 
            return s.charAt(i / 2);
    }
    */
}