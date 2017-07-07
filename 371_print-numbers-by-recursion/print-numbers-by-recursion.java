/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/print-numbers-by-recursion
@Language: Java
@Datetime: 17-01-10 21:30
*/

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
   /* public List<Integer> numbersByRecursion(int n) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            helper(result, i + 1, 0);
        }
        return result;
    }
    
    private void helper(ArrayList<Integer> result, int n, int curt) {
        if (n == 0) {
            result.add(curt);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (i == 0 && curt == 0) {
                continue;
            }
            curt = curt * 10 + i;
            helper(result, n - 1, curt);
            curt = curt /10;
        }
    }*/
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        num(n, 0, res);
        return res;
    }
    
    public void num(int n, int ans,ArrayList<Integer> res){
        
        if(n==0){
            if(ans>0){
                res.add(ans);
            }
            return;
        }
        
        int i;
        for(i=0; i<=9; i++){
            num(n-1, ans*10+i, res);
        }
        
    }
}