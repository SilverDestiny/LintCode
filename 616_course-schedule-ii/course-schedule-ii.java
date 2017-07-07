/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/course-schedule-ii
@Language: Java
@Datetime: 17-03-08 17:49
*/

public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        ArrayList[] courses = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new ArrayList<Integer>();
        }
        for (int[] prerequisite : prerequisites) {
            courses[prerequisite[1]].add(prerequisite[0]);
            degree[prerequisite[0]]++;
        }
    
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int curt = queue.poll();
            result[index++] = curt;
            Iterator it = courses[curt].iterator();
            while (it.hasNext()) {
                int neighbor = (int) it.next();
                degree[neighbor]--;
                if (degree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (index == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}