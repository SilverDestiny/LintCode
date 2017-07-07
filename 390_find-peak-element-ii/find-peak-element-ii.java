/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/find-peak-element-ii
@Language: Java
@Datetime: 17-02-20 16:20
*/

class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    /*
    public List<Integer> findPeakII(int[][] A) {
        List<Integer> result = new ArrayList<Integer>();
        int start = 1, end = A.length - 2;
        while (start <= end) {
            int i = (start + end) / 2;
            int j = findPeak(A[i]);
            if (A[i][j] < A[i - 1][j]) {
                end = i - 1;
            } else if (A[i][j] < A[i + 1][j]) {
                start = i + 1;
            } else {
                result.add(i);
                result.add(j);
                return result;
            }
        }
        return result;
    }
    
    public int findPeak(int[] A) {
        // write your code here
        int maxIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }*/
    public List<Integer> findPeakII(int[][] A) {
        return find(A, 1, A.length - 2, 1, A[0].length - 2, true);
    }
    
    private List<Integer> find(int[][] A, int rowStart, int rowEnd, int colStart, int colEnd, boolean flag) {
        if (flag) {
            int mid = (rowStart + rowEnd) / 2;
            int index = colStart;
            for (int i = colStart + 1; i <= colEnd; i++) {
                if (A[mid][i] > A[mid][index]) {
                    index = i;
                }
            }
            if (A[mid][index] < A[mid - 1][index]) {
                return find(A, rowStart, mid - 1, colStart, colEnd, !flag);
            } else if (A[mid][index] < A[mid + 1][index]) {
                return find(A, mid + 1, rowEnd, colStart, colEnd, !flag);
            } else {
                return new ArrayList<Integer>(Arrays.asList(mid, index));
            }
        } else {
            int mid = (colStart + colEnd) / 2;
            int index = rowStart;
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                if (A[i][mid] > A[index][mid]) {
                    index = i;
                }
            }
            if (A[index][mid] < A[index][mid - 1]) {
                return find(A, rowStart, rowEnd, colStart, mid - 1, !flag);
            } else if (A[index][mid] < A[index][mid + 1]) {
                return find(A, rowStart, rowEnd, mid + 1, colEnd, !flag);
            } else {
                return new ArrayList<Integer>(Arrays.asList(index, mid));
            }
        }
    }
}
