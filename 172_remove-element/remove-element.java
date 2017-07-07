/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/remove-element
@Language: Java
@Datetime: 16-12-21 21:07
*/

public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        int newLen = A.length;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            while (left <= right && A[left] != elem) {
                left++;
            }
            while (left <= right && A[right] == elem) {
                right--;
                newLen--;
            }
            if (left < right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
                newLen--;
            }
        }
        
        return newLen;
    }
}
