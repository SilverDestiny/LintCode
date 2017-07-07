/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/number-of-airplanes-in-the-sky
@Language: Java
@Datetime: 17-02-03 03:10
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
/*
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     *
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        for (Interval airplane : airplanes) {
            for (int i = airplane.start; i < airplane.end; i++) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
                result = Math.max(result, map.get(i));
            }
        }
        return result;
    }
}
*/

class Point{
    int time;
    boolean flag;

    Point(int t, boolean s){
      this.time = t;
      this.flag = s;
    }
}
  
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        List<Point> list = new ArrayList<>(airplanes.size()*2);
        for(Interval i : airplanes){
          list.add(new Point(i.start, false));
          list.add(new Point(i.end, true));
        }
    
        Collections.sort(list, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.time == b.time) {
                    return a.flag ? -1 : 1;
                } else {
                    return a.time - b.time;
                }
            }
        });
        
        int count = 0, ans = 0;
        for (Point p : list){
          if (!p.flag) {
            count++;
            ans = Math.max(ans, count);
          } else {
            count--;
          }
        }
    
        return ans;
    }
}