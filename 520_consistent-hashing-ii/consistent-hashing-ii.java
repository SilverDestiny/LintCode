/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/consistent-hashing-ii
@Language: Java
@Datetime: 17-03-22 14:22
*/

public class Solution {

    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    static int[] machine;
    static int n, k;
    public static Solution create(int n, int k) {
        // Write your code here
        Solution solution = new Solution();
        machine = new int[n];
        for (int i = 0; i < n; i++) {
            machine[i] = -1;
        }
        //macNum = 0;
        Solution.n = n;
        Solution.k = k;
        return solution;
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        // Write your code here
        //macNum++;
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int pos = random.nextInt(n);
            while (machine[pos] != -1) {
                pos = random.nextInt(n);
            }
            machine[pos] = machine_id;
            list.add(pos);
        }
        return list;
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        // Write your code here
        int code = hashcode % n;
        while (machine[code] == -1) {
            code++;
            if (code == n) {
                code = 0;
            }
        }
        return machine[code];
    }
}