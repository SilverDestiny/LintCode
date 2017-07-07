/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/search-in-a-big-sorted-array
@Language: Java
@Datetime: 17-03-06 01:42
*/

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if not exists.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // Algorithm:
        // 1. get the index that ArrayReader.get(index) >= target or == -1 in
        //    O(logk)
        // 2. Binary search the target between 0 and index
        int index = 1;
        while (reader.get(index - 1) < target && reader.get(index - 1) != -1) {
            index = index * 2;
        }
        
        int start = index / 2, end = index - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target && reader.get(mid) != -1) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        if (reader.get(start) == target) {
            return start;
        }
        return -1;
    }
}