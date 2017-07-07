/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/k-closest-points
@Language: Java
@Datetime: 17-03-08 20:20
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    Point org;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        org = origin;
        PriorityQueue<Point> heap = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                int diff = getDistance(b) - getDistance(a);
                if (diff != 0) {
                    return diff;
                }
                diff = b.x - a.x;
                if (diff != 0) {
                    return diff;
                }
                return b.y - a.y;
            }
        });
        
        for (Point point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        k = heap.size();
        Point[] result = new Point[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }
        return result;
    }
    
    private int getDistance(Point p) {
        return (p.x - org.x) * (p.x - org.x) + (p.y - org.y) * (p.y - org.y);
    }
}