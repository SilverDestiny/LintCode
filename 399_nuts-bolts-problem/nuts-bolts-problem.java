/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/nuts-bolts-problem
@Language: Java
@Datetime: 17-02-08 02:29
*/

/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        quickSort(nuts, bolts, 0, nuts.length - 1, compare);
    }
    
    private void quickSort(String[] nuts, String[] bolts, int start, int end, NBComparator compare) {
        if (start >= end) {
            return;
        }
        int index = partition(nuts, bolts, start, end, compare, start);
        partition(bolts, nuts, start, end, compare, index);
        quickSort(nuts, bolts, start, index - 1, compare);
        quickSort(nuts, bolts, index + 1, end, compare);
    }
    
    private int partition(String[] set1, String[] set2, int start, int end, NBComparator compare, int index) {
        String pivot = set1[index];
        for (int i = start; i <= end; i++) {
            if (compare.cmp(set2[i], pivot) == 0 || compare.cmp(pivot, set2[i]) == 0) {
                swap(set2, i, end);
                break;
            }
        }
        
        int i = start, j = end - 1;
        while (i <= j) {
            if (compare.cmp(set2[i], pivot) == -1 || compare.cmp(pivot, set2[i]) == 1) {
                i++;
            } else if (compare.cmp(set2[j], pivot) == 1 || compare.cmp(pivot, set2[j]) == -1) {
                j--;
            } else {
                swap(set2, i, j);
                i++;
                j--;
            }
        }
        swap(set2, i, end);
        return i;
    }
    
    private void swap(String[] set, int i, int j) {
        String temp = set[i];
        set[i] = set[j];
        set[j] = temp;
    }
};