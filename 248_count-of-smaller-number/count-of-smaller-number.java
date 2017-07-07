/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number
@Language: Java
@Datetime: 17-02-12 01:35
*/

public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    
    /* 
    //O(kn)
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 0;
        for (int query : queries) {
            count = 0;
            for (int a : A) {
                if (a < query) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }
    */
    
    //O(nlongn + klogn)
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(A);
        for (int query : queries) {
            result.add(binarySearch(A, query));
        }
        return result;
    }
    
    private int binarySearch(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0, end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (A[start] < target) {
            return start + 1;
        }
        return start;
    }
}
