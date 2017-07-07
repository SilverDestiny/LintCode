/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/building-outline
@Language: Java
@Datetime: 17-02-05 01:32
*/

public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    class Point {
        int index, height;
        public Point(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<Point> points = new ArrayList<Point>();
        for (int[] building : buildings) {
            points.add(new Point(building[0], -building[2]));
            points.add(new Point(building[1], building[2]));
        }
        Collections.sort(points, new Comparator<Point>() {
           public int compare(Point a, Point b) {
               return a.index == b.index ? a.height - b.height : a.index - b.index;
           } 
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, Collections.reverseOrder());
        maxHeap.offer(0);
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        int prev = 0;
        for (Point point : points) {
            if (point.height < 0) {
                maxHeap.offer(-point.height);
            } else {
                //HashHeap can optimize remove operation in heap
                maxHeap.remove(point.height);
            }
            int curt = maxHeap.peek();
            if (curt != prev) {
                if (prev == 0) {
                    path.add(point.index);
                } else {
                    path.add(point.index);
                    path.add(prev);
                    result.add(new ArrayList<Integer>(path));
                    path.clear();
                    if (curt != 0) {
                        path.add(point.index);
                    }
                }
                prev = curt;
            }
        }
        return result;
    }
}