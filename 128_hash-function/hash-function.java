/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/hash-function
@Language: Java
@Datetime: 17-03-14 22:09
*/

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long res = 0;
        for (int i = 0; i < key.length; i++) {
            res = (res * 33 + key[i]) % HASH_SIZE;
        }
        return (int) res;
    }
};