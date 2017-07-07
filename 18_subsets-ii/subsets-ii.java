/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 16-09-08 00:09
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.size() == 0) {
            return result;
        }
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        result.add(list);
        
        int pos = 0;
        for (int i = 0; i < S.size(); i++) {
            int size = result.size();
            int start = 0;
            if (i != 0 && S.get(i - 1) == S.get(i)) {
                start = pos;
            }
            pos = size;
            for (int j = start; j < size; j++) {
                list = new ArrayList<Integer>(result.get(j));
                list.add(S.get(i));
                result.add(list);
            }
        }
        return result;
    }
}
