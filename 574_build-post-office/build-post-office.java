/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/build-post-office
@Language: Java
@Datetime: 17-02-07 02:34
*/

public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1}; 
    
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Integer> xs = new ArrayList<Integer>();
        ArrayList<Integer> ys = new ArrayList<Integer>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    nodes.add(new Node(i, j));
                    xs.add(i);
                    ys.add(j);
                }
            }
        }
        
        if (nodes.size() == m * n) {
            return -1;
        }
        if (nodes.size() == 0) {
            return 0;
        }
        
        int xMedian = median(xs);
        int yMedian = median(ys);
        
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(xMedian, yMedian));
        visited[xMedian][yMedian] = true;
        int min = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                if (grid[temp.x][temp.y] == 0) {
                    min = Math.min(min, calDistance(temp, nodes));
                }
                for (int j = 0; j < 8; j++) {
                    int x = temp.x + dx[j];
                    int y = temp.y + dy[j];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        queue.offer(new Node(x, y));
                        visited[x][y] = true;
                    }
                }
            }
            if (min != Integer.MAX_VALUE) {
                return min;
            }
        }
        
        return -1;
    }
    
    private int calDistance(Node temp, ArrayList<Node> nodes) {
        int sum = 0;
        for (Node node : nodes) {
            sum += Math.abs(temp.x - node.x) + Math.abs(temp.y - node.y);
        }
        return sum;
    }
    /*
    private int median(ArrayList<Integer> arr){
        Collections.sort(arr);

        int Median = arr.get(arr.size() / 2);

        if(arr.size() % 2 == 0){
            Median = (Median + arr.get(arr.size() / 2 - 1)) / 2;
        }

        return Median;
    }
    */
    
    private int median(ArrayList<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        int size = nums.size();
        if (size % 2 == 1) {
            return quickSelect(nums, 0, size - 1, size / 2 + 1);
        } else {
            return (quickSelect(nums, 0, size - 1, size / 2) + quickSelect(nums, 0, size - 1, size / 2 + 1)) / 2;
        }
    }
    
    private int quickSelect(ArrayList<Integer> nums, int start, int end, int k) {
        if (start == end) {
            return nums.get(start);
        }
        
        int i = start, j = end;
        int pivot = nums.get((start + end) / 2);
        while (i <= j) {
            if (nums.get(i) < pivot) {
                i++;
            } else if (nums.get(j) > pivot) {
                j--;
            } else {
                int temp = nums.get(i);
                nums.set(i, nums.get(j));
                nums.set(j, temp);
                i++;
                j--;
            }
        }
        
        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }
        if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        }
        return nums.get(j + 1);
    }
}